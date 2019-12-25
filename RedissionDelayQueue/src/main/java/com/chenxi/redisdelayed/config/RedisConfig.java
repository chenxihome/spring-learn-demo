package com.chenxi.redisdelayed.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Created by tukun on 2019/12/20.
 */
@Configuration
public class RedisConfig {
    @Value("${spring.redis.cluster.nodes}")
    private String redisAddress;
    @Value("${spring.redis.cluster.scan-interval}")
    private int sanInterval;

@Bean
public RedissonClient getRedissonClient() throws IOException {
    String[] nodes = redisAddress.split(",");
    // redisson版本是3.5，集群的ip前面要加上“redis://”，不然会报错，3.2版本可不加
    for (int i = 0; i < nodes.length; i++) {
        nodes[i] = "redis://" + nodes[i];
    }
    RedissonClient redisson = null;
    Config config = new Config();
    config.useClusterServers()
            .setScanInterval(sanInterval)
            .addNodeAddress(nodes);
    redisson = Redisson.create(config);
    System.out.println(redisson.getConfig().toJSON().toString());
    return redisson;
}
}
