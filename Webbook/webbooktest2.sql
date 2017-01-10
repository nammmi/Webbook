/*
Navicat MySQL Data Transfer

Source Server         : test1
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : webbooktest2

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-08-27 22:28:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for webbook
-- ----------------------------
DROP TABLE IF EXISTS `webbook`;
CREATE TABLE `webbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mainnoteid` int(11) DEFAULT NULL,
  `mainnotetype` varchar(255) DEFAULT NULL,
  `mainnotetitle` varchar(255) DEFAULT NULL,
  `floorid` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `floorcontent` text,
  `createtime` datetime DEFAULT NULL,
  `quotename` varchar(255) DEFAULT NULL,
  `quotecontent` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of webbook
-- ----------------------------
INSERT INTO `webbook` VALUES ('3', '10000', 'question', 'abc', '1', 'lsx', 'abc', '2016-08-26 21:26:37', null, null);
