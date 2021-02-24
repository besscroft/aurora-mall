/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : aurora-mall

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 17/02/2021 21:15:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bms_auth_log
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_log`;
CREATE TABLE `bms_auth_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `log_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `log_detail` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作详情，这里可以以json等格式保留信息',
  `log_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1.1.1.1' COMMENT '操作者登录ip',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块权限操作日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_log
-- ----------------------------

-- ----------------------------
-- Table structure for bms_auth_menu
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_menu`;
CREATE TABLE `bms_auth_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `parent_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父菜单名称',
  `level` int(4) NULL DEFAULT NULL COMMENT '菜单级数',
  `sort` int(4) NULL DEFAULT NULL COMMENT '菜单排序',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端名称',
  `icon` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端图标',
  `hidden` int(1) NULL DEFAULT 1 COMMENT '显示状态：0->不显示；1->显示',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_menu
-- ----------------------------
INSERT INTO `bms_auth_menu` VALUES (1, NULL, '2021-01-25 13:32:37', '权限管理', NULL, 1, 0, '权限管理', NULL, 1);

-- ----------------------------
-- Table structure for bms_auth_permission
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_permission`;
CREATE TABLE `bms_auth_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) NULL DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `value` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `type` int(1) NULL DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
  `uri` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端资源路径',
  `status` int(1) NULL DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_permission
-- ----------------------------

-- ----------------------------
-- Table structure for bms_auth_resource
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_resource`;
CREATE TABLE `bms_auth_resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源路径',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源描述',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `category_id` bigint(20) NULL DEFAULT NULL COMMENT '资源类别ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块资源表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_resource
-- ----------------------------
INSERT INTO `bms_auth_resource` VALUES (1, '添加用户', NULL, '新增后台管理系统的用户', '2021-01-25 13:34:04', NULL);

-- ----------------------------
-- Table structure for bms_auth_resource_sort
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_resource_sort`;
CREATE TABLE `bms_auth_resource_sort`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源类别名称',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源描述',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块资源类别管理表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_resource_sort
-- ----------------------------

-- ----------------------------
-- Table structure for bms_auth_role
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_role`;
CREATE TABLE `bms_auth_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `admin_count` int(11) NULL DEFAULT NULL COMMENT '用户数量',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(1) NULL DEFAULT 0 COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_role
-- ----------------------------
INSERT INTO `bms_auth_role` VALUES (1, '超级管理员', '超级管理员', 1, '2021-01-25 13:31:45', 1, 0);

-- ----------------------------
-- Table structure for bms_auth_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_role_menu_relation`;
CREATE TABLE `bms_auth_role_menu_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块角色菜单关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_role_menu_relation
-- ----------------------------
INSERT INTO `bms_auth_role_menu_relation` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for bms_auth_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_role_permission_relation`;
CREATE TABLE `bms_auth_role_permission_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `permission_id` bigint(20) NULL DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块角色权限关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_role_permission_relation
-- ----------------------------

-- ----------------------------
-- Table structure for bms_auth_role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_role_resource_relation`;
CREATE TABLE `bms_auth_role_resource_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `resource_id` bigint(20) NULL DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块角色资源关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_role_resource_relation
-- ----------------------------
INSERT INTO `bms_auth_role_resource_relation` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for bms_auth_user
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_user`;
CREATE TABLE `bms_auth_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `nick_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_user
-- ----------------------------
INSERT INTO `bms_auth_user` VALUES (1, 'admin', '$2a$10$.E1FokumK5GIXWgKlg.Hc.i/0/2.qdAwYFL1zc5QHdyzpXOr38RZO', NULL, 'admin@qq.com', '110', 'admin', '管理员', '2021-01-22 17:09:14', '2021-01-22 17:09:17', 1);

-- ----------------------------
-- Table structure for bms_auth_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_user_role_relation`;
CREATE TABLE `bms_auth_user_role_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块用户角色关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_user_role_relation
-- ----------------------------
INSERT INTO `bms_auth_user_role_relation` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for bms_market_ad
-- ----------------------------
DROP TABLE IF EXISTS `bms_market_ad`;
CREATE TABLE `bms_market_ad`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '广告名称',
  `type` int(1) NULL DEFAULT NULL COMMENT '轮播位置：0->PC首页轮播；1->app首页轮播',
  `pic` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '广告图片',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `status` int(1) NULL DEFAULT NULL COMMENT '上下线状态：0->下线；1->上线',
  `click_count` int(11) NULL DEFAULT NULL COMMENT '点击数',
  `order_count` int(11) NULL DEFAULT NULL COMMENT '下单数',
  `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接地址',
  `detail` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '营销管理模块广告（轮播图）表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_market_ad
