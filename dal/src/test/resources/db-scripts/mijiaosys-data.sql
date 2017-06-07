/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mijiaosys

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-07 17:48:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for control_file_relation
-- ----------------------------
DROP TABLE IF EXISTS `control_file_relation`;
CREATE TABLE `control_file_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `file_id` bigint(20) unsigned NOT NULL COMMENT '文件主键',
  `control_id` bigint(20) unsigned NOT NULL COMMENT '权限主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-有效 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限文件关系表';

-- ----------------------------
-- Records of control_file_relation
-- ----------------------------

-- ----------------------------
-- Table structure for menu_control_relation
-- ----------------------------
DROP TABLE IF EXISTS `menu_control_relation`;
CREATE TABLE `menu_control_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) unsigned NOT NULL COMMENT '菜单主键',
  `control_id` bigint(20) unsigned NOT NULL COMMENT '操作主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-有效 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单操作关系表';

-- ----------------------------
-- Records of menu_control_relation
-- ----------------------------

-- ----------------------------
-- Table structure for res_control
-- ----------------------------
DROP TABLE IF EXISTS `res_control`;
CREATE TABLE `res_control` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `control_name` varchar(64) NOT NULL COMMENT '操作名称',
  `control_icon` varchar(32) DEFAULT NULL COMMENT '操作图标',
  `control_url` varchar(128) NOT NULL COMMENT '拦截URL前缀',
  `control_order` int(10) NOT NULL COMMENT '菜单排序',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-有效 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='资源操作表';

-- ----------------------------
-- Records of res_control
-- ----------------------------
INSERT INTO `res_control` VALUES ('1', '首页', 'index', '/index', '1', '2017-06-07 16:10:50', '2017-06-07 16:10:53', 'dawn', 'dawn', '0');
INSERT INTO `res_control` VALUES ('2', '用户列表', 'sys', '/sys/**', '2', '2017-06-07 16:11:34', '2017-06-07 16:11:38', 'dawn', 'dawn', '0');

-- ----------------------------
-- Table structure for role_control_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_control_relation`;
CREATE TABLE `role_control_relation` (
  `id` bigint(20) unsigned NOT NULL,
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色主键',
  `control_id` bigint(20) unsigned NOT NULL COMMENT '权限URL',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-有效 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关系表';

-- ----------------------------
-- Records of role_control_relation
-- ----------------------------
INSERT INTO `role_control_relation` VALUES ('1', '1', '1', '2017-06-07 16:10:09', '2017-06-07 16:10:13', 'dawn', 'dawn', '0');
INSERT INTO `role_control_relation` VALUES ('2', '2', '1', '2017-06-07 16:11:57', '2017-06-07 16:12:00', 'dawn', 'dawn', '0');
INSERT INTO `role_control_relation` VALUES ('3', '1', '2', '2017-06-07 17:35:12', '2017-06-07 17:35:18', 'dawn', 'dawn', '0');

-- ----------------------------
-- Table structure for role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_relation`;
CREATE TABLE `role_menu_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) unsigned NOT NULL COMMENT '菜单主键',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-有效 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源关系表';

-- ----------------------------
-- Records of role_menu_relation
-- ----------------------------

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `file_name` varchar(64) DEFAULT NULL COMMENT '文件名称',
  `file_suffix` varchar(16) DEFAULT NULL COMMENT '文件后缀',
  `file_size` varchar(32) DEFAULT NULL COMMENT '文件大小',
  `file_path` varchar(128) DEFAULT NULL COMMENT '文件路径',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建人',
  `modifier` varchar(32) DEFAULT NULL COMMENT '修改人',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '0-有效 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件表';

-- ----------------------------
-- Records of sys_file
-- ----------------------------

-- ----------------------------
-- Table structure for sys_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_info`;
CREATE TABLE `sys_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cn_name` varchar(64) NOT NULL COMMENT '系统中文名称',
  `en_name` varchar(128) DEFAULT NULL COMMENT '系统英文名称',
  `secret_key` varchar(32) NOT NULL COMMENT '系统秘钥',
  `sys_status` tinyint(1) NOT NULL COMMENT '系统状态 1-正常 0-锁定',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-有效 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统信息表';

-- ----------------------------
-- Records of sys_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(64) NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(128) NOT NULL COMMENT '菜单URL',
  `menu_icon` varchar(32) NOT NULL COMMENT '菜单图标',
  `parent_id` bigint(20) unsigned NOT NULL COMMENT '父菜单ID',
  `menu_order` int(10) NOT NULL COMMENT '菜单排序',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-有效 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) NOT NULL COMMENT '角色名称',
  `role_abstract` varchar(128) DEFAULT NULL COMMENT '角色描述',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-有效 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ADMIN', 'ADMIN', '2017-06-07 16:07:36', '2017-06-07 16:07:39', 'dawn', 'dawn', '0');
INSERT INTO `sys_role` VALUES ('2', 'USER', 'USER', '2017-06-07 16:07:58', '2017-06-07 16:08:01', 'dawn', 'dawn', '0');

-- ----------------------------
-- Table structure for sys_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_relation`;
CREATE TABLE `sys_role_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sys_id` bigint(20) unsigned NOT NULL COMMENT '系统主键',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-有效 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色关系表';

-- ----------------------------
-- Records of sys_role_relation
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `phone_number` varchar(16) NOT NULL COMMENT '手机号码',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  `avatar` varchar(32) DEFAULT NULL COMMENT '头像',
  `nickname` varchar(32) DEFAULT NULL COMMENT '昵称',
  `qr_code` varchar(32) NOT NULL COMMENT '二维码名片',
  `sex` tinyint(1) DEFAULT NULL COMMENT '0-女 1-男',
  `birthday` varchar(9) DEFAULT NULL COMMENT '生日',
  `user_status` tinyint(1) NOT NULL COMMENT '用户状态 1-正常 0-锁定',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-有效 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '21232F297A57A5A743894A0E4A801FC3', '1', '1', '1', 'dawn', '1', '1', null, '0', '2017-06-02 15:06:45', '2017-06-02 15:06:49', 'scg', 'scg', '0');
INSERT INTO `sys_user` VALUES ('2', 'user', '21232F297A57A5A743894A0E4A801FC3', '1222', '1', '1', 'user', '1', '1', null, '0', '2017-06-07 16:08:50', '2017-06-07 16:08:56', 'dawn', 'dawn', '0');

-- ----------------------------
-- Table structure for user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_role_relation`;
CREATE TABLE `user_role_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户主键',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-有效 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of user_role_relation
-- ----------------------------
INSERT INTO `user_role_relation` VALUES ('1', '1', '1', '2017-06-07 16:12:36', '2017-06-07 16:12:38', 'dawn', 'dawn', '0');
INSERT INTO `user_role_relation` VALUES ('2', '2', '2', '2017-06-07 16:12:49', '2017-06-07 16:12:52', 'dawn', 'dawn', '0');

-- ----------------------------
-- Table structure for user_sys_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_sys_relation`;
CREATE TABLE `user_sys_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户主键',
  `sys_id` bigint(20) unsigned NOT NULL COMMENT '系统主键',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `creator` varchar(32) NOT NULL COMMENT '创建人',
  `modifier` varchar(32) NOT NULL COMMENT '修改人',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-有效 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户系统关系表';

-- ----------------------------
-- Records of user_sys_relation
-- ----------------------------
