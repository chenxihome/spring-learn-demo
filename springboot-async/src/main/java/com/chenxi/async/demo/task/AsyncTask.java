package com.chenxi.async.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import java.util.concurrent.Future;

@Slf4j
@Component
public class AsyncTask {
    @Async()
    public void sayHello(){
       log.info("say hello");
    }


    @Async
    public void sayByeBye(){
        int i=1/0;
        log.info("say Bye");
    }

    @Async
    public Future<String> sayByeReturn(){
        long start=System.currentTimeMillis();
        log.info("say Bye for return");
        log.info("任务一执行成功耗时：{}",System.currentTimeMillis()-start+"毫秒");
        return new AsyncResult<>("任务一完成");

    }

    @Async
    public Future<String> sayHelloReturn(){
        long start=System.currentTimeMillis();
        log.info("sayHello for return");
        log.info("任务二执行成功耗时：{}",System.currentTimeMillis()-start+"毫秒");
        return new AsyncResult<>("任务二完成");

    }
}