-- ----------------------------

-- ----------------------------
-- Table structure for bms_market_bit
-- ----------------------------
DROP TABLE IF EXISTS `bms_market_bit`;
CREATE TABLE `bms_market_bit`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '营销管理模块极光币表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_market_bit
-- ----------------------------

-- ----------------------------
-- Table structure for bms_market_coupon
-- ----------------------------
DROP TABLE IF EXISTS `bms_market_coupon`;
CREATE TABLE `bms_market_coupon`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '极光券名称',
  `status` int(1) NULL DEFAULT NULL COMMENT '是否可用：0->下线；1->上线',
  `start_money` decimal(8, 2) NULL DEFAULT NULL COMMENT '生效金额门槛',
  `money` decimal(8, 2) NULL DEFAULT NULL COMMENT '抵扣金额',
  `start_time` datetime NULL DEFAULT NULL COMMENT '生效时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '失效时间',
  `detail` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '营销管理模块优惠券表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_market_coupon
-- ----------------------------

-- ----------------------------
-- Table structure for bms_market_coupon_log
-- ----------------------------
DROP TABLE IF EXISTS `bms_market_coupon_log`;
CREATE TABLE `bms_market_coupon_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `log_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `log_detail` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作详情，这里可以以json等格式保留信息',
  `log_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1.1.1.1' COMMENT '操作者登录ip',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '营销管理模块优惠券使用记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_market_coupon_log
-- ----------------------------

-- ----------------------------
-- Table structure for bms_order
-- ----------------------------
DROP TABLE IF EXISTS `bms_order`;
CREATE TABLE `bms_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `coupon_id` bigint(20) NULL DEFAULT NULL COMMENT '优惠券id',
  `order_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '提交时间',
  `member_username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户帐号',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总金额',
  `pay_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '应付金额（实际支付金额）',
  `freight_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '运费金额',
  `aurora_bit_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '极光币抵扣金额',
  `coupon_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠券抵扣金额',
  `discount_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '管理员后台调整订单使用的折扣金额',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付方式：0->未支付；1->支付宝；2->微信',
  `source_type` int(1) NULL DEFAULT NULL COMMENT '订单来源：0->PC订单；1->app订单',
  `status` int(1) NULL DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `order_type` int(1) NULL DEFAULT NULL COMMENT '订单类型：0->正常订单；1->秒杀订单',
  `delivery_company` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流公司(配送方式)',
  `delivery_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流单号',
  `auto_confirm_day` int(11) NULL DEFAULT NULL COMMENT '自动确认时间（天）',
  `get_aurora_point` int(11) NULL DEFAULT NULL COMMENT '可以获得的极光值',
  `get_aurora_bit` int(11) NULL DEFAULT NULL COMMENT '可以活动的极光币',
  `promotion_info` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动信息',
  `bill_type` int(1) NULL DEFAULT NULL COMMENT '发票类型：0->不开发票；1->电子发票；2->纸质发票',
  `bill_header` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票抬头',
  `bill_content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票内容',
  `bill_receiver_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收票人电话',
  `bill_receiver_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收票人邮箱',
  `receiver_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人姓名',
  `receiver_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人电话',
  `receiver_post_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人邮编',
  `receiver_province` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份/直辖市',
  `receiver_city` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
  `receiver_region` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `receiver_detail_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单备注',
  `confirm_status` int(1) NULL DEFAULT NULL COMMENT '确认收货状态：0->未确认；1->已确认',
  `delete_status` int(1) NOT NULL DEFAULT 0 COMMENT '删除状态：0->未删除；1->已删除',
  `payment_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `delivery_time` datetime NULL DEFAULT NULL COMMENT '发货时间',
  `receive_time` datetime NULL DEFAULT NULL COMMENT '确认收货时间',
  `comment_time` datetime NULL DEFAULT NULL COMMENT '评价时间',
  `modify_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单管理模块订单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_order
-- ----------------------------

-- ----------------------------
-- Table structure for bms_order_item
-- ----------------------------
DROP TABLE IF EXISTS `bms_order_item`;
CREATE TABLE `bms_order_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '父订单id',
  `order_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '商品id',
  `product_pic` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `product_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `product_brand` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品品牌',
  `product_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品货号/编号',
  `product_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '销售价格',
  `product_quantity` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  `product_sku_id` bigint(20) NULL DEFAULT NULL COMMENT '商品套餐id',
  `product_sku_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品sku条码',
  `product_category_id` bigint(20) NULL DEFAULT NULL COMMENT '商品分类id',
  `coupon_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '极光券优惠分解金额',
  `real_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '该商品经过优惠后的分解金额',
  `product_sku_attr` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品销售属性:[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"尺寸\",\"value\":\"24英寸\"}]',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单管理模块订单子表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for bms_order_log
-- ----------------------------
DROP TABLE IF EXISTS `bms_order_log`;
CREATE TABLE `bms_order_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `log_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `log_detail` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作详情，这里可以以json等格式保留信息',
  `log_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1.1.1.1' COMMENT '操作者登录ip',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单管理模块订单日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_order_log
