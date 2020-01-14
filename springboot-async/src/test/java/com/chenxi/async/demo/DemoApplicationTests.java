package com.chenxi.async.demo;

import com.chenxi.async.demo.task.AsyncTask;
import com.chenxi.async.demo.task.CallableTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@SpringBootTest
@Slf4j
class DemoApplicationTests {
  @Autowired
  private AsyncTask task;
    @Test
    void contextLoads() {
        task.sayByeBye();
        task.sayHello();
        System.out.println("it is over");
    }
    @Test
    public void asyncTaskTest() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = task.sayHelloReturn();
        Future<String> task2 = task.sayByeReturn();

        // 三个任务都调用完成，退出循环等待
        while (!task1.isDone() || !task2.isDone()) {
            log.info(task1.get());
            log.info(task2.get());
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();
       log.info("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    void testAsyncUtil() {
        for(int i=0;i<10000;i++) {
            testAsync();
        }
    }

    public void testAsync() {
        List<CallableTask> callableTaskList=new ArrayList<>();
        for(int i=0;i<3;i++) {
            callableTaskList.add(new CallableTask(String.valueOf(i)));

        }
        AsyncExecutUtil.execute(callableTaskList);
    }
}
