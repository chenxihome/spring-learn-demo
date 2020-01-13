package com.example.demo.fkfb.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tukun on 2020/1/9.
 */
public class DBopThreadFactory implements ThreadFactory {
    private static AtomicInteger tag = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("分库分表db调度器线程："+ tag.getAndIncrement());
        return thread;
    }
}
