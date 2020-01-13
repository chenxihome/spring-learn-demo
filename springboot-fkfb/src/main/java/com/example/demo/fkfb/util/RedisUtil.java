package com.example.demo.fkfb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * Created by tukun on 2019/12/27.
 */
@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private  static StringRedisTemplate stringRedisTemplate;
    @PostConstruct
    public void init() {
        stringRedisTemplate=redisTemplate;
    }

    public static String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
    public static void setEx(String key, String value, long timeout, TimeUnit unit) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, unit);
    }
}
