CREATE DATABASE test;
CREATE TABLE `id_test` (
`id`  varchar(100) NOT NULL ,
`inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间', 
`updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间', 
PRIMARY KEY (`id`)
)
;

