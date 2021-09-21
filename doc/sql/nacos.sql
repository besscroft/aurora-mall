/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : nacos

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 21/09/2021 14:11:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `effect` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_schema` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (5, 'mall-admin-dev.yaml', 'DEFAULT_GROUP', 'spring:\r\n  redis:\r\n    #数据库索引\r\n    database: 0\r\n    host: 127.0.0.1\r\n    port: 6379\r\n    password: password\r\n    #连接超时时间\r\n    timeout: 5000\r\n  main:\r\n    allow-bean-definition-overriding: true\r\n  datasource:\r\n    druid:\r\n      db-type: com.alibaba.druid.pool.DruidDataSource\r\n      driverClassName: com.mysql.jdbc.Driver\r\n      url: jdbc:mysql://localhost:3306/aurora-mall?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false\r\n      username: root\r\n      password: 666666\r\n      # 初始连接数\r\n      initial-size: 5\r\n      # 最小连接数\r\n      min-idle: 10\r\n      # 最大连接数\r\n      max-active: 20\r\n      # 获取连接超时时间\r\n      max-wait: 5000\r\n      # 连接有效性检测时间\r\n      time-between-eviction-runs-millis: 60000\r\n      # 连接在池中最小生存的时间\r\n      min-evictable-idle-time-millis: 300000\r\n      # 连接在池中最大生存的时间\r\n      max-evictable-idle-time-millis: 900000\r\n      test-while-idle: true\r\n      test-on-borrow: false\r\n      test-on-return: false\r\n      # 检测连接是否有效\r\n      validation-query: select 1\r\n      # 配置监控统计\r\n      webStatFilter:\r\n        enabled: true\r\n      stat-view-servlet:\r\n        enabled: true\r\n        url-pattern: /druid/*\r\n        reset-enable: false\r\n      filter:\r\n        stat:\r\n          enabled: true\r\n          # 记录慢SQL\r\n          log-slow-sql: true\r\n          slow-sql-millis: 1000\r\n          merge-sql: true\r\n        wall:\r\n          config:\r\n            multi-statement-allow: true\r\n\r\n# MyBatis配置\r\nmybatis:\r\n  # 搜索指定包别名\r\n  typeAliasesPackage: com.besscroft.aurora.mall.common.entity\r\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\r\n  mapperLocations: classpath*:mapper/*Mapper.xml\r\n  configuration:\r\n    cache-enabled: false\r\n\r\n# PageHelper分页插件\r\npagehelper:\r\n  helperDialect: mysql\r\n  reasonable: true\r\n  supportMethodsArguments: true\r\n  params: count=countSql\r\n\r\nfeign:\r\n  okhttp:\r\n    enabled: true\r\nribbon:\r\n  ConnectTimeout: 3000 #服务请求连接超时时间（毫秒）\r\n  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）', '2e18e4f0b23feef2b41474dfe0af8628', '2021-09-19 16:08:45', '2021-09-19 16:08:45', NULL, '0:0:0:0:0:0:0:1', '', '', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (6, 'mall-auth-dev.yaml', 'DEFAULT_GROUP', 'spring:\r\n  redis:\r\n    #数据库索引\r\n    database: 0\r\n    host: 127.0.0.1\r\n    port: 6379\r\n    password: password\r\n    #连接超时时间\r\n    timeout: 5000\r\n  main:\r\n    allow-bean-definition-overriding: true\r\nfeign:\r\n  okhttp:\r\n    enabled: true\r\nribbon:\r\n  ConnectTimeout: 3000 #服务请求连接超时时间（毫秒）\r\n  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）', '645d2ded2578c198864bc7690eaa2b23', '2021-09-19 16:11:51', '2021-09-19 16:11:51', NULL, '0:0:0:0:0:0:0:1', '', '', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (7, 'mall-admin-elasticsearch-dev.yaml', 'DEFAULT_GROUP', 'feign:\r\n  okhttp:\r\n    enabled: true\r\nribbon:\r\n  ConnectTimeout: 3000 #服务请求连接超时时间（毫秒）\r\n  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）', 'fa5bc06178a83baae14357a29c98b2dd', '2021-09-19 16:12:26', '2021-09-19 16:12:26', NULL, '0:0:0:0:0:0:0:1', '', '', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (8, 'mall-gateway-dev.yaml', 'DEFAULT_GROUP', 'spring:\r\n  security:\r\n    oauth2:\r\n      resourceserver:\r\n        jwt:\r\n          jwk-set-uri: \'http://localhost:8000/mall-auth/publicKey/get\' #配置RSA的公钥访问地址\r\n  redis:\r\n    #数据库索引\r\n    database: 0\r\n    host: 127.0.0.1\r\n    port: 6379\r\n    password: password\r\n    #连接超时时间\r\n    timeout: 5000\r\n  main:\r\n    allow-bean-definition-overriding: true\r\n  cloud:\r\n    gateway:\r\n      # 跨域\r\n#      globalcors:\r\n#        corsConfigurations:\r\n#          \'[/**]\':\r\n#            allowCredentials: true\r\n#            allowedOrigins: \"*\"\r\n#            allowedMethods: \"*\"\r\n#            allowedHeaders: \"*\"\r\n      routes:\r\n        # 认证中心的路由\r\n        # 路由 ID\r\n        - id: mall-auth\r\n          # 请求地址\r\n          uri: lb://mall-auth\r\n          # 断言（判断条件）\r\n          predicates:\r\n            - Path=/mall-auth/**\r\n          # 过滤器\r\n          filters:\r\n            # 去掉前缀\r\n            - StripPrefix=1\r\n            # 重写路径，也相当于去掉前缀了\r\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\r\n        # 后台管理系统的路由\r\n        # 路由 ID\r\n        - id: mall-admin\r\n          # 请求地址\r\n          uri: lb://mall-admin\r\n          # 断言（判断条件）\r\n          predicates:\r\n            - Path=/mall-admin/**\r\n          # 过滤器\r\n          filters:\r\n            # 去掉前缀\r\n            - StripPrefix=1\r\n            # 重写路径，也相当于去掉前缀了\r\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\r\n        # Elasticsearch中心的路由\r\n        # 路由 ID\r\n        - id: mall-elasticsearch\r\n          # 请求地址\r\n          uri: lb://mall-elasticsearch\r\n          # 断言（判断条件）\r\n          predicates:\r\n            - Path=/mall-elasticsearch/**\r\n          # 过滤器\r\n          filters:\r\n            # 去掉前缀\r\n            - StripPrefix=1\r\n            # 重写路径，也相当于去掉前缀了\r\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\r\n        # 分布式ID服务的路由\r\n        # 路由 ID\r\n        - id: mall-id-generator\r\n          # 请求地址\r\n          uri: lb://mall-id-generator\r\n          # 断言（判断条件）\r\n          predicates:\r\n            - Path=/mall-id-generator/**\r\n          # 过滤器\r\n          filters:\r\n            # 去掉前缀\r\n            - StripPrefix=1\r\n            # 重写路径，也相当于去掉前缀了\r\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\r\n        # 日志服务的路由\r\n        # 路由 ID\r\n        - id: mall-log\r\n          # 请求地址\r\n          uri: lb://mall-log\r\n          # 断言（判断条件）\r\n          predicates:\r\n            - Path=/mall-log/**\r\n          # 过滤器\r\n          filters:\r\n            # 去掉前缀\r\n            - StripPrefix=1\r\n            # 重写路径，也相当于去掉前缀了\r\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\r\n      discovery:\r\n        locator:\r\n          enabled: true #开启从注册中心动态创建路由的功能\r\n          lower-case-service-id: true #使用小写服务名，默认是大写\r\nwhitelist:\r\n    urls: #配置白名单路径\r\n      - \"/doc.html\"\r\n      - \"/swagger-resources/**\"\r\n      - \"/swagger/**\"\r\n      - \"/**/v2/api-docs\"\r\n      - \"/**/*.js\"\r\n      - \"/**/*.css\"\r\n      - \"/**/*.png\"\r\n      - \"/**/*.ico\"\r\n      - \"/webjars/springfox-swagger-ui/**\"\r\n      - \"/actuator/**\"\r\n      - \"/mall-auth/auth/token\"\r\n      - \"/mall-auth/publicKey/get\"\r\n      - \"/mall-admin/user/login\"\r\n      - \"/mall-admin/user/register\"\r\n      - \"/mall-admin/user/logout\"\r\n', '5f3a1b01fa402bb37d35f7523f038cbd', '2021-09-19 16:12:58', '2021-09-19 16:12:58', NULL, '0:0:0:0:0:0:0:1', '', '', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (9, 'mall-id-generator-dev.yaml', 'DEFAULT_GROUP', 'spring:\r\n  main:\r\n    allow-bean-definition-overriding: true\r\n  datasource:\r\n    druid:\r\n      db-type: com.alibaba.druid.pool.DruidDataSource\r\n      driverClassName: com.mysql.jdbc.Driver\r\n      url: jdbc:mysql://localhost:3306/aurora-mall?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false\r\n      username: root\r\n      password: 666666\r\n      # 初始连接数\r\n      initial-size: 5\r\n      # 最小连接数\r\n      min-idle: 10\r\n      # 最大连接数\r\n      max-active: 20\r\n      # 获取连接超时时间\r\n      max-wait: 5000\r\n      # 连接有效性检测时间\r\n      time-between-eviction-runs-millis: 60000\r\n      # 连接在池中最小生存的时间\r\n      min-evictable-idle-time-millis: 300000\r\n      # 连接在池中最大生存的时间\r\n      max-evictable-idle-time-millis: 900000\r\n      test-while-idle: true\r\n      test-on-borrow: false\r\n      test-on-return: false\r\n      # 检测连接是否有效\r\n      validation-query: select 1\r\n      # 配置监控统计\r\n      webStatFilter:\r\n        enabled: true\r\n      stat-view-servlet:\r\n        enabled: true\r\n        url-pattern: /druid/*\r\n        reset-enable: false\r\n      filter:\r\n        stat:\r\n          enabled: true\r\n          # 记录慢SQL\r\n          log-slow-sql: true\r\n          slow-sql-millis: 1000\r\n          merge-sql: true\r\n        wall:\r\n          config:\r\n            multi-statement-allow: true\r\n  # JPA相关配置\r\n  jpa:\r\n    database-platform: org.hibernate.dialect.MySQL5InnoDBDialect\r\n    show-sql: true\r\n    hibernate:\r\n      ddl-auto: update\r\n    # formatSQL\r\n    properties:\r\n      hibernate:\r\n        format_sql: true\r\n\r\nfeign:\r\n  okhttp:\r\n    enabled: true\r\nribbon:\r\n  ConnectTimeout: 3000 #服务请求连接超时时间（毫秒）\r\n  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）', '70e864137dee584092bb00f48c8e16ca', '2021-09-19 16:13:29', '2021-09-19 16:13:29', NULL, '0:0:0:0:0:0:0:1', '', '', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (10, 'mall-log-dev.yaml', 'DEFAULT_GROUP', 'spring:\r\n  redis:\r\n    #数据库索引\r\n    database: 0\r\n    host: 127.0.0.1\r\n    port: 6379\r\n    password: password\r\n    #连接超时时间\r\n    timeout: 5000\r\n  main:\r\n    allow-bean-definition-overriding: true\r\n  datasource:\r\n    druid:\r\n      db-type: com.alibaba.druid.pool.DruidDataSource\r\n      driverClassName: com.mysql.jdbc.Driver\r\n      url: jdbc:mysql://localhost:3306/aurora-mall?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false\r\n      username: root\r\n      password: 666666\r\n      # 初始连接数\r\n      initial-size: 5\r\n      # 最小连接数\r\n      min-idle: 10\r\n      # 最大连接数\r\n      max-active: 20\r\n      # 获取连接超时时间\r\n      max-wait: 5000\r\n      # 连接有效性检测时间\r\n      time-between-eviction-runs-millis: 60000\r\n      # 连接在池中最小生存的时间\r\n      min-evictable-idle-time-millis: 300000\r\n      # 连接在池中最大生存的时间\r\n      max-evictable-idle-time-millis: 900000\r\n      test-while-idle: true\r\n      test-on-borrow: false\r\n      test-on-return: false\r\n      # 检测连接是否有效\r\n      validation-query: select 1\r\n      # 配置监控统计\r\n      webStatFilter:\r\n        enabled: true\r\n      stat-view-servlet:\r\n        enabled: true\r\n        url-pattern: /druid/*\r\n        reset-enable: false\r\n      filter:\r\n        stat:\r\n          enabled: true\r\n          # 记录慢SQL\r\n          log-slow-sql: true\r\n          slow-sql-millis: 1000\r\n          merge-sql: true\r\n        wall:\r\n          config:\r\n            multi-statement-allow: true\r\n\r\n# MyBatis配置\r\nmybatis:\r\n  # 搜索指定包别名\r\n  typeAliasesPackage: com.besscroft.aurora.mall.common.entity\r\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\r\n  mapperLocations: classpath*:mapper/*Mapper.xml\r\n  configuration:\r\n    cache-enabled: false\r\n\r\n# PageHelper分页插件\r\npagehelper:\r\n  helperDialect: mysql\r\n  reasonable: true\r\n  supportMethodsArguments: true\r\n  params: count=countSql\r\n\r\nfeign:\r\n  okhttp:\r\n    enabled: true\r\nribbon:\r\n  ConnectTimeout: 3000 #服务请求连接超时时间（毫秒）\r\n  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）', '2e18e4f0b23feef2b41474dfe0af8628', '2021-09-19 16:13:59', '2021-09-19 16:13:59', NULL, '0:0:0:0:0:0:0:1', '', '', NULL, NULL, NULL, 'yaml', NULL);

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id`, `group_id`, `tenant_id`, `datum_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '增加租户字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_aggr
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_beta' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_beta
-- ----------------------------

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id`, `group_id`, `tenant_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_tag' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_tag
-- ----------------------------

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `tag_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`) USING BTREE,
  UNIQUE INDEX `uk_configtagrelation_configidtag`(`id`, `tag_name`, `tag_type`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_tag_relation' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_tags_relation
-- ----------------------------

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info`  (
  `id` bigint(64) UNSIGNED NOT NULL,
  `nid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `op_type` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `idx_gmt_create`(`gmt_create`) USING BTREE,
  INDEX `idx_gmt_modified`(`gmt_modified`) USING BTREE,
  INDEX `idx_did`(`data_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '多租户改造' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
INSERT INTO `his_config_info` VALUES (0, 7, 'mall-admin-dev', 'DEFAULT_GROUP', '', 'spring:\r\n  redis:\r\n    #数据库索引\r\n    database: 0\r\n    host: 127.0.0.1\r\n    port: 6379\r\n    password: password\r\n    #连接超时时间\r\n    timeout: 5000\r\n  main:\r\n    allow-bean-definition-overriding: true\r\n  datasource:\r\n    druid:\r\n      db-type: com.alibaba.druid.pool.DruidDataSource\r\n      driverClassName: com.mysql.jdbc.Driver\r\n      url: jdbc:mysql://localhost:3306/aurora-mall?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false\r\n      username: root\r\n      password: 666666\r\n      # 初始连接数\r\n      initial-size: 5\r\n      # 最小连接数\r\n      min-idle: 10\r\n      # 最大连接数\r\n      max-active: 20\r\n      # 获取连接超时时间\r\n      max-wait: 5000\r\n      # 连接有效性检测时间\r\n      time-between-eviction-runs-millis: 60000\r\n      # 连接在池中最小生存的时间\r\n      min-evictable-idle-time-millis: 300000\r\n      # 连接在池中最大生存的时间\r\n      max-evictable-idle-time-millis: 900000\r\n      test-while-idle: true\r\n      test-on-borrow: false\r\n      test-on-return: false\r\n      # 检测连接是否有效\r\n      validation-query: select 1\r\n      # 配置监控统计\r\n      webStatFilter:\r\n        enabled: true\r\n      stat-view-servlet:\r\n        enabled: true\r\n        url-pattern: /druid/*\r\n        reset-enable: false\r\n      filter:\r\n        stat:\r\n          enabled: true\r\n          # 记录慢SQL\r\n          log-slow-sql: true\r\n          slow-sql-millis: 1000\r\n          merge-sql: true\r\n        wall:\r\n          config:\r\n            multi-statement-allow: true\r\n\r\n# MyBatis配置\r\nmybatis:\r\n  # 搜索指定包别名\r\n  typeAliasesPackage: com.besscroft.aurora.mall.common.entity\r\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\r\n  mapperLocations: classpath*:mapper/*Mapper.xml\r\n  configuration:\r\n    cache-enabled: false\r\n\r\n# PageHelper分页插件\r\npagehelper:\r\n  helperDialect: mysql\r\n  reasonable: true\r\n  supportMethodsArguments: true\r\n  params: count=countSql\r\n\r\nfeign:\r\n  okhttp:\r\n    enabled: true\r\nribbon:\r\n  ConnectTimeout: 3000 #服务请求连接超时时间（毫秒）\r\n  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）', '2e18e4f0b23feef2b41474dfe0af8628', '2021-09-20 00:08:44', '2021-09-19 16:08:45', NULL, '0:0:0:0:0:0:0:1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 8, 'mall-auth-dev', 'DEFAULT_GROUP', '', 'spring:\r\n  redis:\r\n    #数据库索引\r\n    database: 0\r\n    host: 127.0.0.1\r\n    port: 6379\r\n    password: password\r\n    #连接超时时间\r\n    timeout: 5000\r\n  main:\r\n    allow-bean-definition-overriding: true\r\nfeign:\r\n  okhttp:\r\n    enabled: true\r\nribbon:\r\n  ConnectTimeout: 3000 #服务请求连接超时时间（毫秒）\r\n  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）', '645d2ded2578c198864bc7690eaa2b23', '2021-09-20 00:11:50', '2021-09-19 16:11:51', NULL, '0:0:0:0:0:0:0:1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 9, 'mall-admin-elasticsearch-dev', 'DEFAULT_GROUP', '', 'feign:\r\n  okhttp:\r\n    enabled: true\r\nribbon:\r\n  ConnectTimeout: 3000 #服务请求连接超时时间（毫秒）\r\n  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）', 'fa5bc06178a83baae14357a29c98b2dd', '2021-09-20 00:12:26', '2021-09-19 16:12:26', NULL, '0:0:0:0:0:0:0:1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 10, 'mall-gateway', 'DEFAULT_GROUP', '', 'spring:\r\n  security:\r\n    oauth2:\r\n      resourceserver:\r\n        jwt:\r\n          jwk-set-uri: \'http://localhost:8000/mall-auth/publicKey/get\' #配置RSA的公钥访问地址\r\n  redis:\r\n    #数据库索引\r\n    database: 0\r\n    host: 127.0.0.1\r\n    port: 6379\r\n    password: password\r\n    #连接超时时间\r\n    timeout: 5000\r\n  main:\r\n    allow-bean-definition-overriding: true\r\n  cloud:\r\n    gateway:\r\n      # 跨域\r\n#      globalcors:\r\n#        corsConfigurations:\r\n#          \'[/**]\':\r\n#            allowCredentials: true\r\n#            allowedOrigins: \"*\"\r\n#            allowedMethods: \"*\"\r\n#            allowedHeaders: \"*\"\r\n      routes:\r\n        # 认证中心的路由\r\n        # 路由 ID\r\n        - id: mall-auth\r\n          # 请求地址\r\n          uri: lb://mall-auth\r\n          # 断言（判断条件）\r\n          predicates:\r\n            - Path=/mall-auth/**\r\n          # 过滤器\r\n          filters:\r\n            # 去掉前缀\r\n            - StripPrefix=1\r\n            # 重写路径，也相当于去掉前缀了\r\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\r\n        # 后台管理系统的路由\r\n        # 路由 ID\r\n        - id: mall-admin\r\n          # 请求地址\r\n          uri: lb://mall-admin\r\n          # 断言（判断条件）\r\n          predicates:\r\n            - Path=/mall-admin/**\r\n          # 过滤器\r\n          filters:\r\n            # 去掉前缀\r\n            - StripPrefix=1\r\n            # 重写路径，也相当于去掉前缀了\r\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\r\n        # Elasticsearch中心的路由\r\n        # 路由 ID\r\n        - id: mall-elasticsearch\r\n          # 请求地址\r\n          uri: lb://mall-elasticsearch\r\n          # 断言（判断条件）\r\n          predicates:\r\n            - Path=/mall-elasticsearch/**\r\n          # 过滤器\r\n          filters:\r\n            # 去掉前缀\r\n            - StripPrefix=1\r\n            # 重写路径，也相当于去掉前缀了\r\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\r\n        # 分布式ID服务的路由\r\n        # 路由 ID\r\n        - id: mall-id-generator\r\n          # 请求地址\r\n          uri: lb://mall-id-generator\r\n          # 断言（判断条件）\r\n          predicates:\r\n            - Path=/mall-id-generator/**\r\n          # 过滤器\r\n          filters:\r\n            # 去掉前缀\r\n            - StripPrefix=1\r\n            # 重写路径，也相当于去掉前缀了\r\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\r\n        # 日志服务的路由\r\n        # 路由 ID\r\n        - id: mall-log\r\n          # 请求地址\r\n          uri: lb://mall-log\r\n          # 断言（判断条件）\r\n          predicates:\r\n            - Path=/mall-log/**\r\n          # 过滤器\r\n          filters:\r\n            # 去掉前缀\r\n            - StripPrefix=1\r\n            # 重写路径，也相当于去掉前缀了\r\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\r\n      discovery:\r\n        locator:\r\n          enabled: true #开启从注册中心动态创建路由的功能\r\n          lower-case-service-id: true #使用小写服务名，默认是大写\r\nwhitelist:\r\n    urls: #配置白名单路径\r\n      - \"/doc.html\"\r\n      - \"/swagger-resources/**\"\r\n      - \"/swagger/**\"\r\n      - \"/**/v2/api-docs\"\r\n      - \"/**/*.js\"\r\n      - \"/**/*.css\"\r\n      - \"/**/*.png\"\r\n      - \"/**/*.ico\"\r\n      - \"/webjars/springfox-swagger-ui/**\"\r\n      - \"/actuator/**\"\r\n      - \"/mall-auth/auth/token\"\r\n      - \"/mall-auth/publicKey/get\"\r\n      - \"/mall-admin/user/login\"\r\n      - \"/mall-admin/user/register\"\r\n      - \"/mall-admin/user/logout\"\r\n', '5f3a1b01fa402bb37d35f7523f038cbd', '2021-09-20 00:12:57', '2021-09-19 16:12:58', NULL, '0:0:0:0:0:0:0:1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 11, 'mall-id-generator-dev', 'DEFAULT_GROUP', '', 'spring:\r\n  main:\r\n    allow-bean-definition-overriding: true\r\n  datasource:\r\n    druid:\r\n      db-type: com.alibaba.druid.pool.DruidDataSource\r\n      driverClassName: com.mysql.jdbc.Driver\r\n      url: jdbc:mysql://localhost:3306/aurora-mall?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false\r\n      username: root\r\n      password: 666666\r\n      # 初始连接数\r\n      initial-size: 5\r\n      # 最小连接数\r\n      min-idle: 10\r\n      # 最大连接数\r\n      max-active: 20\r\n      # 获取连接超时时间\r\n      max-wait: 5000\r\n      # 连接有效性检测时间\r\n      time-between-eviction-runs-millis: 60000\r\n      # 连接在池中最小生存的时间\r\n      min-evictable-idle-time-millis: 300000\r\n      # 连接在池中最大生存的时间\r\n      max-evictable-idle-time-millis: 900000\r\n      test-while-idle: true\r\n      test-on-borrow: false\r\n      test-on-return: false\r\n      # 检测连接是否有效\r\n      validation-query: select 1\r\n      # 配置监控统计\r\n      webStatFilter:\r\n        enabled: true\r\n      stat-view-servlet:\r\n        enabled: true\r\n        url-pattern: /druid/*\r\n        reset-enable: false\r\n      filter:\r\n        stat:\r\n          enabled: true\r\n          # 记录慢SQL\r\n          log-slow-sql: true\r\n          slow-sql-millis: 1000\r\n          merge-sql: true\r\n        wall:\r\n          config:\r\n            multi-statement-allow: true\r\n  # JPA相关配置\r\n  jpa:\r\n    database-platform: org.hibernate.dialect.MySQL5InnoDBDialect\r\n    show-sql: true\r\n    hibernate:\r\n      ddl-auto: update\r\n    # formatSQL\r\n    properties:\r\n      hibernate:\r\n        format_sql: true\r\n\r\nfeign:\r\n  okhttp:\r\n    enabled: true\r\nribbon:\r\n  ConnectTimeout: 3000 #服务请求连接超时时间（毫秒）\r\n  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）', '70e864137dee584092bb00f48c8e16ca', '2021-09-20 00:13:29', '2021-09-19 16:13:29', NULL, '0:0:0:0:0:0:0:1', 'I', '');
INSERT INTO `his_config_info` VALUES (0, 12, 'mall-log-dev', 'DEFAULT_GROUP', '', 'spring:\r\n  redis:\r\n    #数据库索引\r\n    database: 0\r\n    host: 127.0.0.1\r\n    port: 6379\r\n    password: password\r\n    #连接超时时间\r\n    timeout: 5000\r\n  main:\r\n    allow-bean-definition-overriding: true\r\n  datasource:\r\n    druid:\r\n      db-type: com.alibaba.druid.pool.DruidDataSource\r\n      driverClassName: com.mysql.jdbc.Driver\r\n      url: jdbc:mysql://localhost:3306/aurora-mall?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false\r\n      username: root\r\n      password: 666666\r\n      # 初始连接数\r\n      initial-size: 5\r\n      # 最小连接数\r\n      min-idle: 10\r\n      # 最大连接数\r\n      max-active: 20\r\n      # 获取连接超时时间\r\n      max-wait: 5000\r\n      # 连接有效性检测时间\r\n      time-between-eviction-runs-millis: 60000\r\n      # 连接在池中最小生存的时间\r\n      min-evictable-idle-time-millis: 300000\r\n      # 连接在池中最大生存的时间\r\n      max-evictable-idle-time-millis: 900000\r\n      test-while-idle: true\r\n      test-on-borrow: false\r\n      test-on-return: false\r\n      # 检测连接是否有效\r\n      validation-query: select 1\r\n      # 配置监控统计\r\n      webStatFilter:\r\n        enabled: true\r\n      stat-view-servlet:\r\n        enabled: true\r\n        url-pattern: /druid/*\r\n        reset-enable: false\r\n      filter:\r\n        stat:\r\n          enabled: true\r\n          # 记录慢SQL\r\n          log-slow-sql: true\r\n          slow-sql-millis: 1000\r\n          merge-sql: true\r\n        wall:\r\n          config:\r\n            multi-statement-allow: true\r\n\r\n# MyBatis配置\r\nmybatis:\r\n  # 搜索指定包别名\r\n  typeAliasesPackage: com.besscroft.aurora.mall.common.entity\r\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\r\n  mapperLocations: classpath*:mapper/*Mapper.xml\r\n  configuration:\r\n    cache-enabled: false\r\n\r\n# PageHelper分页插件\r\npagehelper:\r\n  helperDialect: mysql\r\n  reasonable: true\r\n  supportMethodsArguments: true\r\n  params: count=countSql\r\n\r\nfeign:\r\n  okhttp:\r\n    enabled: true\r\nribbon:\r\n  ConnectTimeout: 3000 #服务请求连接超时时间（毫秒）\r\n  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）', '2e18e4f0b23feef2b41474dfe0af8628', '2021-09-20 00:13:59', '2021-09-19 16:13:59', NULL, '0:0:0:0:0:0:0:1', 'I', '');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `action` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE INDEX `uk_role_permission`(`role`, `resource`, `action`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permissions
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE INDEX `idx_user_role`(`username`, `role`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '租户容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_capacity
-- ----------------------------

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp`, `tenant_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'tenant_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
