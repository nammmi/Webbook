/*
Navicat MySQL Data Transfer

Source Server         : OA
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : webbooktest2

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2016-09-07 17:29:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for replynote
-- ----------------------------
DROP TABLE IF EXISTS `replynote`;
CREATE TABLE `replynote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mainnoteid` int(11) NOT NULL,
  `floorid` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `floorcontent` text,
  `createtime` datetime DEFAULT NULL,
  `quotename` varchar(255) DEFAULT NULL,
  `quotecontent` text,
  `quotefloor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mainnoteid` (`mainnoteid`),
  CONSTRAINT `mainnoteid` FOREIGN KEY (`mainnoteid`) REFERENCES `webbook` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of replynote
-- ----------------------------
INSERT INTO `replynote` VALUES ('3', '39', '1', 'lsx', '防守打法顺丰是', '2016-09-02 18:55:00', null, null, null);
INSERT INTO `replynote` VALUES ('4', '40', '1', 'lsx', ' 爱大叔大叔大叔大叔', '2016-09-02 18:55:06', null, null, null);
INSERT INTO `replynote` VALUES ('10', '45', '1', 'lsx', '好累啊\r\n啦啦啦', '2016-09-02 22:38:10', null, null, null);
INSERT INTO `replynote` VALUES ('17', '39', '2', 'zzz', '已被管理员删除', '2016-09-04 10:38:58', null, null, null);
INSERT INTO `replynote` VALUES ('21', '39', '3', 'xxx', 'xxxxxxx', '2016-09-04 10:42:41', null, null, null);
INSERT INTO `replynote` VALUES ('34', '57', '1', 'lsx', ' 烦烦烦烦烦烦烦烦烦烦烦', '2016-09-04 17:31:32', null, null, null);
INSERT INTO `replynote` VALUES ('36', '57', '2', 'zzz', 'vvvvvvvvvvvv', '2016-09-04 17:35:19', null, null, null);
INSERT INTO `replynote` VALUES ('37', '57', '3', 'lsx', '人烦烦烦方法反反复复反复反复反复', '2016-09-04 17:47:22', null, null, null);
INSERT INTO `replynote` VALUES ('38', '57', '4', 'lsx', '哈哈哈哈哈哈哈哈哈哈啊哈', '2016-09-04 17:53:00', null, null, null);
INSERT INTO `replynote` VALUES ('39', '57', '5', 'lsx', '哈哈哈哈哈哈哈哈哈啊哈', '2016-09-04 17:54:04', null, null, null);
INSERT INTO `replynote` VALUES ('40', '57', '6', 'lsx', 'fvdsafsafsafsdafsafsafds', '2016-09-04 17:55:31', null, null, null);
INSERT INTO `replynote` VALUES ('41', '57', '7', 'lsx', 'V型这次V字形从中选出走心辞职信', '2016-09-04 17:57:18', null, null, null);
INSERT INTO `replynote` VALUES ('42', '58', '1', 'lsx', '<p>国防生的公司的方式发送人防<br/></p>', '2016-09-04 21:06:35', null, null, null);
INSERT INTO `replynote` VALUES ('44', '60', '1', 'lsx', '<p><img src=\"http://img.baidu.com/hi/jx2/j_0017.gif\"/><img src=\"http://img.baidu.com/hi/jx2/j_0019.gif\"/><img src=\"http://img.baidu.com/hi/jx2/j_0026.gif\"/></p>', '2016-09-04 21:08:12', null, null, null);
INSERT INTO `replynote` VALUES ('45', '61', '1', 'lsx', '<p><span style=\"font-size: 24px;\">给他发韩国的人格的人格的人</span><br/></p>', '2016-09-04 21:17:05', null, null, null);
INSERT INTO `replynote` VALUES ('46', '61', '2', 'lsx', '<p>范德萨范德萨范德萨发啥城市的v热而王菲王菲微分而无法让我让我让我为为为为额问问额问问为我慰问慰问费为违法和氛围微分为我</p>', '2016-09-04 21:30:32', null, null, null);
INSERT INTO `replynote` VALUES ('47', '61', '3', 'lsx', '<p>达到按时发斯蒂芬收到爱死啊实打实的爱死发送安师大达到爱死发送达到安大<img src=\"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png\"/></p>', '2016-09-04 21:30:58', null, null, null);
INSERT INTO `replynote` VALUES ('48', '61', '4', 'lsx', '<blockquote><p>上次的事的撒打算的<br/></p></blockquote><p>是大大大的撒打算</p><p>的啥的as</p>', '2016-09-04 21:44:49', null, null, null);
INSERT INTO `replynote` VALUES ('49', '61', '5', 'lsx', '***已被管理员删除***', '2016-09-05 10:24:57', null, null, null);
INSERT INTO `replynote` VALUES ('50', '57', '8', 'lsx', '<p>出租车时参数</p>', '2016-09-05 11:05:18', null, null, null);
INSERT INTO `replynote` VALUES ('51', '57', '9', 'lsx', '<blockquote><b>引用1楼lsx发表的: 烦烦烦烦烦烦烦烦烦烦烦</b></blockquote><br><p>你烦我更烦</p>', '2016-09-05 11:12:31', null, null, null);
INSERT INTO `replynote` VALUES ('52', '62', '1', 'lsx', '<p>噜啦啦噜啦啦噜啦噜啦类</p>', '2016-09-05 13:06:00', null, null, null);
INSERT INTO `replynote` VALUES ('53', '63', '1', 'lsx', '<p>合肥工业大学&nbsp;</p><p>合肥工业大学</p><p>合肥工业大学</p>', '2016-09-05 16:26:14', null, null, null);
INSERT INTO `replynote` VALUES ('54', '57', '10', 'lsx', '<p>fdsfsdfsfdsfsfsdf</p>', '2016-09-05 17:16:45', null, null, null);
INSERT INTO `replynote` VALUES ('55', '57', '11', 'lsx', '<p>fdsfsdfsfsdf</p>', '2016-09-05 17:17:10', null, null, null);
INSERT INTO `replynote` VALUES ('56', '64', '1', 'lsx', '<p>恶哈哈哈哈哈哈啊哈哈</p>', '2016-09-05 17:21:41', null, null, null);
INSERT INTO `replynote` VALUES ('57', '64', '2', 'lsx', '<blockquote><b>引用1楼lsx发表的:<p>恶哈哈哈哈哈哈啊哈哈</p></b></blockquote><br><p>和谐</p>', '2016-09-05 17:22:36', null, null, null);
INSERT INTO `replynote` VALUES ('58', '64', '3', 'lsx', '<blockquote><b>引用2楼lsx发表的:<blockquote><b>引用1楼lsx发表的:<p>恶哈哈哈哈哈哈啊哈哈</p></b></blockquote><br><p>和谐</p></b></blockquote><br><p>试试看试试看~~~</p>', '2016-09-05 17:29:14', null, null, null);
INSERT INTO `replynote` VALUES ('59', '64', '4', 'lsx', '<blockquote><b>引用3楼lsx发表的:<blockquote><b>引用2楼lsx发表的:<blockquote><b>引用1楼lsx发表的:<p>恶哈哈哈哈哈哈啊哈哈</p></b></blockquote><br><p>和谐</p></b></blockquote><br><p>试试看试试看~~~</p></b></blockquote><br><p>到底能叠多少层呢？？？</p>', '2016-09-05 17:29:47', null, null, null);
INSERT INTO `replynote` VALUES ('60', '65', '1', 'lsx', '<p>模糊查询已完成~~</p>', '2016-09-05 21:17:08', null, null, null);
INSERT INTO `replynote` VALUES ('61', '64', '5', 'lsx', '<p><img src=\"/Webbook/WebRoot/ueditor/dialogs/emotion/images/jx2/j_0028.gif\"/></p>', '2016-09-05 21:28:12', null, null, null);
INSERT INTO `replynote` VALUES ('62', '64', '6', 'lsx', '<p>范德萨发斯蒂芬</p>', '2016-09-06 17:13:07', null, null, null);
INSERT INTO `replynote` VALUES ('63', '64', '7', 'lsx', '<blockquote><b>引用5楼lsx发表的:<p><img src=\"/Webbook/WebRoot/ueditor/dialogs/emotion/images/jx2/j_0028.gif\"/></p></b></blockquote><br><p><img src=\"/Webbook/WebRoot/ueditor/dialogs/emotion/images/jx2/j_0002.gif\"/></p>', '2016-09-06 17:13:25', null, null, null);
INSERT INTO `replynote` VALUES ('64', '57', '12', 'lsx', '<blockquote><b>引用11楼lsx发表的:<p>fdsfsdfsfsdf</p></b></blockquote><br><p>lllllllllll</p>', '2016-09-06 21:59:46', null, null, null);
INSERT INTO `replynote` VALUES ('65', '57', '13', 'lsx', '<p>pppppppppppppp</p>', '2016-09-06 22:00:08', null, null, null);
INSERT INTO `replynote` VALUES ('66', '57', '14', 'lsx', '<p>mmmmmmmmmmmmm</p>', '2016-09-06 22:00:21', null, null, null);
INSERT INTO `replynote` VALUES ('67', '66', '1', 'lsx', '<p>ok测试通过</p><p><br/></p>', '2016-09-06 22:00:42', null, null, null);
INSERT INTO `replynote` VALUES ('68', '66', '2', 'lsx', '<blockquote><b>引用1楼lsx发表的:<p>ok测试通过</p><p><br/></p></b></blockquote><br><p>恶哈哈哈哈哈哈哈</p>', '2016-09-06 22:08:46', null, null, null);
INSERT INTO `replynote` VALUES ('69', '66', '3', 'lsx', '<p>噜啦啦噜啦啦噜啦噜啦类</p><p><br/></p>', '2016-09-06 22:10:28', null, null, null);
INSERT INTO `replynote` VALUES ('70', '66', '4', 'lsx', '<blockquote><b>引用1楼lsx发表的:<p>ok测试通过</p><p><br/></p></b></blockquote><br><p>再试试~~~</p>', '2016-09-06 22:13:41', null, null, null);
INSERT INTO `replynote` VALUES ('71', '67', '1', 'zzz', '<p>是谁？？？？？？？？？？</p>', '2016-09-07 11:35:12', null, null, null);
INSERT INTO `replynote` VALUES ('74', '69', '1', 'zzz', '<p>恶哈哈哈</p>', '2016-09-07 16:25:50', null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zzz', 'zzz', 'zzz', '2016-09-06 17:27:29', '有效', '管理员');
INSERT INTO `user` VALUES ('2', '李九四日鑫', 'jayzkhgg', '', '2016-09-07 12:13:04', '有效', '普通');
INSERT INTO `user` VALUES ('3', 'vv', 'vv', 'vv', '2016-09-07 14:01:32', '有效', '普通');

-- ----------------------------
-- Table structure for webbook
-- ----------------------------
DROP TABLE IF EXISTS `webbook`;
CREATE TABLE `webbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mainnoteid` int(11) DEFAULT NULL,
  `mainnotetype` varchar(255) DEFAULT NULL,
  `mainnotetitle` varchar(255) DEFAULT NULL,
  `floorid` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `floorcontent` text,
  `createtime` datetime DEFAULT NULL,
  `quotecount` int(11) DEFAULT '1',
  `viewcount` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of webbook
-- ----------------------------
INSERT INTO `webbook` VALUES ('39', '10000', 'question', '大事发生', '1', 'lsx', '防守打法顺丰是', '2016-09-02 18:55:00', '3', '11');
INSERT INTO `webbook` VALUES ('40', '10000', 'question', '发爽肤水的方式的范德萨', '1', 'lsx', ' 爱大叔大叔大叔大叔', '2016-09-02 18:55:06', '1', '3');
INSERT INTO `webbook` VALUES ('45', '10000', 'question', '好累啊\r\n啦啦啦', '1', 'lsx', '好累啊\r\n啦啦啦', '2016-09-02 22:38:10', '1', '6');
INSERT INTO `webbook` VALUES ('57', '10000', 'question', '轻轻去去去去去去去去去去去去', '1', 'lsx', ' 烦烦烦烦烦烦烦烦烦烦烦', '2016-09-04 17:31:32', '14', '36');
INSERT INTO `webbook` VALUES ('58', '10000', 'question', '转载自重中之重', '1', 'lsx', '<p>国防生的公司的方式发送人防<br/></p>', '2016-09-04 21:06:35', '1', '2');
INSERT INTO `webbook` VALUES ('60', '10000', 'question', '啦啦啦啦', '1', 'lsx', '<p><img src=\"http://img.baidu.com/hi/jx2/j_0017.gif\"/><img src=\"http://img.baidu.com/hi/jx2/j_0019.gif\"/><img src=\"http://img.baidu.com/hi/jx2/j_0026.gif\"/></p>', '2016-09-04 21:08:12', '1', '4');
INSERT INTO `webbook` VALUES ('61', '10000', 'question', '范德萨发斯蒂芬', '1', 'lsx', '<p><span style=\"font-size: 24px;\">给他发韩国的人格的人格的人</span><br/></p>', '2016-09-04 21:17:05', '5', '17');
INSERT INTO `webbook` VALUES ('62', '10000', 'discuss', '试试看啊', '1', 'lsx', '<p>噜啦啦噜啦啦噜啦噜啦类</p>', '2016-09-05 13:06:00', '1', '3');
INSERT INTO `webbook` VALUES ('63', '10000', 'share', '合肥工业大学宣城校区', '1', 'lsx', '<p>合肥工业大学&nbsp;</p><p>合肥工业大学</p><p>合肥工业大学</p>', '2016-09-05 16:26:14', '1', '14');
INSERT INTO `webbook` VALUES ('64', '10000', 'discuss', '回复次数弄好了', '1', 'lsx', '<p>恶哈哈哈哈哈哈啊哈哈</p>', '2016-09-05 17:21:41', '7', '36');
INSERT INTO `webbook` VALUES ('65', '10000', 'share', '完成了模糊查询', '1', 'lsx', '<p>模糊查询已完成~~</p>', '2016-09-05 21:17:08', '1', '3');
INSERT INTO `webbook` VALUES ('66', '10000', 'question', '登录session', '1', 'lsx', '<p>ok测试通过</p><p><br/></p>', '2016-09-06 22:00:42', '4', '20');
INSERT INTO `webbook` VALUES ('67', '10000', 'question', '谁发的帖子？', '1', 'zzz', '<p>是谁？？？？？？？？？？</p>', '2016-09-07 11:35:12', '1', '2');
INSERT INTO `webbook` VALUES ('69', '10000', 'question', '谁来发个种子啊？', '1', 'zzz', '<p>恶哈哈哈</p>', '2016-09-07 16:25:50', '1', '1');

-- ----------------------------
-- View structure for listofnotes
-- ----------------------------
DROP VIEW IF EXISTS `listofnotes`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listofnotes` AS select `replynote`.`mainnoteid` AS `mainnoteid`,`webbook`.`mainnotetype` AS `mainnotetype`,`webbook`.`mainnotetitle` AS `mainnotetitle`,`webbook`.`username` AS `username`,`webbook`.`createtime` AS `createtime`,`webbook`.`quotecount` AS `quotecount`,`webbook`.`viewcount` AS `viewcount`,`replynote`.`username` AS `replynotename`,`replynote`.`createtime` AS `maxcreatetime` from (`webbook` join `replynote`) where ((`webbook`.`id` = `replynote`.`mainnoteid`) and `replynote`.`createtime` in (select max(`replynote`.`createtime`) from `replynote` group by `replynote`.`mainnoteid`)) order by `replynote`.`createtime` desc ;

-- ----------------------------
-- View structure for listofnotestest
-- ----------------------------
DROP VIEW IF EXISTS `listofnotestest`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listofnotestest` AS select `replynote`.`mainnoteid` AS `mainnoteid`,`webbook`.`mainnotetype` AS `mainnotetype`,`webbook`.`mainnotetitle` AS `mainnotetitle`,`webbook`.`username` AS `username`,`webbook`.`createtime` AS `createtime`,`webbook`.`quotecount` AS `quotecount`,`webbook`.`viewcount` AS `viewcount`,`replynote`.`username` AS `replynotename`,`replynote`.`createtime` AS `maxcreatetime` from (`webbook` join `replynote`) where ((`webbook`.`id` = `replynote`.`mainnoteid`) and `replynote`.`createtime` in (select max(`replynote`.`createtime`) from `replynote` group by `replynote`.`mainnoteid`)) order by `replynote`.`createtime` desc ;

-- ----------------------------
-- View structure for listofnotestest4
-- ----------------------------
DROP VIEW IF EXISTS `listofnotestest4`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listofnotestest4` AS select `replynote`.`mainnoteid` AS `mainnoteid`,`webbook`.`mainnotetype` AS `mainnotetype`,`webbook`.`mainnotetitle` AS `mainnotetitle`,`webbook`.`username` AS `username`,`webbook`.`createtime` AS `createtime`,`webbook`.`quotecount` AS `quotecount`,`webbook`.`viewcount` AS `viewcount`,`replynote`.`username` AS `replynotename`,`replynote`.`createtime` AS `maxcreatetime` from (`webbook` join `replynote`) where ((`webbook`.`id` = `replynote`.`mainnoteid`) and `replynote`.`createtime` in (select max(`replynote`.`createtime`) from `replynote` group by `replynote`.`mainnoteid`)) order by `replynote`.`createtime` desc ;
DROP TRIGGER IF EXISTS `t_afterinsert_on_replynote`;
DELIMITER ;;
CREATE TRIGGER `t_afterinsert_on_replynote` AFTER INSERT ON `replynote` FOR EACH ROW begin
if new.floorid>1 then
update webbook set quotecount = quotecount+1 
where webbook.id = new.mainnoteid ;
end if;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `t_afterinsert_on_webbook`;
DELIMITER ;;
CREATE TRIGGER `t_afterinsert_on_webbook` AFTER INSERT ON `webbook` FOR EACH ROW BEGIN
INSERT INTO replynote(mainnoteid, floorid, username, floorcontent, createtime) VALUES (new.id, new.floorid, new.username, new.floorcontent, new.createtime);
END
;;
DELIMITER ;
