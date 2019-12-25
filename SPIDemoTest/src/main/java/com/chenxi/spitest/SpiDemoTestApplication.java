package com.chenxi.spitest;

import com.chenxi.spi.service.IHelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.ServiceLoader;
@SpringBootApplication
public class SpiDemoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpiDemoTestApplication.class, args);
		ServiceLoader<IHelloService> serviceLoader=ServiceLoader.load(IHelloService.class);
		Iterator<IHelloService> iterator = serviceLoader.iterator();
		while (iterator.hasNext()){
			IHelloService helloService = iterator.next();
			helloService.sayHello();
		}
	}

}
