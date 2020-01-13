package com.example.demo.fkfb.config.algorithm;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 这里使用的都是单键分片策略
 * 示例分表策略是：
 * floor(userId%64)%16
 *
 *
 */
@Component
public class TableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Long> {
    @Override
    public String doEqualSharding(Collection<String> tables, ShardingValue<Long> shardingValue) {
        for (String each : tables) {
            if (each.endsWith((shardingValue.getValue() % 64)%16 + "")) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> tables, ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tables.size());
        for (Long value : shardingValue.getValues()) {
            for (String tableName : tables) {
                if (tableName.endsWith((value % 64)%16+ "")) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> tables, ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tables.size());
        Range<Long> range = (Range<Long>) shardingValue.getValueRange();
        for (Long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String each : tables) {
                if (each.endsWith((i % 64)%16 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
