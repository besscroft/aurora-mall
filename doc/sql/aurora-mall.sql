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

 Date: 17/04/2021 21:58:00
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
  `path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由地址',
  `icon` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端图标',
  `hidden` int(1) NULL DEFAULT 1 COMMENT '显示状态：0->显示；1->不显示',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_menu
-- ----------------------------
INSERT INTO `bms_auth_menu` VALUES (1, 0, '2021-03-21 18:56:44', '权限管理', NULL, 1, 1, 'auth', '/auth', 'el-icon-success', 0, 'Layout');
INSERT INTO `bms_auth_menu` VALUES (2, 0, '2021-03-21 18:57:06', '订单管理', NULL, 1, 2, 'order', '/order', 'el-icon-s-order', 0, 'Layout');
INSERT INTO `bms_auth_menu` VALUES (3, 0, '2021-03-21 18:57:49', '商品管理', NULL, 1, 3, 'product', '/product', 'el-icon-s-goods', 0, 'Layout');
INSERT INTO `bms_auth_menu` VALUES (4, 0, '2021-03-30 10:47:44', '营销管理', NULL, 1, 4, 'market', '/market', 'el-icon-s-marketing', 0, 'Layout');
INSERT INTO `bms_auth_menu` VALUES (5, 0, '2021-03-30 10:48:47', '会员管理', NULL, 1, 5, 'user', '/user', 'el-icon-user-solid', 0, 'Layout');
INSERT INTO `bms_auth_menu` VALUES (6, 0, '2021-03-30 10:49:29', '系统管理', NULL, 1, 6, 'system', '/system', 'el-icon-s-tools', 0, 'Layout');
INSERT INTO `bms_auth_menu` VALUES (10, 1, '2021-03-21 18:57:47', '用户管理', '权限管理', 2, 0, 'authUser', '/auth/authUser', 'el-icon-user-solid', 0, '/auth/authUser/index');
INSERT INTO `bms_auth_menu` VALUES (11, 1, '2021-03-21 18:58:31', '角色管理', '权限管理', 2, 0, 'authRole', '/auth/authRole', 'el-icon-s-custom', 0, '/auth/authRole/index');
INSERT INTO `bms_auth_menu` VALUES (12, 1, '2021-03-21 18:58:34', '菜单管理', '权限管理', 2, 0, 'authMenu', '/auth/authMenu', 'el-icon-menu', 0, '/auth/authMenu/index');
INSERT INTO `bms_auth_menu` VALUES (13, 1, '2021-03-30 10:41:52', '资源管理', '权限管理', 2, 0, 'authResource', '/auth/authResource', 'el-icon-s-promotion', 0, '/auth/authResource/index');
INSERT INTO `bms_auth_menu` VALUES (14, 1, '2021-03-30 10:44:02', '权限管理', '权限管理', 2, 0, 'authPermission', '/auth/authPermission', 'el-icon-check', 0, '/auth/authPermission/index');
INSERT INTO `bms_auth_menu` VALUES (15, 1, '2021-03-30 10:46:32', '资源类别管理', '权限管理', 2, 0, 'authResourceSort', '/auth/authResourceSort', 'el-icon-finished', 0, '/auth/authResourceSort/index');
INSERT INTO `bms_auth_menu` VALUES (20, 2, '2021-03-30 10:36:21', '订单列表', '订单管理', 2, 0, 'orderList', '/order/orderList', 'el-icon-s-order', 0, '/order/orderList/index');
INSERT INTO `bms_auth_menu` VALUES (21, 2, '2021-03-30 10:38:40', '定时任务', '订单管理', 2, 0, 'orderTimeTask', '/order/orderTimeTask', 'el-icon-timer', 0, '/order/orderTimeTask/index');
INSERT INTO `bms_auth_menu` VALUES (22, 2, '2021-03-30 10:39:58', '售后订单', '订单管理', 2, 0, 'orderReturn', '/order/orderReturn', 'el-icon-s-claim', 0, '/order/orderReturn');
INSERT INTO `bms_auth_menu` VALUES (23, 2, '2021-03-30 10:40:43', '售后原因', '订单管理', 2, 0, 'orderReason', '/order/orderReason', 'el-icon-notebook-1', 0, '/order/orderReason/index');
INSERT INTO `bms_auth_menu` VALUES (30, 3, '2021-03-30 10:33:46', '品牌管理', '商品管理', 2, 0, 'productBrand', '/product/productBrand', 'el-icon-postcard', 0, '/product/productBrand/index');
INSERT INTO `bms_auth_menu` VALUES (31, 3, '2021-03-27 15:47:53', '商品列表', '商品管理', 2, 0, 'productList', '/product/productList', 'el-icon-s-goods', 0, '/product/productList/index');
INSERT INTO `bms_auth_menu` VALUES (32, 3, '2021-03-30 10:31:03', '类型管理', '商品管理', 2, 0, 'productType', '/product/productType', 'el-icon-price-tag', 0, '/product/productType/index');
INSERT INTO `bms_auth_menu` VALUES (33, 3, '2021-03-30 10:29:15', '分类管理', '商品管理', 2, 0, 'productSort', '/product/productSort', 'el-icon-discount', 0, '/product/productSort/index');
INSERT INTO `bms_auth_menu` VALUES (34, 3, '2021-03-27 15:49:10', '修改商品', '商品管理', 2, 0, 'productUpdate', '/product/productUpdate', 'el-icon-sold-out', 0, '/product/productUpdate/index');
INSERT INTO `bms_auth_menu` VALUES (35, 3, '2021-03-27 15:49:04', '添加商品', '商品管理', 2, 0, 'productAdd', '/product/productAdd', 'el-icon-sell', 0, '/product/productAdd/index');
INSERT INTO `bms_auth_menu` VALUES (40, 4, '2021-03-30 10:54:02', '虚拟币管理', '营销管理', 2, 0, 'marketBit', '/market/marketBit', 'el-icon-s-finance', 0, '/market/marketBit/index');
INSERT INTO `bms_auth_menu` VALUES (41, 4, '2021-03-30 10:51:23', '秒杀管理', '营销管理', 2, 0, 'marketSpike', '/market/marketSpike', 'el-icon-alarm-clock', 0, '/market/marketSpike/index');
INSERT INTO `bms_auth_menu` VALUES (42, 4, '2021-03-30 10:52:29', '优惠券管理', '营销管理', 2, 0, 'marketCoupon', '/market/marketCoupon', 'el-icon-s-ticket', 0, '/market/marketCoupon/index');
INSERT INTO `bms_auth_menu` VALUES (43, 4, '2021-03-30 10:53:21', '广告管理', '营销管理', 2, 0, 'marketAD', '/market/marketAD', 'el-icon-data-line', 0, '/market/marketAD/index');
INSERT INTO `bms_auth_menu` VALUES (50, 5, '2021-03-30 10:55:06', '会员列表', '会员管理', 2, 0, 'userList', '/user/userList', 'el-icon-user', 0, '/user/userList/index');
INSERT INTO `bms_auth_menu` VALUES (51, 6, '2021-04-10 10:39:32', '版本日志', '系统管理', 2, 0, 'version', '/system/version', 'el-icon-s-promotion', 0, '/system/version/index');

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
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块资源表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_resource
-- ----------------------------
INSERT INTO `bms_auth_resource` VALUES (1, '添加用户', '/user/addUser', '新增后台管理系统的用户', '2021-01-25 13:34:04', 3);
INSERT INTO `bms_auth_resource` VALUES (2, '删除用户', '/user/delUser/**', '删除后台管理系统的用户', '2021-03-17 14:32:33', 3);
INSERT INTO `bms_auth_resource` VALUES (3, '用户信息', '/user/info', '管理系统用户登陆后查询个人信息', '2021-03-17 15:32:20', 3);
INSERT INTO `bms_auth_resource` VALUES (4, '修改用户', '/user/updateUser', '更新后台管理系统用户信息', '2021-03-21 13:42:59', 3);
INSERT INTO `bms_auth_resource` VALUES (5, '用户列表', '/user/list', '获取管理系统所有用户', '2021-04-04 10:45:53', 3);
INSERT INTO `bms_auth_resource` VALUES (6, '导出用户', '/user/exportUser', '导出权限管理模块用户', '2021-04-04 13:47:26', 3);
INSERT INTO `bms_auth_resource` VALUES (7, '获取用户', '/user/getUser/**', '根据id获取用户', '2021-04-04 13:54:04', 3);
INSERT INTO `bms_auth_resource` VALUES (8, '更新状态', '/user/changeSwitch', '用户账户启用状态更新', '2021-04-04 15:29:37', 3);
INSERT INTO `bms_auth_resource` VALUES (9, '导出列表', '/user/export', '导出管理系统用户列表', '2021-04-04 21:56:06', 3);
INSERT INTO `bms_auth_resource` VALUES (10, '菜单列表', '/menu/list', '查询后台管理菜单列表', '2021-04-09 21:20:56', 2);
INSERT INTO `bms_auth_resource` VALUES (11, '菜单详情', '/menu/getMenu/**', '根据id查询菜单详情', '2021-04-09 21:21:33', 2);
INSERT INTO `bms_auth_resource` VALUES (12, '修改菜单', '/menu/updateMenu', '修改菜单', '2021-04-09 21:21:53', 2);
INSERT INTO `bms_auth_resource` VALUES (13, '更新状态', '/menu/changeSwitch', '菜单是否显示状态更新', '2021-04-09 21:22:27', 2);
INSERT INTO `bms_auth_resource` VALUES (14, '删除菜单', '/menu/delMenu/**', '根据id删除菜单', '2021-04-09 21:23:00', 2);
INSERT INTO `bms_auth_resource` VALUES (15, '新增菜单', '/menu/addMenu', '新增菜单', '2021-04-09 21:23:23', 2);
INSERT INTO `bms_auth_resource` VALUES (16, '父菜单查询', '/menu/getParentMenu', '查询所有的父菜单', '2021-04-09 22:12:04', 2);
INSERT INTO `bms_auth_resource` VALUES (17, '角色列表', '/role/list', '获取角色列表', '2021-04-10 09:35:50', 6);
INSERT INTO `bms_auth_resource` VALUES (18, '角色信息', '/role/getRole/**', '查询角色详细', '2021-04-10 09:37:06', 6);
INSERT INTO `bms_auth_resource` VALUES (19, '新增角色', '/role/addRole', '新增角色', '2021-04-10 09:37:42', 6);
INSERT INTO `bms_auth_resource` VALUES (20, '修改角色', '/role/updateRole', '修改角色信息', '2021-04-10 09:38:09', 6);
INSERT INTO `bms_auth_resource` VALUES (21, '删除角色', '/role/delRole/**', '根据id删除角色', '2021-04-10 09:38:43', 6);
INSERT INTO `bms_auth_resource` VALUES (22, '更新状态', '/role/changeSwitch', '角色启用状态更新', '2021-04-10 09:39:29', 6);
INSERT INTO `bms_auth_resource` VALUES (23, '资源列表', '/resource/list', '获取资源列表', '2021-04-10 10:57:07', 5);
INSERT INTO `bms_auth_resource` VALUES (24, '资源详情', '/resource/getResource/**', '根据id获取资源详情', '2021-04-10 10:57:43', 5);
INSERT INTO `bms_auth_resource` VALUES (25, '新增资源', '/resource/addResource', '新增资源', '2021-04-10 10:58:09', 5);
INSERT INTO `bms_auth_resource` VALUES (26, '更新资源', '/resource/updateResource', '更新资源信息', '2021-04-10 10:58:41', 5);
INSERT INTO `bms_auth_resource` VALUES (27, '删除资源', '/resource/delResource/**', '根据id删除资源', '2021-04-10 10:59:05', 5);
INSERT INTO `bms_auth_resource` VALUES (28, '获取所有角色', '/role/getRoleAll', '获取所有角色', '2021-04-15 14:12:46', 6);
INSERT INTO `bms_auth_resource` VALUES (29, '更新用户角色', '/role/updateRoleById', '更新用户的角色', '2021-04-15 14:28:12', 6);
INSERT INTO `bms_auth_resource` VALUES (30, '查询角色', '/role/getRoleById/**', '根据用户id查询角色', '2021-04-15 14:48:39', 6);
INSERT INTO `bms_auth_resource` VALUES (31, '获取菜单树', '/menu/getMenuTreeById/**', '根据角色id获取菜单树', '2021-04-16 14:11:27', 2);
INSERT INTO `bms_auth_resource` VALUES (32, '获取所有菜单树', '/menu/getAllMenuTree', '获取所有菜单树', '2021-04-16 14:53:27', 2);
INSERT INTO `bms_auth_resource` VALUES (33, '获取资源树', '/resource/getResourceTreeById/**', '根据角色id获取资源树', '2021-04-16 15:32:32', 5);
INSERT INTO `bms_auth_resource` VALUES (34, '获取所有资源树', '/resource/getAllResourceTree', '获取所有资源树', '2021-04-16 15:33:02', 5);
INSERT INTO `bms_auth_resource` VALUES (35, '更新菜单树', '/menu/updateMenuTree', '更新菜单树', '2021-04-16 16:49:09', 2);
INSERT INTO `bms_auth_resource` VALUES (36, '更新资源树', '/resource/updateResourceTree', '更新资源树', '2021-04-16 16:49:31', 5);
INSERT INTO `bms_auth_resource` VALUES (37, '资源类别列表', '/resourceSort/list', '获取资源类别列表', '2021-04-17 19:55:38', 4);
INSERT INTO `bms_auth_resource` VALUES (38, '资源类别详细', '/resourceSort/getResourceSort/**', '查询资源类别详细', '2021-04-17 19:56:07', 4);
INSERT INTO `bms_auth_resource` VALUES (39, '新增资源类别', '/resourceSort/addResourceSort', '新增资源类别', '2021-04-17 19:56:32', 4);
INSERT INTO `bms_auth_resource` VALUES (40, '修改资源类别', '/resourceSort/updateResourceSort', '修改资源类别', '2021-04-17 19:56:54', 4);
INSERT INTO `bms_auth_resource` VALUES (41, '删除资源类别', '/resourceSort/delResourceSort/**', '删除资源类别', '2021-04-17 19:57:10', 4);
INSERT INTO `bms_auth_resource` VALUES (42, '版本日志列表', '/updateLog/list', '版本日志列表', '2021-04-17 21:41:58', 22);

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
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块资源类别管理表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_resource_sort
-- ----------------------------
INSERT INTO `bms_auth_resource_sort` VALUES (1, '权限管理', '2021-04-16 15:22:07', '权限管理', 1);
INSERT INTO `bms_auth_resource_sort` VALUES (2, '菜单管理', '2021-04-16 15:22:17', '菜单管理', 1);
INSERT INTO `bms_auth_resource_sort` VALUES (3, '用户管理', '2021-04-16 15:22:28', '用户管理', 1);
INSERT INTO `bms_auth_resource_sort` VALUES (4, '资源类别管理', '2021-04-16 15:22:39', '资源类别管理', 1);
INSERT INTO `bms_auth_resource_sort` VALUES (5, '资源管理', '2021-04-16 15:22:48', '资源管理', 1);
INSERT INTO `bms_auth_resource_sort` VALUES (6, '角色管理', '2021-04-16 15:22:57', '角色管理', 1);
INSERT INTO `bms_auth_resource_sort` VALUES (7, '售后订单', '2021-04-16 15:23:20', '售后订单', 2);
INSERT INTO `bms_auth_resource_sort` VALUES (8, '订单列表', '2021-04-16 15:23:30', '订单列表', 2);
INSERT INTO `bms_auth_resource_sort` VALUES (9, '售后原因', '2021-04-16 15:23:39', '售后原因', 2);
INSERT INTO `bms_auth_resource_sort` VALUES (10, '定时任务', '2021-04-16 15:23:48', '定时任务', 2);
INSERT INTO `bms_auth_resource_sort` VALUES (11, '修改商品', '2021-04-16 15:24:01', '修改商品', 3);
INSERT INTO `bms_auth_resource_sort` VALUES (12, '类型管理', '2021-04-16 15:24:09', '类型管理', 3);
INSERT INTO `bms_auth_resource_sort` VALUES (13, '品牌管理', '2021-04-16 15:24:17', '品牌管理', 3);
INSERT INTO `bms_auth_resource_sort` VALUES (14, '添加商品', '2021-04-16 15:24:26', '添加商品', 3);
INSERT INTO `bms_auth_resource_sort` VALUES (15, '分类管理', '2021-04-16 15:24:35', '分类管理', 3);
INSERT INTO `bms_auth_resource_sort` VALUES (16, '商品列表', '2021-04-16 15:24:43', '商品列表', 3);
INSERT INTO `bms_auth_resource_sort` VALUES (17, '优惠券管理', '2021-04-16 15:24:56', '优惠券管理', 4);
INSERT INTO `bms_auth_resource_sort` VALUES (18, '虚拟币管理', '2021-04-16 15:25:05', '虚拟币管理', 4);
INSERT INTO `bms_auth_resource_sort` VALUES (19, '广告管理', '2021-04-16 15:25:15', '广告管理', 4);
INSERT INTO `bms_auth_resource_sort` VALUES (20, '秒杀管理', '2021-04-16 15:25:29', '秒杀管理', 4);
INSERT INTO `bms_auth_resource_sort` VALUES (21, '会员列表', '2021-04-16 15:25:43', '会员列表', 5);
INSERT INTO `bms_auth_resource_sort` VALUES (22, '版本日志', '2021-04-17 21:42:33', '版本日志', 6);

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
  `del` int(1) NULL DEFAULT NULL COMMENT '假删除：0->删除状态；1->可用状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_role
-- ----------------------------
INSERT INTO `bms_auth_role` VALUES (1, '超级管理员', '超级管理员，拥有所有的权限', 1, '2021-01-25 13:31:45', 1, 0, 1);
INSERT INTO `bms_auth_role` VALUES (2, '测试员111', '测试账号权限', 2, '2021-03-21 13:41:37', 1, 0, 1);
INSERT INTO `bms_auth_role` VALUES (3, '111', '111', NULL, NULL, 1, 1, 0);

-- ----------------------------
-- Table structure for bms_auth_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_role_menu_relation`;
CREATE TABLE `bms_auth_role_menu_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块角色菜单关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_role_menu_relation
-- ----------------------------
INSERT INTO `bms_auth_role_menu_relation` VALUES (1, 1, 1);
INSERT INTO `bms_auth_role_menu_relation` VALUES (2, 1, 2);
INSERT INTO `bms_auth_role_menu_relation` VALUES (3, 1, 3);
INSERT INTO `bms_auth_role_menu_relation` VALUES (4, 1, 4);
INSERT INTO `bms_auth_role_menu_relation` VALUES (5, 1, 5);
INSERT INTO `bms_auth_role_menu_relation` VALUES (6, 1, 6);
INSERT INTO `bms_auth_role_menu_relation` VALUES (8, 1, 10);
INSERT INTO `bms_auth_role_menu_relation` VALUES (9, 1, 11);
INSERT INTO `bms_auth_role_menu_relation` VALUES (10, 1, 12);
INSERT INTO `bms_auth_role_menu_relation` VALUES (11, 1, 13);
INSERT INTO `bms_auth_role_menu_relation` VALUES (12, 1, 14);
INSERT INTO `bms_auth_role_menu_relation` VALUES (13, 1, 15);
INSERT INTO `bms_auth_role_menu_relation` VALUES (14, 1, 20);
INSERT INTO `bms_auth_role_menu_relation` VALUES (15, 1, 21);
INSERT INTO `bms_auth_role_menu_relation` VALUES (16, 1, 22);
INSERT INTO `bms_auth_role_menu_relation` VALUES (17, 1, 23);
INSERT INTO `bms_auth_role_menu_relation` VALUES (18, 1, 30);
INSERT INTO `bms_auth_role_menu_relation` VALUES (19, 1, 31);
INSERT INTO `bms_auth_role_menu_relation` VALUES (20, 1, 32);
INSERT INTO `bms_auth_role_menu_relation` VALUES (21, 1, 33);
INSERT INTO `bms_auth_role_menu_relation` VALUES (22, 1, 34);
INSERT INTO `bms_auth_role_menu_relation` VALUES (23, 1, 35);
INSERT INTO `bms_auth_role_menu_relation` VALUES (24, 1, 40);
INSERT INTO `bms_auth_role_menu_relation` VALUES (25, 1, 41);
INSERT INTO `bms_auth_role_menu_relation` VALUES (26, 1, 42);
INSERT INTO `bms_auth_role_menu_relation` VALUES (27, 1, 43);
INSERT INTO `bms_auth_role_menu_relation` VALUES (28, 1, 50);
INSERT INTO `bms_auth_role_menu_relation` VALUES (42, 1, 51);
INSERT INTO `bms_auth_role_menu_relation` VALUES (56, 2, 1);
INSERT INTO `bms_auth_role_menu_relation` VALUES (57, 2, 10);
INSERT INTO `bms_auth_role_menu_relation` VALUES (58, 2, 11);
INSERT INTO `bms_auth_role_menu_relation` VALUES (59, 2, 12);
INSERT INTO `bms_auth_role_menu_relation` VALUES (60, 2, 13);
INSERT INTO `bms_auth_role_menu_relation` VALUES (61, 2, 14);
INSERT INTO `bms_auth_role_menu_relation` VALUES (62, 2, 15);
INSERT INTO `bms_auth_role_menu_relation` VALUES (63, 2, 2);
INSERT INTO `bms_auth_role_menu_relation` VALUES (64, 2, 20);
INSERT INTO `bms_auth_role_menu_relation` VALUES (65, 2, 21);
INSERT INTO `bms_auth_role_menu_relation` VALUES (66, 2, 22);
INSERT INTO `bms_auth_role_menu_relation` VALUES (67, 2, 23);
INSERT INTO `bms_auth_role_menu_relation` VALUES (68, 2, 30);
INSERT INTO `bms_auth_role_menu_relation` VALUES (69, 2, 31);

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
) ENGINE = InnoDB AUTO_INCREMENT = 154 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块角色资源关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_role_resource_relation
-- ----------------------------
INSERT INTO `bms_auth_role_resource_relation` VALUES (68, 2, 3);
INSERT INTO `bms_auth_role_resource_relation` VALUES (69, 2, 5);
INSERT INTO `bms_auth_role_resource_relation` VALUES (70, 2, 7);
INSERT INTO `bms_auth_role_resource_relation` VALUES (112, 1, 10);
INSERT INTO `bms_auth_role_resource_relation` VALUES (113, 1, 11);
INSERT INTO `bms_auth_role_resource_relation` VALUES (114, 1, 12);
INSERT INTO `bms_auth_role_resource_relation` VALUES (115, 1, 13);
INSERT INTO `bms_auth_role_resource_relation` VALUES (116, 1, 14);
INSERT INTO `bms_auth_role_resource_relation` VALUES (117, 1, 15);
INSERT INTO `bms_auth_role_resource_relation` VALUES (118, 1, 16);
INSERT INTO `bms_auth_role_resource_relation` VALUES (119, 1, 31);
INSERT INTO `bms_auth_role_resource_relation` VALUES (120, 1, 32);
INSERT INTO `bms_auth_role_resource_relation` VALUES (121, 1, 35);
INSERT INTO `bms_auth_role_resource_relation` VALUES (122, 1, 1);
INSERT INTO `bms_auth_role_resource_relation` VALUES (123, 1, 2);
INSERT INTO `bms_auth_role_resource_relation` VALUES (124, 1, 3);
INSERT INTO `bms_auth_role_resource_relation` VALUES (125, 1, 4);
INSERT INTO `bms_auth_role_resource_relation` VALUES (126, 1, 5);
INSERT INTO `bms_auth_role_resource_relation` VALUES (127, 1, 6);
INSERT INTO `bms_auth_role_resource_relation` VALUES (128, 1, 7);
INSERT INTO `bms_auth_role_resource_relation` VALUES (129, 1, 8);
INSERT INTO `bms_auth_role_resource_relation` VALUES (130, 1, 9);
INSERT INTO `bms_auth_role_resource_relation` VALUES (131, 1, 37);
INSERT INTO `bms_auth_role_resource_relation` VALUES (132, 1, 38);
INSERT INTO `bms_auth_role_resource_relation` VALUES (133, 1, 39);
INSERT INTO `bms_auth_role_resource_relation` VALUES (134, 1, 40);
INSERT INTO `bms_auth_role_resource_relation` VALUES (135, 1, 41);
INSERT INTO `bms_auth_role_resource_relation` VALUES (136, 1, 23);
INSERT INTO `bms_auth_role_resource_relation` VALUES (137, 1, 24);
INSERT INTO `bms_auth_role_resource_relation` VALUES (138, 1, 25);
INSERT INTO `bms_auth_role_resource_relation` VALUES (139, 1, 26);
INSERT INTO `bms_auth_role_resource_relation` VALUES (140, 1, 27);
INSERT INTO `bms_auth_role_resource_relation` VALUES (141, 1, 33);
INSERT INTO `bms_auth_role_resource_relation` VALUES (142, 1, 34);
INSERT INTO `bms_auth_role_resource_relation` VALUES (143, 1, 36);
INSERT INTO `bms_auth_role_resource_relation` VALUES (144, 1, 17);
INSERT INTO `bms_auth_role_resource_relation` VALUES (145, 1, 18);
INSERT INTO `bms_auth_role_resource_relation` VALUES (146, 1, 19);
INSERT INTO `bms_auth_role_resource_relation` VALUES (147, 1, 20);
INSERT INTO `bms_auth_role_resource_relation` VALUES (148, 1, 21);
INSERT INTO `bms_auth_role_resource_relation` VALUES (149, 1, 22);
INSERT INTO `bms_auth_role_resource_relation` VALUES (150, 1, 28);
INSERT INTO `bms_auth_role_resource_relation` VALUES (151, 1, 29);
INSERT INTO `bms_auth_role_resource_relation` VALUES (152, 1, 30);
INSERT INTO `bms_auth_role_resource_relation` VALUES (153, 1, 42);

-- ----------------------------
-- Table structure for bms_auth_user
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_user`;
CREATE TABLE `bms_auth_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `nick_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
  `del` int(1) NOT NULL COMMENT '假删除：0->删除状态；1->可用状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_user
