package com.chenxi.spi.service.impl;

import com.chenxi.spi.service.IHelloService;
import org.springframework.stereotype.Service;

/**
 * Created by tukun on 2019/12/25.
 */
@Service
public class ChineseHelloServiceImpl implements IHelloService{
    @Override
    public void sayHello() {
        System.out.println("您好！中国");
    }
}