-- ----------------------------

-- ----------------------------
-- Table structure for bms_order_reason
-- ----------------------------
DROP TABLE IF EXISTS `bms_order_reason`;
CREATE TABLE `bms_order_reason`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原因类型',
  `status` int(1) NULL DEFAULT NULL COMMENT '是否启用：0->不启用；1->启用',
  `create_time` datetime NULL DEFAULT NULL COMMENT '添加时间',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `receive_note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单管理模块订单售后原因表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_order_reason
-- ----------------------------

-- ----------------------------
-- Table structure for bms_order_return
-- ----------------------------
DROP TABLE IF EXISTS `bms_order_return`;
CREATE TABLE `bms_order_return`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单id',
  `company_address_id` bigint(20) NULL DEFAULT NULL COMMENT '收货地址表id',
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '退货商品id',
  `order_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `member_username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员用户名',
  `return_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '退款金额',
  `return_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货人姓名',
  `return_phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货人电话',
  `status` int(1) NULL DEFAULT NULL COMMENT '申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝',
  `handle_time` datetime NULL DEFAULT NULL COMMENT '处理时间',
  `product_pic` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `product_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `product_brand` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品品牌',
  `product_sku_attr` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品销售属性:[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"尺寸\",\"value\":\"24英寸\"}]',
  `product_count` int(11) NULL DEFAULT NULL COMMENT '退货数量',
  `product_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品单价',
  `product_real_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品实际支付单价',
  `reason` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原因',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `proof_pics` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '凭证图片，以逗号隔开',
  `handle_note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理备注',
  `handle_man` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理人员',
  `receive_man` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `receive_time` datetime NULL DEFAULT NULL COMMENT '收货时间',
  `receive_note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单管理模块订单售后表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_order_return
-- ----------------------------

-- ----------------------------
-- Table structure for bms_order_timetask
-- ----------------------------
DROP TABLE IF EXISTS `bms_order_timetask`;
CREATE TABLE `bms_order_timetask`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `flash_time` int(11) NULL DEFAULT NULL COMMENT '任务定时',
  `create_time` datetime NULL DEFAULT NULL COMMENT '添加时间',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `detail` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务详情',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单管理模块订单定时任务表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_order_timetask
-- ----------------------------

-- ----------------------------
-- Table structure for bms_product
-- ----------------------------
DROP TABLE IF EXISTS `bms_product`;
CREATE TABLE `bms_product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `brand_id` bigint(20) NULL DEFAULT NULL COMMENT '商品品牌id',
  `brand_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `product_type_id` bigint(20) NULL DEFAULT NULL COMMENT '商品类型id',
  `product_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品类型名称',
  `product_category_id` bigint(20) NULL DEFAULT NULL COMMENT '商品分类id',
  `product_category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品分类名称',
  `product_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品货号/编号',
  `push_status` int(1) NULL DEFAULT NULL COMMENT '上架状态：0->下架；1->上架',
  `new_status` int(1) NULL DEFAULT NULL COMMENT '新品状态:0->不是新品；1->新品',
  `recommand_status` int(1) NULL DEFAULT NULL COMMENT '推荐状态；0->不推荐；1->推荐',
  `verify_status` int(1) NULL DEFAULT NULL COMMENT '审核状态：0->未审核；1->审核通过',
  `delete_status` int(1) NULL DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序，默认升序',
  `sale` int(11) NULL DEFAULT NULL COMMENT '商品总销量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '标价',
  `aurora_point` int(11) NULL DEFAULT 0 COMMENT '赠送的极光值',
  `aurora_bit` int(11) NULL DEFAULT 0 COMMENT '赠送的极光币',
  `sub_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '副标题',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品描述',
  `stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  `low_stock` int(11) NULL DEFAULT NULL COMMENT '库存预警值',
  `unit` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `weight` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品重量，默认为克',
  `preview_status` int(1) NULL DEFAULT NULL COMMENT '是否为秒杀商品：0->不是；1->是',
  `service_ids` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '以逗号分割的产品服务：1->包邮；2->急速退款；3->7天无理由；4->此商品不可用极光券',
  `detail_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品详情标题',
  `detail_html` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '产品详情网页内容',
  `detail_mobile_html` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '移动/小程序端网页详情',
  `promotion_start_time` datetime NULL DEFAULT NULL COMMENT '促销开始时间',
  `promotion_end_time` datetime NULL DEFAULT NULL COMMENT '促销结束时间',
  `promotion_per_limit` int(11) NULL DEFAULT NULL COMMENT '活动限购数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品管理模块商品表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_product
-- ----------------------------

-- ----------------------------
-- Table structure for bms_product_attribute
-- ----------------------------
DROP TABLE IF EXISTS `bms_product_attribute`;
CREATE TABLE `bms_product_attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性名称',
  `param_id` bigint(20) NULL DEFAULT NULL COMMENT '父属性id',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性值，以json格式保存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品管理模块商品类型属性表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_product_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for bms_product_brand
