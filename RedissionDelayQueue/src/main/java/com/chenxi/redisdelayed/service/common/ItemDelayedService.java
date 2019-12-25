package com.chenxi.redisdelayed.service.common;

/**
 * Created by tukun on 2019/12/20.
 */
public interface ItemDelayedService {
    /**
     * 添加延迟对象到延时队列
     *
     * @param itemDelayed 延迟对象
     * @return boolean
     */
    boolean addToItemDelayQueue(ItemDelayed itemDelayed);

    /**
     * 移除指定的延迟对象从延时队列中
     *
     * @param bizNo
     */
    void removeToItemDelayQueue(String bizNo);


}
