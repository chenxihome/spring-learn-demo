package com.chenxi.async.demo.task;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
@Slf4j
public class CallableTask implements Callable {
    private String url;
    private String paramMap;
    private String key;

    public CallableTask(String url, String paramMap, String key) {
        this.url = url;
        this.paramMap = paramMap;
        this.key = key;
    }

    public CallableTask(String key) {
        this.key = key;
    }

    @Override
    public Object call() throws Exception {
        long start=System.currentTimeMillis();
        log.info("执行key:{}",key);
        log.info("执行key:{},完成，耗时：{}",key,System.currentTimeMillis()-start);
        return key;
    }
}