-- ----------------------------
DROP TABLE IF EXISTS `bms_product_brand`;
CREATE TABLE `bms_product_brand`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌logo',
  `show_status` int(1) NULL DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `product_count` int(11) NULL DEFAULT NULL COMMENT '产品数量',
  `big_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌专区大海报',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品管理模块商品品牌表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_product_brand
-- ----------------------------

-- ----------------------------
-- Table structure for bms_product_group
-- ----------------------------
DROP TABLE IF EXISTS `bms_product_group`;
CREATE TABLE `bms_product_group`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '套餐对应的商品id',
  `group_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套餐编码',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '套餐价格',
  `stock` int(11) NULL DEFAULT 0 COMMENT '库存',
  `low_stock` int(11) NULL DEFAULT NULL COMMENT '预警库存',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展示图片',
  `sale` int(11) NULL DEFAULT NULL COMMENT '销量',
  `lock_stock` int(11) NULL DEFAULT 0 COMMENT '锁定库存',
  `sp_data` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品销售属性，以json格式保存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品管理模块商品套餐表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_product_group
-- ----------------------------

-- ----------------------------
-- Table structure for bms_product_log
-- ----------------------------
DROP TABLE IF EXISTS `bms_product_log`;
CREATE TABLE `bms_product_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `log_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `log_detail` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作详情，这里可以以json等格式保留信息',
  `log_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1.1.1.1' COMMENT '操作者登录ip',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品管理模块商品操作日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_product_log
-- ----------------------------

-- ----------------------------
-- Table structure for bms_product_parameter
-- ----------------------------
DROP TABLE IF EXISTS `bms_product_parameter`;
CREATE TABLE `bms_product_parameter`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数名称',
  `param_id` bigint(20) NULL DEFAULT NULL COMMENT '父参数id',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数值，以json格式保存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品管理模块商品类型参数表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_product_parameter
-- ----------------------------

-- ----------------------------
-- Table structure for bms_product_sku
-- ----------------------------
DROP TABLE IF EXISTS `bms_product_sku`;
CREATE TABLE `bms_product_sku`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '套餐对应的商品id',
  `sku_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '套餐编码',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '套餐价格',
  `stock` int(11) NULL DEFAULT 0 COMMENT '库存',
  `low_stock` int(11) NULL DEFAULT NULL COMMENT '预警库存',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展示图片',
  `sale` int(11) NULL DEFAULT NULL COMMENT '销量',
  `lock_stock` int(11) NULL DEFAULT 0 COMMENT '锁定库存',
  `sp_data` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品销售属性，以json格式保存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品管理模块商品套餐表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_product_sku
