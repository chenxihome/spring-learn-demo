package com.chenxi.spi.controller;


import com.chenxi.spi.service.IHelloService;
import com.chenxi.spi.service.impl.AmericanHelloServiceImpl;
import com.chenxi.spi.service.impl.ChineseHelloServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tukun on 2019/12/25.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/say")
    public void test() {
         IHelloService chinaService=new ChineseHelloServiceImpl();
         chinaService.sayHello();
         IHelloService usaService= new AmericanHelloServiceImpl();
         usaService.sayHello();
     }


}