-- ----------------------------
INSERT INTO `bms_auth_user` VALUES (1, 'admin', '$2a$10$E0A60hzJ.yBHJhyZ970Oze205OGuu4LIrjDSPQvcGBDl40O0oaiqC', 'https://www.52bess.com/uploads/avatar.png', 'admin@qq.com', '12345678901', '管理员', '管理员', '2021-02-24 21:22:48', '2021-04-17 21:55:14', 1, 1);
INSERT INTO `bms_auth_user` VALUES (2, 'test', '$2a$10$E0A60hzJ.yBHJhyZ970Oze205OGuu4LIrjDSPQvcGBDl40O0oaiqC', 'https://www.52bess.com/uploads/avatar.png', 'test@qq.com', '12345678902', '测试员', '测试员', '2021-03-21 13:42:10', '2021-04-04 17:26:03', 1, 1);
INSERT INTO `bms_auth_user` VALUES (3, 'user1', '$2a$10$U9qlXI22XmUjzAgZiH0kMOalOkBTM23LvmAownM1GNXNQTRhO4Mtu', 'https://www.52bess.com/uploads/avatar.png', 'user1@qq.com', '111', '普通用户1', '普通用户1', '2021-04-04 18:18:44', '2021-04-04 18:18:44', 1, 1);
INSERT INTO `bms_auth_user` VALUES (4, 'user2', '$2a$10$qbw14yY1.sHYGb/dytzdSeSSR78KXjoHG3XQImP/iqh7iGjCc.TZK', 'https://www.52bess.com/uploads/avatar.png', 'user2@qq.com', '112', '普通用户2', '普通用户2', '2021-04-04 18:37:01', '2021-04-04 18:37:01', 1, 1);
INSERT INTO `bms_auth_user` VALUES (5, 'user3', '$2a$10$E0A60hzJ.yBHJhyZ970Oze205OGuu4LIrjDSPQvcGBDl40O0oaiqC', 'https://www.52bess.com/uploads/avatar.png', 'user3@qq.com', '113', '普通用户3', '普通用户3', '2021-04-04 22:04:50', '2021-04-04 22:04:28', 1, 1);
INSERT INTO `bms_auth_user` VALUES (6, 'user4', '$2a$10$E0A60hzJ.yBHJhyZ970Oze205OGuu4LIrjDSPQvcGBDl40O0oaiqC', 'https://www.52bess.com/uploads/avatar.png', 'user4@qq.com', '114', '普通用户4', '普通用户4', '2021-04-04 22:04:52', '2021-04-04 22:04:31', 1, 1);
INSERT INTO `bms_auth_user` VALUES (7, 'user5', '$2a$10$E0A60hzJ.yBHJhyZ970Oze205OGuu4LIrjDSPQvcGBDl40O0oaiqC', 'https://www.52bess.com/uploads/avatar.png', 'user5@qq.com', '115', '普通用户5', '普通用户5', '2021-04-04 22:04:54', '2021-04-04 22:04:33', 1, 1);
INSERT INTO `bms_auth_user` VALUES (8, 'user6', '$2a$10$E0A60hzJ.yBHJhyZ970Oze205OGuu4LIrjDSPQvcGBDl40O0oaiqC', 'https://www.52bess.com/uploads/avatar.png', 'user6@qq.com', '116', '普通用户6', '普通用户6', '2021-04-04 22:04:57', '2021-04-04 22:04:36', 1, 1);
INSERT INTO `bms_auth_user` VALUES (9, 'user7', '$2a$10$E0A60hzJ.yBHJhyZ970Oze205OGuu4LIrjDSPQvcGBDl40O0oaiqC', 'https://www.52bess.com/uploads/avatar.png', 'user7@qq.com', '117', '普通用户7', '普通用户7', '2021-04-04 22:04:59', '2021-04-04 22:04:38', 1, 1);
INSERT INTO `bms_auth_user` VALUES (10, 'user8', '$2a$10$E0A60hzJ.yBHJhyZ970Oze205OGuu4LIrjDSPQvcGBDl40O0oaiqC', 'https://www.52bess.com/uploads/avatar.png', 'user8@qq.com', '118', '普通用户8', '普通用户8', '2021-04-04 22:05:01', '2021-04-04 22:04:41', 1, 1);
INSERT INTO `bms_auth_user` VALUES (11, 'user9', '$2a$10$E0A60hzJ.yBHJhyZ970Oze205OGuu4LIrjDSPQvcGBDl40O0oaiqC', 'https://www.52bess.com/uploads/avatar.png', 'user9@qq.com', '119', '普通用户9', '普通用户9', '2021-04-04 22:05:04', '2021-04-04 22:04:44', 1, 1);
INSERT INTO `bms_auth_user` VALUES (12, 'user10', '$2a$10$E0A60hzJ.yBHJhyZ970Oze205OGuu4LIrjDSPQvcGBDl40O0oaiqC', 'https://www.52bess.com/uploads/avatar.png', 'user10@qq.com', '120', '普通用户10', '普通用户10', '2021-04-04 22:05:06', '2021-04-04 22:04:47', 1, 1);

