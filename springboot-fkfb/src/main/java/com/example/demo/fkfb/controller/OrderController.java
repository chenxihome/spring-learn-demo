package com.example.demo.fkfb.controller;

import cn.hutool.core.date.DateUtil;
import com.example.demo.fkfb.orm.entity.Order;
import com.example.demo.fkfb.orm.mapper.OrderMapper;
import com.example.demo.fkfb.util.IdGenerateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/**
 * Created by tukun on 2020/1/9.
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    @Qualifier("crawlExecutorPool")
    private ExecutorService pool;
    @GetMapping("creat/{userId}")
    public Boolean createOrder(@PathVariable("userId") Long  userId) {
        Order record=new Order();
        Random rm = new Random();
        record.setOrderId(Long.valueOf(IdGenerateUtil.getUniqueId()));
        record.setOrderPrice(new BigDecimal(rm.nextInt(50000)+1));
        record.setSkuId(rm.nextInt(100000)+1);
        record.setUserId(userId);
        record.setStatus(new Byte(String.valueOf(0)));
        record.setInsertTime(DateUtil.date(new Date()));
        record.setUpdateTime(DateUtil.date(new Date()));
        orderMapper.insertSelective(record);
        log.info("订单数据保存成功！订单号：{},userid：{},在：test_order_{}库,order_{}表",record.getOrderId(),record.getUserId(),(record.getUserId()%64)/16,(record.getUserId()%64)%16);
        return Boolean.TRUE;
    }
    @GetMapping("/test")
    public void test() {
        for(int i=0;i<=5000000;i++) {
            createOrder(new Long(i));
        }
    }
    @GetMapping("/query/{userId}")
    public void query(@PathVariable("userId") Long userId) {
     List<Order> orderList= orderMapper.selectByUserId(userId);
     log.info("查询用户订单号列表：{},userId:{}", CollectionUtils.isEmpty(orderList)?"":orderList.toString(),userId);
    }

    @GetMapping("/radom")
    public void radom() {
        for(int i=0;i<10;i++) {
            long start=System.currentTimeMillis();
            pool.execute(() -> {
                try {
                    Thread.sleep(10);
                    async();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long time=System.currentTimeMillis()-start;
               log.info(Thread.currentThread().getName() + "======任务执行完成====== 耗时："+time);
            });
        }
    }



    private void async() {
        Random rm = new Random();
        for(int i=0;i<=50;i++) {
            createOrder(new Long(rm.nextInt(100000000)+1));
        }
    }


}