-- ----------------------------

-- ----------------------------
-- Table structure for bms_product_sort
-- ----------------------------
DROP TABLE IF EXISTS `bms_product_sort`;
CREATE TABLE `bms_product_sort`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父id：0表示一级分类',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `level` int(1) NULL DEFAULT NULL COMMENT '分类级别：0->1级；1->2级',
  `show_status` int(1) NULL DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品管理模块商品分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_product_sort
-- ----------------------------

-- ----------------------------
-- Table structure for bms_product_type
-- ----------------------------
DROP TABLE IF EXISTS `bms_product_type`;
CREATE TABLE `bms_product_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性名称',
  `attribute_count` int(11) NULL DEFAULT 0 COMMENT '属性数量，默认为0',
  `param_count` int(11) NULL DEFAULT 0 COMMENT '参数数量，默认为0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品管理模块商品类型表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_product_type
-- ----------------------------

-- ----------------------------
-- Table structure for bms_user_address
-- ----------------------------
DROP TABLE IF EXISTS `bms_user_address`;
CREATE TABLE `bms_user_address`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收件人名称',
  `phone_number` bigint(11) NULL DEFAULT NULL COMMENT '收件人号码',
  `default_status` int(1) NULL DEFAULT NULL COMMENT '是否为默认：0->不是；1->是',
  `post_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码',
  `province` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份/直辖市',
  `city` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
  `region` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `detail_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址(街道)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员管理模块会员用户地址管理表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_user_address
-- ----------------------------

-- ----------------------------
-- Table structure for bms_user_grade
-- ----------------------------
DROP TABLE IF EXISTS `bms_user_grade`;
CREATE TABLE `bms_user_grade`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员管理模块会员用户等级表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_user_grade
-- ----------------------------

-- ----------------------------
-- Table structure for bms_user_grade_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `bms_user_grade_role_relation`;
CREATE TABLE `bms_user_grade_role_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员管理模块会员用户等级角色关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_user_grade_role_relation
-- ----------------------------

