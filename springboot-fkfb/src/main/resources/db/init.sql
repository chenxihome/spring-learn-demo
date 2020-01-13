-------------------------
----创建4个DB,每个DB下分别创建16张表
--------------------------------------------------------

create database `test_order_0` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
create database `test_order_1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
create database `test_order_2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
create database `test_order_3` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- ----------------------------
-- Table structure for order_0
-- ----------------------------
DROP TABLE IF EXISTS `order_0`;
CREATE TABLE `order_0` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_1` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_2` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_3` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_4` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_5` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_6` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_7` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_8` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_9` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_10` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_11` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_12` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_13` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_14` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `order_15` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态：0 已提交',
  `sku_id` int(11) NOT NULL COMMENT '商品skuid',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单金额',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_active` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除 1是 0 否 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_id` (`order_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;