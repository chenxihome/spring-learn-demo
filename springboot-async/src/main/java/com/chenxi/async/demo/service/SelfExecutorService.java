package com.chenxi.async.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class SelfExecutorService implements InitializingBean, DisposableBean {

    private ExecutorService threadPool ;

    /**
     * Set the ThreadPoolExecutor's core pool size.
     */
    private int corePoolSize = 10;
    /**
     * Set the ThreadPoolExecutor's maximum pool size.
     */
    private int maxPoolSize = 30;

    @Override
    public void destroy() throws Exception {
        threadPool.shutdownNow();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        threadPool =new ThreadPoolExecutor(corePoolSize, maxPoolSize,
                 0L, TimeUnit.MILLISECONDS,
                 new LinkedBlockingQueue<Runnable>(),new SelfThreadFactory());
    }
    public ExecutorService  getExecutor() {
        return threadPool;
    }
}
