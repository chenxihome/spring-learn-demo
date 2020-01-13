package com.example.demo.fkfb.config.db;

import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.example.demo.fkfb.config.algorithm.DatabaseShardingAlgorithm;
import com.example.demo.fkfb.config.algorithm.TableShardingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.dangdang.ddframe.rdb.sharding.keygen.DefaultKeyGenerator;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangyang
 * @date 2019/1/29
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private Database0Config database0Config;

    @Autowired
    private Database1Config database1Config;

    @Autowired
    private Database2Config database2Config;

    @Autowired
    private Database3Config database3Config;

    @Autowired
    private DatabaseShardingAlgorithm databaseShardingAlgorithm;

    @Autowired
    private TableShardingAlgorithm tableShardingAlgorithm;

    @Bean
    public DataSource getDataSource() throws SQLException {
        return buildDataSource();
    }

    private DataSource buildDataSource() throws SQLException {
        //分库设置
        Map<String, DataSource> dataSourceMap = new HashMap<>(4);
        //添加两个数据库database0和database1
        dataSourceMap.put(database0Config.getDatabaseName(), database0Config.createDataSource());
        dataSourceMap.put(database1Config.getDatabaseName(), database1Config.createDataSource());
        dataSourceMap.put(database2Config.getDatabaseName(), database2Config.createDataSource());
        dataSourceMap.put(database3Config.getDatabaseName(), database3Config.createDataSource());
        //设置默认数据库
        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap, database0Config.getDatabaseName());

        //分表设置，大致思想就是将查询虚拟表order根据一定规则映射到真实表中去
        TableRule orderTableRule = TableRule.builder("order")
                .actualTables(Arrays.asList("order_0", "order_1","order_2", "order_3","order_4", "order_5","order_6", "order_7","order_8", "order_9","order_10", "order_11","order_12", "order_13","order_14", "order_15"))
                .dataSourceRule(dataSourceRule)
                .build();

        //分库分表策略
        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(dataSourceRule)
                .tableRules(Arrays.asList(orderTableRule))
                .databaseShardingStrategy(new DatabaseShardingStrategy("user_id", databaseShardingAlgorithm))
                .tableShardingStrategy(new TableShardingStrategy("user_id", (SingleKeyTableShardingAlgorithm<?>) tableShardingAlgorithm)).build();
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
        return dataSource;
    }


    @Bean
    public DefaultKeyGenerator keyGenerator() {
        return new DefaultKeyGenerator();
    }

}
