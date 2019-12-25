package com.chenxi.redisdelayed.service.biz;
import com.chenxi.redisdelayed.common.Constants;
import com.chenxi.redisdelayed.service.common.ItemDelayed;
import com.chenxi.redisdelayed.service.common.ItemDelayedService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by tukun on 2019/12/20.
 */
@Service
@Slf4j
@Lazy(false)
public class OrderItemDelayedServiceImpl implements ItemDelayedService{
    @Autowired
    private RedissonClient redissonClient;


    ExecutorService cachedThreadPool = Executors.newFixedThreadPool(1);

    @Override
    public boolean addToItemDelayQueue(ItemDelayed itemDelayed) {
        if(itemDelayed.getDeLayTime()<0) {
            return Boolean.FALSE;
        }
        RBlockingQueue<String> blockingFairQueue = redissonClient.getBlockingQueue(itemDelayed.getDelayedQueueName());
        RDelayedQueue<String> delayedQueue = redissonClient.getDelayedQueue(blockingFairQueue);
        long delayTime=itemDelayed.getDeLayTime();
        delayedQueue.offer(itemDelayed.getBizId(),delayTime,TimeUnit.MILLISECONDS);
        return Boolean.TRUE;
    }

    @Override
    public void removeToItemDelayQueue(String bizNo) {
        RBlockingQueue<String> blockingFairQueue = redissonClient.getBlockingQueue(Constants.CANCEL_ORDER_DELAYORDERQUEUE);
        for (Iterator<String> iterator = blockingFairQueue.iterator(); iterator.hasNext(); ) {
            String queue = iterator.next();
            if (queue.equals(bizNo)) {
                blockingFairQueue.remove(queue);
                log.info("支付成功啦：{}",bizNo);
                break;
            }
        }
    }

    //***启动一个线程 读取过期队列
    @PostConstruct
    public void  init() {
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                RBlockingQueue<String> blockingFairQueue = redissonClient.getBlockingQueue(Constants.CANCEL_ORDER_DELAYORDERQUEUE);
                while (true) {
                    try {
                        String   orderDTO = blockingFairQueue.take();
                        //TODO  取消订单  幂等操作
                        log.info("订单被成功取消了！ 订单号：{}", orderDTO);
                    } catch (InterruptedException e) {
                       log.error("延时队列异常",e);
                    }
                }
            }
        });
    }


}
