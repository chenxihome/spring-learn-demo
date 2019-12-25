package com.chenxi.redisdelayed.service.common;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by tukun on 2019/12/20.
 */
@Setter
@Getter
public class ItemDelayed{
    /**
     * 唯一标识id
     */
    private String bizId;
    /**
     * 创建时间
     */
    private Long startTime;
    /**
     * 失效时间
     */
    private Long expireTime;
    /**
     * 延时队列名称
     */
    private String delayedQueueName;
   // private T data;

    public Long getDeLayTime() {
        return expireTime-System.currentTimeMillis();
    }
}
