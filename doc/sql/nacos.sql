/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : nacos

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 22/01/2022 20:22:10
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
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (5, 'mall-admin-dev.yaml', 'DEFAULT_GROUP', 'spring:\n  redis:\n    #数据库索引\n    database: 0\n    host: 127.0.0.1\n    port: 6379\n    password: password\n    #连接超时时间\n    timeout: 5000\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    druid:\n      db-type: com.alibaba.druid.pool.DruidDataSource\n      driverClassName: com.mysql.jdbc.Driver\n      url: jdbc:mysql://localhost:3306/aurora-mall?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false\n      username: root\n      password: 666666\n      # 初始连接数\n      initial-size: 5\n      # 最小连接数\n      min-idle: 10\n      # 最大连接数\n      max-active: 20\n      # 获取连接超时时间\n      max-wait: 5000\n      # 连接有效性检测时间\n      time-between-eviction-runs-millis: 60000\n      # 连接在池中最小生存的时间\n      min-evictable-idle-time-millis: 300000\n      # 连接在池中最大生存的时间\n      max-evictable-idle-time-millis: 900000\n      test-while-idle: true\n      test-on-borrow: false\n      test-on-return: false\n      # 检测连接是否有效\n      validation-query: select 1\n      # 配置监控统计\n      webStatFilter:\n        enabled: true\n      stat-view-servlet:\n        enabled: true\n        url-pattern: /druid/*\n        reset-enable: false\n      filter:\n        stat:\n          enabled: true\n          # 记录慢SQL\n          log-slow-sql: true\n          slow-sql-millis: 1000\n          merge-sql: true\n        wall:\n          config:\n            multi-statement-allow: true\n        slf4j:\n          enabled: true\n          statement-create-after-log-enabled: false\n          statement-close-after-log-enabled: false\n          statement-log-enabled: false\n          statement-executable-sql-log-enable: true\n          statement-log-error-enabled: true\n          result-set-open-after-log-enabled: false\n          result-set-close-after-log-enabled: false\n  cloud:\n    sentinel:\n      transport:\n        dashboard: 127.0.0.1:7777\n\n# MyBatis配置\nmybatis:\n  # 搜索指定包别名\n  typeAliasesPackage: com.besscroft.aurora.mall.common.entity\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath*:mapper/*Mapper.xml\n  configuration:\n    cache-enabled: false\n\n# PageHelper分页插件\npagehelper:\n  helperDialect: mysql\n  reasonable: true\n  supportMethodsArguments: true\n  params: count=countSql\n\nfeign:\n  okhttp:\n    enabled: true\n\n# 全局参数设置\nribbon:\n  # 服务请求处理超时时间（毫秒）\n  ReadTimeout: 120000\n  # 服务请求连接超时时间（毫秒）\n  ConnectTimeout: 10000\n  SocketTimeout: 10000\n  MaxAutoRetries: 0\n  MaxAutoRetriesNextServer: 1\n\n# 日志级别设置\nlogging:\n  level:\n    # nacos 日志级别\n    com:\n      alibaba:\n        nacos: warn', '859277b30d3c0c99144554f0ae95b033', '2021-09-19 16:08:45', '2022-01-21 02:56:04', 'nacos', '0:0:0:0:0:0:0:1', '', '', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (6, 'mall-auth-dev.yaml', 'DEFAULT_GROUP', 'spring:\n  redis:\n    #数据库索引\n    database: 0\n    host: 127.0.0.1\n    port: 6379\n    password: password\n    #连接超时时间\n    timeout: 5000\n  main:\n    allow-bean-definition-overriding: true\nfeign:\n  okhttp:\n    enabled: true\n\n# 全局参数设置\nribbon:\n  # 服务请求处理超时时间（毫秒）\n  ReadTimeout: 120000\n  # 服务请求连接超时时间（毫秒）\n  ConnectTimeout: 10000\n  SocketTimeout: 10000\n  MaxAutoRetries: 0\n  MaxAutoRetriesNextServer: 1\n\n# 日志级别设置\nlogging:\n  level:\n    # nacos 日志级别\n    com:\n      alibaba:\n        nacos: warn', '662f0283305c5b39508be6695f3983da', '2021-09-19 16:11:51', '2021-10-24 10:56:59', 'nacos', '0:0:0:0:0:0:0:1', '', '', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (7, 'mall-admin-elasticsearch-dev.yaml', 'DEFAULT_GROUP', 'feign:\n  okhttp:\n    enabled: true\n\n# 全局参数设置\nribbon:\n  # 服务请求处理超时时间（毫秒）\n  ReadTimeout: 120000\n  # 服务请求连接超时时间（毫秒）\n  ConnectTimeout: 10000\n  SocketTimeout: 10000\n  MaxAutoRetries: 0\n  MaxAutoRetriesNextServer: 1\n\n# 日志级别设置\nlogging:\n  level:\n    # nacos 日志级别\n    com:\n      alibaba:\n        nacos: warn', 'd90f61e418669514ae48e6e4d1f1f6da', '2021-09-19 16:12:26', '2021-10-24 10:57:06', 'nacos', '0:0:0:0:0:0:0:1', '', '', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (8, 'mall-gateway-dev.yaml', 'DEFAULT_GROUP', 'spring:\n  security:\n    oauth2:\n      resourceserver:\n        jwt:\n          jwk-set-uri: \'http://localhost:8000/mall-auth/publicKey/get\' #配置RSA的公钥访问地址\n  redis:\n    #数据库索引\n    database: 0\n    host: 127.0.0.1\n    port: 6379\n    password: password\n    #连接超时时间\n    timeout: 5000\n  main:\n    allow-bean-definition-overriding: true\n  cloud:\n    gateway:\n      # 跨域\n#      globalcors:\n#        corsConfigurations:\n#          \'[/**]\':\n#            allowCredentials: true\n#            allowedOrigins: \"*\"\n#            allowedMethods: \"*\"\n#            allowedHeaders: \"*\"\n      routes:\n        # 认证中心的路由\n        # 路由 ID\n        - id: mall-auth\n          # 请求地址\n          uri: lb://mall-auth\n          # 断言（判断条件）\n          predicates:\n            - Path=/mall-auth/**\n          # 过滤器\n          filters:\n            # 去掉前缀\n            - StripPrefix=1\n            # 重写路径，也相当于去掉前缀了\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\n        # 后台管理系统的路由\n        # 路由 ID\n        - id: mall-admin\n          # 请求地址\n          uri: lb://mall-admin\n          # 断言（判断条件）\n          predicates:\n            - Path=/mall-admin/**\n          # 过滤器\n          filters:\n            # 去掉前缀\n            - StripPrefix=1\n            # 重写路径，也相当于去掉前缀了\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\n        # Elasticsearch中心的路由\n        # 路由 ID\n        - id: mall-elasticsearch\n          # 请求地址\n          uri: lb://mall-elasticsearch\n          # 断言（判断条件）\n          predicates:\n            - Path=/mall-elasticsearch/**\n          # 过滤器\n          filters:\n            # 去掉前缀\n            - StripPrefix=1\n            # 重写路径，也相当于去掉前缀了\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\n        # 分布式ID服务的路由\n        # 路由 ID\n        - id: mall-id-generator\n          # 请求地址\n          uri: lb://mall-id-generator\n          # 断言（判断条件）\n          predicates:\n            - Path=/mall-id-generator/**\n          # 过滤器\n          filters:\n            # 去掉前缀\n            - StripPrefix=1\n            # 重写路径，也相当于去掉前缀了\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\n        # 日志服务的路由\n        # 路由 ID\n        - id: mall-log\n          # 请求地址\n          uri: lb://mall-log\n          # 断言（判断条件）\n          predicates:\n            - Path=/mall-log/**\n          # 过滤器\n          filters:\n            # 去掉前缀\n            - StripPrefix=1\n            # 重写路径，也相当于去掉前缀了\n            # - RewritePath=/mall-auth/(?<segment>.*), /$\\{segment}\n      discovery:\n        locator:\n          enabled: true #开启从注册中心动态创建路由的功能\n          lower-case-service-id: true #使用小写服务名，默认是大写\nwhitelist:\n    urls: #配置白名单路径\n      - \"/doc.html\"\n      - \"/swagger-resources/**\"\n      - \"/swagger/**\"\n      - \"/*/v2/api-docs\"\n      - \"/*/*.js\"\n      - \"/*/*.css\"\n      - \"/*/*.png\"\n      - \"/*/*.ico\"\n      - \"/webjars/springfox-swagger-ui/**\"\n      - \"/actuator/**\"\n      - \"/mall-auth/auth/token\"\n      - \"/mall-auth/publicKey/get\"\n      - \"/mall-admin/user/login\"\n      - \"/mall-admin/user/register\"\n      - \"/mall-admin/user/logout\"\n      - \"/mall-auth/oauth/token\"\n      - \"/mall-auth/user/loadByUsername\"\n\n# 日志级别设置\nlogging:\n  level:\n    # nacos 日志级别\n    com:\n      alibaba:\n        nacos: warn\n', 'c2271f6c02346a8c08dfe225c2a15ff3', '2021-09-19 16:12:58', '2022-01-19 04:17:46', 'nacos', '0:0:0:0:0:0:0:1', '', '', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (10, 'mall-log-dev.yaml', 'DEFAULT_GROUP', 'spring:\n  redis:\n    #数据库索引\n    database: 0\n    host: 127.0.0.1\n    port: 6379\n    password: password\n    #连接超时时间\n    timeout: 5000\n  main:\n    allow-bean-definition-overriding: true\n  datasource:\n    druid:\n      db-type: com.alibaba.druid.pool.DruidDataSource\n      driverClassName: com.mysql.jdbc.Driver\n      url: jdbc:mysql://localhost:3306/aurora-mall-log?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false\n      username: root\n      password: 666666\n      # 初始连接数\n      initial-size: 5\n      # 最小连接数\n      min-idle: 10\n      # 最大连接数\n      max-active: 20\n      # 获取连接超时时间\n      max-wait: 5000\n      # 连接有效性检测时间\n      time-between-eviction-runs-millis: 60000\n      # 连接在池中最小生存的时间\n      min-evictable-idle-time-millis: 300000\n      # 连接在池中最大生存的时间\n      max-evictable-idle-time-millis: 900000\n      test-while-idle: true\n      test-on-borrow: false\n      test-on-return: false\n      # 检测连接是否有效\n      validation-query: select 1\n      # 配置监控统计\n      webStatFilter:\n        enabled: true\n      stat-view-servlet:\n        enabled: true\n        url-pattern: /druid/*\n        reset-enable: false\n      filter:\n        stat:\n          enabled: true\n          # 记录慢SQL\n          log-slow-sql: true\n          slow-sql-millis: 1000\n          merge-sql: true\n        wall:\n          config:\n            multi-statement-allow: true\n        slf4j:\n          enabled: true\n          statement-create-after-log-enabled: false\n          statement-close-after-log-enabled: false\n          statement-log-enabled: false\n          statement-executable-sql-log-enable: true\n          statement-log-error-enabled: true\n          result-set-open-after-log-enabled: false\n          result-set-close-after-log-enabled: false\n\n# MyBatis配置\nmybatis:\n  # 搜索指定包别名\n  typeAliasesPackage: com.besscroft.aurora.mall.common.entity\n  # 配置mapper的扫描，找到所有的mapper.xml映射文件\n  mapperLocations: classpath*:mapper/*Mapper.xml\n  configuration:\n    cache-enabled: false\n\n# PageHelper分页插件\npagehelper:\n  helperDialect: mysql\n  reasonable: true\n  supportMethodsArguments: true\n  params: count=countSql\n\nfeign:\n  okhttp:\n    enabled: true\n\n# 全局参数设置\nribbon:\n  # 服务请求处理超时时间（毫秒）\n  ReadTimeout: 120000\n  # 服务请求连接超时时间（毫秒）\n  ConnectTimeout: 10000\n  SocketTimeout: 10000\n  MaxAutoRetries: 0\n  MaxAutoRetriesNextServer: 1\n\n# 日志级别设置\nlogging:\n  level:\n    # nacos 日志级别\n    com:\n      alibaba:\n        nacos: warn', 'e7987c50ce1c31b9a2db6cf3c5430dd0', '2021-09-19 16:13:59', '2022-01-16 07:14:00', 'nacos', '0:0:0:0:0:0:0:1', '', '', '', '', '', 'yaml', '');

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '增加租户字段' ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_beta' ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_tag' ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_tag_relation' ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '多租户改造' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of his_config_info
-- ----------------------------

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `action` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE INDEX `uk_role_permission`(`role`, `resource`, `action`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '租户容量信息表' ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'tenant_info' ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