-- ----------------------------
-- Table structure for bms_auth_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `bms_auth_user_role_relation`;
CREATE TABLE `bms_auth_user_role_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限管理模块用户角色关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_auth_user_role_relation
-- ----------------------------
INSERT INTO `bms_auth_user_role_relation` VALUES (1, 1, 1);
INSERT INTO `bms_auth_user_role_relation` VALUES (2, 2, 2);

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
-- Table structure for bms_update_log
-- ----------------------------
DROP TABLE IF EXISTS `bms_update_log`;
CREATE TABLE `bms_update_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` bigint(20) NULL DEFAULT NULL COMMENT '面板的name值',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本号',
  `title_icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本号图标',
  `title_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本标签类型：默认->蓝色；success->绿色；info->灰色；warning->橙色；danger->红色',
  `title_tag_info` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本标签内容',
  `title_tag` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本标识',
  `title_time` datetime NULL DEFAULT NULL COMMENT '版本更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '版本更新日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_update_log
-- ----------------------------
INSERT INTO `bms_update_log` VALUES (1, 1, 'v.0.0.1', 'el-icon-s-promotion', 'danger', 'bug修复', '测试版', '2021-04-17 21:14:03');
INSERT INTO `bms_update_log` VALUES (2, 2, 'v.0.0.2', 'el-icon-s-promotion', 'success', '新功能添加', '测试版', '2021-04-17 21:14:53');
INSERT INTO `bms_update_log` VALUES (3, 3, 'v.0.0.3', 'el-icon-s-promotion', 'success', '新功能添加', '测试版', '2021-04-17 21:15:45');

-- ----------------------------
-- Table structure for bms_update_log_detail
-- ----------------------------
DROP TABLE IF EXISTS `bms_update_log_detail`;
CREATE TABLE `bms_update_log_detail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `log_id` bigint(20) NULL DEFAULT NULL COMMENT '更新日志id',
  `body` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '版本更新日志子表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bms_update_log_detail
-- ----------------------------
INSERT INTO `bms_update_log_detail` VALUES (7, 1, '[release] 第一个测试版本发布');
INSERT INTO `bms_update_log_detail` VALUES (8, 1, '[fix] 修复了样式处理效果，提升了性能');
INSERT INTO `bms_update_log_detail` VALUES (9, 1, '[fix] 修复了部分未知bug');
INSERT INTO `bms_update_log_detail` VALUES (10, 2, '[fix] 修复了样式处理效果，提升了性能');
INSERT INTO `bms_update_log_detail` VALUES (11, 2, '[fix] 修复了部分未知bug');
INSERT INTO `bms_update_log_detail` VALUES (12, 2, '[feat] 新增Docker镜像');
INSERT INTO `bms_update_log_detail` VALUES (13, 3, '[feat] 完善了权限管理模块的功能');
INSERT INTO `bms_update_log_detail` VALUES (14, 3, '[feat] 新增版本更新日志');

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
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车模块购物车表' ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车模块购物车子表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ums_car_item
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
