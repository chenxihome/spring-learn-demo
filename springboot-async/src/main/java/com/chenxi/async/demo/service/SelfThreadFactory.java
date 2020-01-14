package com.chenxi.async.demo.service;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tukun on 2020/1/9.
 */
public class SelfThreadFactory implements ThreadFactory {
    private static AtomicInteger tag = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("自定义调度器线程："+ tag.getAndIncrement());
        return thread;
    }
}
