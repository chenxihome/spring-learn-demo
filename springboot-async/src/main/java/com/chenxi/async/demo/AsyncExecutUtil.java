package com.chenxi.async.demo;

import com.chenxi.async.demo.service.SelfExecutorService;
import com.chenxi.async.demo.task.CallableTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


@Component
@Slf4j
public class AsyncExecutUtil {

    @Autowired
    private  SelfExecutorService selfExecutorService;
    private static SelfExecutorService executorService;

    @PostConstruct
    public void init() {
        executorService=selfExecutorService;
    }

    public static List<String> execute(List<CallableTask> tasks) {
        Long start = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        //返回数据结果集
        ExecutorService exs = executorService.getExecutor();
        try {
            //futureList监控结果集
            List<Future<String>> futureList = new ArrayList<Future<String>>();

            //待执行任务，每个任务返回一个Future存储futureList
            for (CallableTask callableTask : tasks) {
                futureList.add(exs.submit(callableTask));
            }
            //2.结果归集，用迭代器遍历futureList,高速轮询，任务完成就移除
            while(futureList.size() > 0){
                Iterator<Future<String>> iterable = futureList.iterator();
                //遍历一遍
                while(iterable.hasNext()){
                    Future<String> future = iterable.next();
                    //如果任务完成取结果，否则判断下一个任务是否完成
                    if (future.isDone() && !future.isCancelled()){
                        //获取结果
                        String resultstr = future.get();
                        list.add(resultstr);
                        //任务完成移除任务
                        iterable.remove();
                    }else{
                        Thread.sleep(1);//避免CPU高速运转，这里休息1毫秒，CPU纳秒级别,避免CPU高速轮循耗空CPU
                    }
                }
            }
            log.info("#####executeAsyncTask 总耗时：" + (System.currentTimeMillis() - start) +"ms,返回resultList:"+list.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //exs.shutdown();
        }
        return list;
    }
}
