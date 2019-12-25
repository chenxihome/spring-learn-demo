package com.chenxi.redisdelayed.controller;

import com.chenxi.redisdelayed.common.Constants;
import com.chenxi.redisdelayed.service.biz.OrderItemDelayedServiceImpl;
import com.chenxi.redisdelayed.service.common.ItemDelayed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by tukun on 2019/12/20.
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderItemDelayedServiceImpl orderItemDelayedService;
    @GetMapping("/create")
    public boolean createOrder(){
        String orderNo= UUID.randomUUID().toString();
        ItemDelayed itemDelayed=new ItemDelayed();
        itemDelayed.setBizId(orderNo);
        itemDelayed.setDelayedQueueName(Constants.CANCEL_ORDER_DELAYORDERQUEUE);
        Long startTime=System.currentTimeMillis();
        itemDelayed.setStartTime(startTime);
        itemDelayed.setExpireTime(startTime+60*1000*5);
        orderItemDelayedService.addToItemDelayQueue(itemDelayed);
        log.info("创建订单成功！订单号：{},订单取消时间：5分钟",orderNo);
        return Boolean.TRUE;
    }
    @GetMapping("/pay/{orderno}")
    public boolean payOrder(@PathVariable("orderno") String orderno){
        orderItemDelayedService.removeToItemDelayQueue(orderno);
        return Boolean.TRUE;
    }
}
