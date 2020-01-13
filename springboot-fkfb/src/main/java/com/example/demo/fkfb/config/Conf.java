package com.example.demo.fkfb.config;

import com.example.demo.fkfb.core.DBopThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tukun on 2020/1/9.
 */
@Configuration
public class Conf {

    @Bean(name = "crawlExecutorPool")
    public ExecutorService crawlExecutorPool() {
        // 获取Java虚拟机的可用的处理器数，最佳线程个数，处理器数*2。根据实际情况调整
        //int curSystemThreads = Runtime.getRuntime().availableProcessors() * 2;
        int curSystemThreads =10;
        System.out.println("------------系统可用线程池个数：" + curSystemThreads);
        // 创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(curSystemThreads, new DBopThreadFactory());
        return pool;
    }
}