-- ----------------------------
-- Table structure for bms_user_grade_rule
-- ----------------------------
DROP TABLE IF EXISTS `bms_user_grade_rule`;
CREATE TABLE `bms_user_grade_rule`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '等级名称',
  `aurora_point` int(1) NULL DEFAULT NULL COMMENT '到达当前等级需要的极光值',
  `detail` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '等级详情',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员管理模块会员用户等级规则表(每天结算一次等级)' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_user_grade_rule
-- ----------------------------

-- ----------------------------
-- Table structure for bms_user_info
-- ----------------------------
DROP TABLE IF EXISTS `bms_user_info`;
CREATE TABLE `bms_user_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `status` int(1) NULL DEFAULT NULL COMMENT '帐号启用状态:0->禁用；1->启用',
  `create_time` datetime NULL DEFAULT NULL COMMENT '注册时间',
  `avatar` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` int(1) NULL DEFAULT NULL COMMENT '性别：0->未知；1->男；2->女',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `job` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `personalized_signature` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `source_type` int(1) NULL DEFAULT NULL COMMENT '用户注册来源',
  `aurora_point` int(11) NULL DEFAULT NULL COMMENT '极光值',
  `aurora_bit` int(11) NULL DEFAULT NULL COMMENT '极光币',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_username`(`username`) USING BTREE,
  UNIQUE INDEX `idx_phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员管理模块会员用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_user_info
-- ----------------------------

-- ----------------------------
-- Table structure for bms_user_info_grade_relation
-- ----------------------------
DROP TABLE IF EXISTS `bms_user_info_grade_relation`;
CREATE TABLE `bms_user_info_grade_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `level_id` bigint(20) NULL DEFAULT NULL COMMENT '等级ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员管理模块会员用户用户等级关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_user_info_grade_relation
-- ----------------------------

-- ----------------------------
-- Table structure for bms_user_level
-- ----------------------------
DROP TABLE IF EXISTS `bms_user_level`;
CREATE TABLE `bms_user_level`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '等级名称',
  `default_status` int(1) NULL DEFAULT NULL COMMENT '是否为默认等级：0->不是；1->是',
  `comment_aurora_point` int(11) NULL DEFAULT NULL COMMENT '评价奖励的极光值',
  `shop_aurora_point` int(1) NULL DEFAULT NULL COMMENT '购物奖励的极光值',
  `comment_aurora_bit` int(11) NULL DEFAULT NULL COMMENT '评价奖励的极光币',
  `shop_aurora_bit` int(1) NULL DEFAULT NULL COMMENT '购物奖励的极光币',
  `detail` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '等级详情',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员管理模块会员用户等级表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_user_level
-- ----------------------------

-- ----------------------------
-- Table structure for bms_user_log
-- ----------------------------
DROP TABLE IF EXISTS `bms_user_log`;
CREATE TABLE `bms_user_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `log_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `log_detail` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作详情，这里可以以json等格式保留信息',
  `log_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1.1.1.1' COMMENT '操作者登录ip',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员管理模块会员用户操作日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_user_log
-- ----------------------------

-- ----------------------------
-- Table structure for ums_car
-- ----------------------------
DROP TABLE IF EXISTS `ums_car`;
CREATE TABLE `ums_car`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车模块购物车表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_car
-- ----------------------------

-- ----------------------------
-- Table structure for ums_car_item
-- ----------------------------
DROP TABLE IF EXISTS `ums_car_item`;
CREATE TABLE `ums_car_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cart_id` bigint(20) NULL DEFAULT NULL COMMENT '商品id',
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '商品id',
  `product_sku_id` bigint(20) NULL DEFAULT NULL COMMENT '商品套餐id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '购物车商品价格',
  `product_pic` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `product_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `product_sku_code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品套餐编码',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `delete_status` int(1) NULL DEFAULT 0 COMMENT '是否删除',
  `product_sn` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品编码',
  `product_attr` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品销售属性:[{\"key\":\"颜色\",\"value\":\"蓝色\"},{\"key\":\"尺寸\",\"value\":\"24英寸\"}]',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车模块购物车子表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_car_item
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
