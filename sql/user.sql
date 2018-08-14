/*
Navicat MySQL Data Transfer

Source Server         : my-localhs_mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : testdb

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-08-14 17:26:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1' COMMENT '可用状态：1可用，0不可用',
  `locked` bit(1) DEFAULT b'1' COMMENT '锁定状态：1未锁定，0已锁定',
  `birthday` date DEFAULT NULL,
  `createrTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '$2a$10$WWZmxw4cJFe3P8oFpG2lJORSLlXEawA6Pru0xKu3RxJrTQ5nyetlm', '', '', '2018-04-27', '2018-04-27 11:41:40');
INSERT INTO `user` VALUES ('2', '李四', '$2a$10$WWZmxw4cJFe3P8oFpG2lJORSLlXEawA6Pru0xKu3RxJrTQ5nyetlm', '', '', '2018-04-28', '2018-04-26 11:42:39');
INSERT INTO `user` VALUES ('3', '王五', '$2a$10$WWZmxw4cJFe3P8oFpG2lJORSLlXEawA6Pru0xKu3RxJrTQ5nyetlm', '', '', '2018-04-29', '2018-08-14 12:23:54');
INSERT INTO `user` VALUES ('4', 'admin', '$2a$10$WWZmxw4cJFe3P8oFpG2lJORSLlXEawA6Pru0xKu3RxJrTQ5nyetlm', '', '', '2018-08-14', '2018-08-14 16:10:50');
INSERT INTO `user` VALUES ('5', 'root', '$2a$10$qEoemt4o6Q9CzOl1TO/0auY41SAGJIrO/WcGajp3hMjgepSStiER2', '', '', '2018-08-14', '2018-08-14 08:15:39');
INSERT INTO `user` VALUES ('6', 'root1', '$2a$10$rijdgkXI0euLdrJDqQrFPuKnIx44TUekoiR73imFCyGYmG00Jw75K', '', '', '2018-08-14', '2018-08-14 08:15:41');
INSERT INTO `user` VALUES ('7', 'superadmin', '$2a$10$RtDhnwSq62kGTAM00/TUve.WOkAzxZDP0zBJsaBi50uw96WtqLEbC', '', '', '2018-08-14', '2018-08-14 08:50:10');
INSERT INTO `user` VALUES ('8', '杨涛', '$2a$10$fiO7bo0/IVBnOrSUxmVtcONEfY0Z4BlXXUK5R0zRxN8bmQe15/3hq', '', '', '2018-08-14', '2018-08-14 08:53:51');
INSERT INTO `user` VALUES ('9', '高杰', '$2a$10$XjS1ZELlQGKTt01Yw0f1su3CEFdOFqLGRLC6RQhV1RfOj5jj4KQCC', '', '', '2018-08-14', '2018-08-14 08:57:07');
INSERT INTO `user` VALUES ('10', 'TT', '$2a$10$/e9wDACI604OwPOs8tYSmOaRRXszHQa3Z80sY61S6zoCGqNZK61ti', '', '', '2018-08-12', '2018-08-14 09:22:05');
