package com.example.demo.fkfb.config.algorithm;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.google.common.collect.Range;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 这里使用的都是单键分片策略
 * 示例分库策略是：
 * floor(userId%64)/16
 *
 *
 */
@Component
public class DatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<Long> {
    @Override
    public String doEqualSharding(Collection<String> databases, ShardingValue<Long> shardingValue) {
        for (String each : databases) {
            if (each.endsWith((shardingValue.getValue() % 64)/16 + "")) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> databases, ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(databases.size());
        for (Long value : shardingValue.getValues()) {
            for (String tableName : databases) {
                if (tableName.endsWith((value % 64)/16+ "")) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> databases, ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(databases.size());
        Range<Long> range = (Range<Long>) shardingValue.getValueRange();
        for (Long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String each : databases) {
                if (each.endsWith((i % 64)/16 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
