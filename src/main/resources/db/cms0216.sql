/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : cms

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-02-16 17:48:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `interests` tinyblob,
  `isbn` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `book_child_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq3gct1t7bhrrxjiro7vj0wfve` (`book_child_id`),
  CONSTRAINT `FKq3gct1t7bhrrxjiro7vj0wfve` FOREIGN KEY (`book_child_id`) REFERENCES `book_child` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('3', null, '3', 'c', null);
INSERT INTO `book` VALUES ('4', null, '4', 'd', null);
INSERT INTO `book` VALUES ('5', null, '5', 'e', null);

-- ----------------------------
-- Table structure for `book_child`
-- ----------------------------
DROP TABLE IF EXISTS `book_child`;
CREATE TABLE `book_child` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_child
-- ----------------------------
INSERT INTO `book_child` VALUES ('1', '123', '0');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) NOT NULL,
  `pid` smallint(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '国内新闻', '0');
INSERT INTO `category` VALUES ('2', '国际新闻', '0');
INSERT INTO `category` VALUES ('3', '社会新闻', '0');
INSERT INTO `category` VALUES ('4', '内地新闻', '1');
INSERT INTO `category` VALUES ('5', '港澳台新闻', '1');
INSERT INTO `category` VALUES ('6', '综述分析', '1');
INSERT INTO `category` VALUES ('7', '环球视野', '2');
INSERT INTO `category` VALUES ('8', '环球趣闻', '2');
INSERT INTO `category` VALUES ('9', '海外观察', '2');
INSERT INTO `category` VALUES ('10', '情感八卦', '3');
INSERT INTO `category` VALUES ('11', '拍案说法', '3');
INSERT INTO `category` VALUES ('12', '奇闻趣事', '3');
INSERT INTO `category` VALUES ('13', '拍案而起', '1');
INSERT INTO `category` VALUES ('14', '累觉不爱', '3');
INSERT INTO `category` VALUES ('15', '奥马巴的狗', '2');

-- ----------------------------
-- Table structure for `media`
-- ----------------------------
DROP TABLE IF EXISTS `media`;
CREATE TABLE `media` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `mname` varchar(30) NOT NULL,
  `siteurl` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of media
-- ----------------------------
INSERT INTO `media` VALUES ('1', '中国政府网', 'http://www.gov.cn/');
INSERT INTO `media` VALUES ('2', '中国网', 'http://www.china.com.cn');
INSERT INTO `media` VALUES ('3', '人民网', 'http://www.people.com.cn/');
INSERT INTO `media` VALUES ('4', '新华网', 'http://www.xinhuanet.com');
INSERT INTO `media` VALUES ('5', '中新网', 'http://www.chinanews.com/');
INSERT INTO `media` VALUES ('6', '央视网', 'http://www.cctv.com/default.shtml');
INSERT INTO `media` VALUES ('7', '123', '345');
INSERT INTO `media` VALUES ('8', '测试1', '123');
INSERT INTO `media` VALUES ('9', '测试3', '333');
INSERT INTO `media` VALUES ('10', '天V', '2');
INSERT INTO `media` VALUES ('11', 'ss', 'sss');
INSERT INTO `media` VALUES ('12', 'ss', 'sss');
INSERT INTO `media` VALUES ('13', 'ss', 'ff');
INSERT INTO `media` VALUES ('14', 'ssff', 'fff');
INSERT INTO `media` VALUES ('15', 'ff', 'fdd');
INSERT INTO `media` VALUES ('16', 'ss', 'ff');
INSERT INTO `media` VALUES ('17', 'ss', 'ff');
INSERT INTO `media` VALUES ('18', 'ssssss', 'fffff');
INSERT INTO `media` VALUES ('19', 'ffffffa', '221231231');
INSERT INTO `media` VALUES ('20', '234', '423');
INSERT INTO `media` VALUES ('21', 'ttt', 'sss');
INSERT INTO `media` VALUES ('22', 'ttt', 'sss');
INSERT INTO `media` VALUES ('23', 'ttt', 'sss');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `subject` varchar(80) NOT NULL,
  `content` mediumtext NOT NULL,
  `cid` smallint(5) unsigned NOT NULL,
  `mid` smallint(5) unsigned NOT NULL,
  `pubtime` int(10) unsigned NOT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=613 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('611', '测试1', '<p>测试1<br/></p>', '1', '1', '1480988252', '0');
INSERT INTO `news` VALUES ('612', '测试2', '<p>测而生2<br/></p>', '1', '1', '1480988472', '0');

-- ----------------------------
-- Table structure for `season`
-- ----------------------------
DROP TABLE IF EXISTS `season`;
CREATE TABLE `season` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cell101` varchar(255) DEFAULT NULL,
  `cell102` varchar(255) DEFAULT NULL,
  `cell103` varchar(255) DEFAULT NULL,
  `cell104` varchar(255) DEFAULT NULL,
  `cell105` varchar(255) DEFAULT NULL,
  `cell11` varchar(255) DEFAULT NULL,
  `cell111` varchar(255) DEFAULT NULL,
  `cell112` varchar(255) DEFAULT NULL,
  `cell113` varchar(255) DEFAULT NULL,
  `cell114` varchar(255) DEFAULT NULL,
  `cell12` varchar(255) DEFAULT NULL,
  `cell121` varchar(255) DEFAULT NULL,
  `cell13` varchar(255) DEFAULT NULL,
  `cell131` varchar(255) DEFAULT NULL,
  `cell14` varchar(255) DEFAULT NULL,
  `cell141` varchar(255) DEFAULT NULL,
  `cell142` varchar(255) DEFAULT NULL,
  `cell15` varchar(255) DEFAULT NULL,
  `cell151` varchar(255) DEFAULT NULL,
  `cell152` varchar(255) DEFAULT NULL,
  `cell161` varchar(255) DEFAULT NULL,
  `cell162` varchar(255) DEFAULT NULL,
  `cell163` varchar(255) DEFAULT NULL,
  `cell164` varchar(255) DEFAULT NULL,
  `cell165` varchar(255) DEFAULT NULL,
  `cell21` varchar(255) DEFAULT NULL,
  `cell22` varchar(255) DEFAULT NULL,
  `cell23` varchar(255) DEFAULT NULL,
  `cell24` varchar(255) DEFAULT NULL,
  `cell25` varchar(255) DEFAULT NULL,
  `cell31` varchar(255) DEFAULT NULL,
  `cell32` varchar(255) DEFAULT NULL,
  `cell33` varchar(255) DEFAULT NULL,
  `cell34` varchar(255) DEFAULT NULL,
  `cell35` varchar(255) DEFAULT NULL,
  `cell41` varchar(255) DEFAULT NULL,
  `cell42` varchar(255) DEFAULT NULL,
  `cell43` varchar(255) DEFAULT NULL,
  `cell44` varchar(255) DEFAULT NULL,
  `cell45` varchar(255) DEFAULT NULL,
  `cell51` varchar(255) DEFAULT NULL,
  `cell52` varchar(255) DEFAULT NULL,
  `cell53` varchar(255) DEFAULT NULL,
  `cell54` varchar(255) DEFAULT NULL,
  `cell55` varchar(255) DEFAULT NULL,
  `cell61` varchar(255) DEFAULT NULL,
  `cell62` varchar(255) DEFAULT NULL,
  `cell63` varchar(255) DEFAULT NULL,
  `cell64` varchar(255) DEFAULT NULL,
  `cell65` varchar(255) DEFAULT NULL,
  `cell71` varchar(255) DEFAULT NULL,
  `cell72` varchar(255) DEFAULT NULL,
  `cell73` varchar(255) DEFAULT NULL,
  `cell74` varchar(255) DEFAULT NULL,
  `cell75` varchar(255) DEFAULT NULL,
  `cell81` varchar(255) DEFAULT NULL,
  `cell82` varchar(255) DEFAULT NULL,
  `cell83` varchar(255) DEFAULT NULL,
  `cell84` varchar(255) DEFAULT NULL,
  `cell85` varchar(255) DEFAULT NULL,
  `cell91` varchar(255) DEFAULT NULL,
  `cell92` varchar(255) DEFAULT NULL,
  `cell93` varchar(255) DEFAULT NULL,
  `cell94` varchar(255) DEFAULT NULL,
  `cell95` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `mobile_radio` varchar(255) DEFAULT NULL,
  `o2o_radio` varchar(255) DEFAULT NULL,
  `season` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `city_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of season
-- ----------------------------
INSERT INTO `season` VALUES ('1', '', '1', '1', '1', '1', '', '1', '1', '1', '1', '4', '1', '4', '1', '4', '1', '1', '4', '1', '1', '1', '1', '1', '1', '2017-02-15', '', '2', '2', '2', '2', '', '2', '2', '2', '2', '', '2', '2', '2', '2', '', '1', '1', '1', '1', '', '1', '1', '1', '1', '', '2', '2', '2', '2', '', '2', '2', '2', '2', '', '1', '1', '1', '1', '沈阳1', '1', '1', '4', '2017', '2', '1', '2');

-- ----------------------------
-- Table structure for `season_message`
-- ----------------------------
DROP TABLE IF EXISTS `season_message`;
CREATE TABLE `season_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cell111` varchar(50) NOT NULL,
  `cell112` varchar(50) NOT NULL,
  `cell113` varchar(50) NOT NULL,
  `cell114` varchar(50) NOT NULL,
  `o2oRadio` varchar(10) NOT NULL,
  `cell121` varchar(50) DEFAULT NULL,
  `mobileRadio` varchar(10) NOT NULL,
  `cell131` varchar(50) DEFAULT NULL,
  `cell141` varchar(50) NOT NULL,
  `cell142` varchar(50) NOT NULL,
  `cell151` varchar(50) DEFAULT NULL,
  `cell152` varchar(50) DEFAULT NULL,
  `cell161` varchar(50) NOT NULL,
  `cell162` varchar(50) NOT NULL,
  `cell163` varchar(50) NOT NULL,
  `cell164` varchar(50) NOT NULL,
  `cell165` varchar(50) NOT NULL,
  `companyName` varchar(50) NOT NULL,
  `year` varchar(10) NOT NULL,
  `season` varchar(10) NOT NULL,
  `userid` varchar(50) NOT NULL,
  `report` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of season_message
-- ----------------------------
INSERT INTO `season_message` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2016-12-08', '', '2016', '4', '2', '1');
INSERT INTO `season_message` VALUES ('2', '1', '1', '3', '3', '2', '4', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '2016-07-08', '爱狄特', '2016', '3', '2', '4');
INSERT INTO `season_message` VALUES ('3', '9', '9', '9', '9', '2', null, '1', '9', '9', '9', '9', '9', '9', '9', '9', '9', '2015-04-24', '中国邮政222', '2015', '2', '2', '6');
INSERT INTO `season_message` VALUES ('4', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2016-01-05', '1', '2016', '1', '2', '2');
INSERT INTO `season_message` VALUES ('5', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2016-04-05', '1', '2016', '2', '2', '3');
INSERT INTO `season_message` VALUES ('6', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2015-01-01', '1', '2015', '1', '2', '5');
INSERT INTO `season_message` VALUES ('7', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2015-07-01', '1', '2015', '3', '2', '7');
INSERT INTO `season_message` VALUES ('8', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2015-09-01', '1', '2015', '4', '2', '8');
INSERT INTO `season_message` VALUES ('9', '0', '0', '0', '0', '2', '', '2', '', '0', '0', '0', '0', '0', '0', '0', '0', '2017-01-01', '沈阳2', '2014', '1', '2', '13');

-- ----------------------------
-- Table structure for `season_report`
-- ----------------------------
DROP TABLE IF EXISTS `season_report`;
CREATE TABLE `season_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cell11` varchar(50) DEFAULT NULL,
  `cell12` varchar(50) NOT NULL,
  `cell13` varchar(50) NOT NULL,
  `cell14` varchar(50) NOT NULL,
  `cell15` varchar(50) NOT NULL,
  `cell21` varchar(50) DEFAULT NULL,
  `cell22` varchar(50) NOT NULL,
  `cell23` varchar(50) NOT NULL,
  `cell24` varchar(50) NOT NULL,
  `cell25` varchar(50) NOT NULL,
  `cell31` varchar(50) DEFAULT NULL,
  `cell32` varchar(50) NOT NULL,
  `cell33` varchar(50) NOT NULL,
  `cell34` varchar(50) NOT NULL,
  `cell35` varchar(50) NOT NULL,
  `cell41` varchar(50) DEFAULT NULL,
  `cell42` varchar(50) NOT NULL,
  `cell43` varchar(50) NOT NULL,
  `cell44` varchar(50) NOT NULL,
  `cell45` varchar(50) NOT NULL,
  `cell51` varchar(50) DEFAULT NULL,
  `cell52` varchar(50) NOT NULL,
  `cell53` varchar(50) NOT NULL,
  `cell54` varchar(50) NOT NULL,
  `cell55` varchar(50) NOT NULL,
  `cell61` varchar(50) DEFAULT NULL,
  `cell62` varchar(50) NOT NULL,
  `cell63` varchar(50) NOT NULL,
  `cell64` varchar(50) NOT NULL,
  `cell65` varchar(50) NOT NULL,
  `cell71` varchar(50) DEFAULT NULL,
  `cell72` varchar(50) NOT NULL,
  `cell73` varchar(50) NOT NULL,
  `cell74` varchar(50) NOT NULL,
  `cell75` varchar(50) NOT NULL,
  `cell81` varchar(50) DEFAULT NULL,
  `cell82` varchar(50) NOT NULL,
  `cell83` varchar(50) NOT NULL,
  `cell84` varchar(50) NOT NULL,
  `cell85` varchar(50) NOT NULL,
  `cell91` varchar(50) DEFAULT NULL,
  `cell92` varchar(50) NOT NULL,
  `cell93` varchar(50) NOT NULL,
  `cell94` varchar(50) NOT NULL,
  `cell95` varchar(50) NOT NULL,
  `cell101` varchar(50) DEFAULT NULL,
  `cell102` varchar(50) NOT NULL,
  `cell103` varchar(50) NOT NULL,
  `cell104` varchar(50) NOT NULL,
  `cell105` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of season_report
-- ----------------------------
INSERT INTO `season_report` VALUES ('1', '4.00000', '1.00000', '1.00000', '1.00000', '1.00000', '2.00000', '0.00000', '1.00000', '1.00000', '1.00000', '2.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000');
INSERT INTO `season_report` VALUES ('2', '4.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000', '1.00000');
INSERT INTO `season_report` VALUES ('3', '8.00000', '2.00000', '2.00000', '2.00000', '2.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000', '3.00000');
INSERT INTO `season_report` VALUES ('4', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `season_report` VALUES ('5', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `season_report` VALUES ('6', '', '', '', '', '', '', '0', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `season_report` VALUES ('7', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `season_report` VALUES ('8', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `season_report` VALUES ('9', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `season_report` VALUES ('10', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `season_report` VALUES ('11', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `season_report` VALUES ('12', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `season_report` VALUES ('13', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cityid` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `permission` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `usernamecn` varchar(255) NOT NULL,
  `company_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'e10adc3949ba59abbe56e057f20f883e', '0', 'admin', '超级管理员', '超级管理员');
INSERT INTO `user` VALUES ('2', '2', 'e10adc3949ba59abbe56e057f20f883e', '1', 'shenyang', '沈阳管理员1', '沈阳管理员1');
INSERT INTO `user` VALUES ('3', '3', 'e10adc3949ba59abbe56e057f20f883e', '1', 'dalian', '大连管理员1', '大连管理员1');
INSERT INTO `user` VALUES ('4', '4', 'e10adc3949ba59abbe56e057f20f883e', '1', 'anshan', '鞍山管理员1', '鞍山管理员1');
INSERT INTO `user` VALUES ('5', '5', 'e10adc3949ba59abbe56e057f20f883e', '1', 'fushun', '抚顺管理员1', '抚顺管理员1');
INSERT INTO `user` VALUES ('6', '6', 'e10adc3949ba59abbe56e057f20f883e', '1', 'benxi', '本兮管理员1', '本兮管理员1');
INSERT INTO `user` VALUES ('7', '7', 'e10adc3949ba59abbe56e057f20f883e', '1', 'dandong', '丹东管理员1', '丹东管理员1');
INSERT INTO `user` VALUES ('8', '8', 'e10adc3949ba59abbe56e057f20f883e', '1', 'jinzhou', '锦州管理员1', '锦州管理员1');
INSERT INTO `user` VALUES ('9', '9', 'e10adc3949ba59abbe56e057f20f883e', '1', 'yingkou', '营口管理员1', '营口管理员1');
INSERT INTO `user` VALUES ('10', '10', 'e10adc3949ba59abbe56e057f20f883e', '1', 'fuxin', '阜新管理员1', '阜新管理员1');
INSERT INTO `user` VALUES ('11', '11', 'e10adc3949ba59abbe56e057f20f883e', '1', 'liaoyang', '辽阳管理员1', '辽阳管理员1');
INSERT INTO `user` VALUES ('12', '12', 'e10adc3949ba59abbe56e057f20f883e', '1', 'panjin', '盘锦管理员1', '盘锦管理员1');
INSERT INTO `user` VALUES ('13', '13', 'e10adc3949ba59abbe56e057f20f883e', '1', 'tieling', '铁岭管理员1', '铁岭管理员1');
INSERT INTO `user` VALUES ('14', '14', 'e10adc3949ba59abbe56e057f20f883e', '1', 'chaoyang', '朝阳管理员1', '朝阳管理员1');
INSERT INTO `user` VALUES ('15', '15', 'e10adc3949ba59abbe56e057f20f883e', '1', 'huludao', '葫芦岛管理员1', '葫芦岛管理员1');
INSERT INTO `user` VALUES ('16', '2', 'e10adc3949ba59abbe56e057f20f883e', '2', 'shenyang1', '张三', '沈阳企业1');
INSERT INTO `user` VALUES ('17', '3', 'e10adc3949ba59abbe56e057f20f883e', '2', 'dalian1', '李四', '大连企业1');
INSERT INTO `user` VALUES ('18', '4', 'e10adc3949ba59abbe56e057f20f883e', '2', 'anshan1', '王五', '鞍山企业1');
INSERT INTO `user` VALUES ('19', '5', 'e10adc3949ba59abbe56e057f20f883e', '2', 'fushun1', '赵六', '抚顺企业1');
INSERT INTO `user` VALUES ('20', '6', 'e10adc3949ba59abbe56e057f20f883e', '2', 'benxi', '本兮企业1', '');
INSERT INTO `user` VALUES ('21', '7', 'e10adc3949ba59abbe56e057f20f883e', '2', 'dandong', '丹东企业1', '');
INSERT INTO `user` VALUES ('22', '8', 'e10adc3949ba59abbe56e057f20f883e', '2', 'jinzhou', '锦州企业1', '');
INSERT INTO `user` VALUES ('23', '9', 'e10adc3949ba59abbe56e057f20f883e', '2', 'yingkou', '营口企业1', '');
INSERT INTO `user` VALUES ('24', '10', 'e10adc3949ba59abbe56e057f20f883e', '2', 'fuxin', '抚顺企业1', '');
INSERT INTO `user` VALUES ('25', '11', 'e10adc3949ba59abbe56e057f20f883e', '2', 'liaoyang', '辽阳企业1', '');
INSERT INTO `user` VALUES ('26', '12', 'e10adc3949ba59abbe56e057f20f883e', '2', 'panjin', '盘锦企业1', '');
INSERT INTO `user` VALUES ('27', '13', 'e10adc3949ba59abbe56e057f20f883e', '2', 'tieling', '铁岭企业1', '');
INSERT INTO `user` VALUES ('28', '14', 'e10adc3949ba59abbe56e057f20f883e', '2', 'chaoyang', '朝阳企业1', '');
INSERT INTO `user` VALUES ('29', '15', 'e10adc3949ba59abbe56e057f20f883e', '2', 'huludao', '葫芦岛企业1', '');

-- ----------------------------
-- Table structure for `year`
-- ----------------------------
DROP TABLE IF EXISTS `year`;
CREATE TABLE `year` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cell11` varchar(255) DEFAULT NULL,
  `cell21` varchar(255) DEFAULT NULL,
  `cell31` varchar(255) DEFAULT NULL,
  `cell32` varchar(255) DEFAULT NULL,
  `cell33` varchar(255) DEFAULT NULL,
  `cell34` varchar(255) DEFAULT NULL,
  `cell35` varchar(255) DEFAULT NULL,
  `cell36` varchar(255) DEFAULT NULL,
  `cell37` varchar(255) DEFAULT NULL,
  `cell38` varchar(255) DEFAULT NULL,
  `cell41` varchar(255) DEFAULT NULL,
  `cell42` varchar(255) DEFAULT NULL,
  `cell51` varchar(255) DEFAULT NULL,
  `cell52` varchar(255) DEFAULT NULL,
  `cell53` varchar(255) DEFAULT NULL,
  `cell54` varchar(255) DEFAULT NULL,
  `cell61` varchar(255) DEFAULT NULL,
  `cell62` varchar(255) DEFAULT NULL,
  `cell63` varchar(255) DEFAULT NULL,
  `cell64` varchar(255) DEFAULT NULL,
  `cell71` varchar(255) DEFAULT NULL,
  `cell72` varchar(255) DEFAULT NULL,
  `cell73` varchar(255) DEFAULT NULL,
  `cell74` varchar(255) DEFAULT NULL,
  `cell75` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `cross_country` tinyblob,
  `industry` varchar(255) DEFAULT NULL,
  `r_cell101` varchar(255) DEFAULT NULL,
  `r_cell102` varchar(255) DEFAULT NULL,
  `r_cell103` varchar(255) DEFAULT NULL,
  `r_cell104` varchar(255) DEFAULT NULL,
  `r_cell105` varchar(255) DEFAULT NULL,
  `r_cell11` varchar(255) DEFAULT NULL,
  `r_cell12` varchar(255) DEFAULT NULL,
  `r_cell13` varchar(255) DEFAULT NULL,
  `r_cell14` varchar(255) DEFAULT NULL,
  `r_cell15` varchar(255) DEFAULT NULL,
  `r_cell21` varchar(255) DEFAULT NULL,
  `r_cell22` varchar(255) DEFAULT NULL,
  `r_cell23` varchar(255) DEFAULT NULL,
  `r_cell24` varchar(255) DEFAULT NULL,
  `r_cell25` varchar(255) DEFAULT NULL,
  `r_cell31` varchar(255) DEFAULT NULL,
  `r_cell32` varchar(255) DEFAULT NULL,
  `r_cell33` varchar(255) DEFAULT NULL,
  `r_cell34` varchar(255) DEFAULT NULL,
  `r_cell35` varchar(255) DEFAULT NULL,
  `r_cell41` varchar(255) DEFAULT NULL,
  `r_cell42` varchar(255) DEFAULT NULL,
  `r_cell43` varchar(255) DEFAULT NULL,
  `r_cell44` varchar(255) DEFAULT NULL,
  `r_cell45` varchar(255) DEFAULT NULL,
  `r_cell51` varchar(255) DEFAULT NULL,
  `r_cell52` varchar(255) DEFAULT NULL,
  `r_cell53` varchar(255) DEFAULT NULL,
  `r_cell54` varchar(255) DEFAULT NULL,
  `r_cell55` varchar(255) DEFAULT NULL,
  `r_cell61` varchar(255) DEFAULT NULL,
  `r_cell62` varchar(255) DEFAULT NULL,
  `r_cell63` varchar(255) DEFAULT NULL,
  `r_cell64` varchar(255) DEFAULT NULL,
  `r_cell65` varchar(255) DEFAULT NULL,
  `r_cell71` varchar(255) DEFAULT NULL,
  `r_cell72` varchar(255) DEFAULT NULL,
  `r_cell73` varchar(255) DEFAULT NULL,
  `r_cell74` varchar(255) DEFAULT NULL,
  `r_cell75` varchar(255) DEFAULT NULL,
  `r_cell81` varchar(255) DEFAULT NULL,
  `r_cell82` varchar(255) DEFAULT NULL,
  `r_cell83` varchar(255) DEFAULT NULL,
  `r_cell84` varchar(255) DEFAULT NULL,
  `r_cell85` varchar(255) DEFAULT NULL,
  `r_cell91` varchar(255) DEFAULT NULL,
  `r_cell92` varchar(255) DEFAULT NULL,
  `r_cell93` varchar(255) DEFAULT NULL,
  `r_cell94` varchar(255) DEFAULT NULL,
  `r_cell95` varchar(255) DEFAULT NULL,
  `sale` tinyblob,
  `year` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `city_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of year
-- ----------------------------
INSERT INTO `year` VALUES ('5', '法人', '1', '1', '1', '1', '13845637896', '1', '1', '1', '1', '123', '345', '3', '1', '1', '1', '', '', '', '', '1', '1', '123-1234567', '13412345678', '2017-02-14', '沈阳', '123', 0xACED0005757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B47020000787000000001740006E587BAE58FA3, '电子商务应用企业', '', '1', '1', '1', '', '', '3', '3', '3', '', '', '2', '2', '2', '', '', '1', '1', '1', '', '', '1', '1', '1', '', '', '1', '1', '1', '', '', '1', '1', '1', '', '', '2', '2', '2', '', '', '2', '2', '2', '', '', '1', '1', '1', '', 0xACED0005757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B47020000787000000001740003423242, '2017', '2', '1', '2');
INSERT INTO `year` VALUES ('7', '法人', '1', '1', '1', '1', '13845637896', '1', '1', '1', '1', '123', '345', '3', '1', '1', '1', '', '', '', '', '1', '1', '1', '1', '2017-02-14', '沈阳', '123', 0xACED0005757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B47020000787000000001740006E8BF9BE58FA3, '电子商务应用企业', '', '1', '1', '1', '', '', '3', '3', '3', '', '', '2', '2', '2', '', '', '1', '1', '1', '', '', '1', '1', '1', '', '', '1', '1', '1', '', '', '1', '1', '1', '', '', '2', '2', '2', '', '', '2', '2', '2', '', '', '1', '1', '1', '', 0xACED0005757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B47020000787000000001740003423242, '2016', null, null, null);

-- ----------------------------
-- Table structure for `year_message`
-- ----------------------------
DROP TABLE IF EXISTS `year_message`;
CREATE TABLE `year_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cell11` varchar(50) NOT NULL,
  `cell21` varchar(50) DEFAULT NULL,
  `cell31` varchar(50) NOT NULL,
  `cell32` varchar(50) NOT NULL,
  `cell33` varchar(50) DEFAULT NULL,
  `cell34` varchar(50) NOT NULL,
  `cell35` varchar(50) NOT NULL,
  `cell36` varchar(50) DEFAULT NULL,
  `cell37` varchar(50) DEFAULT NULL,
  `cell38` varchar(50) DEFAULT NULL,
  `city` varchar(50) NOT NULL,
  `industry` varchar(100) NOT NULL,
  `sale` varchar(50) NOT NULL,
  `crossCountry` varchar(100) DEFAULT NULL,
  `cell41` varchar(50) DEFAULT NULL,
  `cell42` varchar(50) DEFAULT NULL,
  `cell51` varchar(50) NOT NULL,
  `cell52` varchar(50) NOT NULL,
  `cell53` varchar(50) NOT NULL,
  `cell54` varchar(50) NOT NULL,
  `cell61` varchar(50) NOT NULL,
  `cell62` varchar(50) NOT NULL,
  `cell63` varchar(50) NOT NULL,
  `cell64` varchar(50) NOT NULL,
  `cell71` varchar(50) NOT NULL,
  `cell72` varchar(50) NOT NULL,
  `cell73` varchar(50) NOT NULL,
  `cell74` varchar(50) NOT NULL,
  `cell75` varchar(50) NOT NULL,
  `companyName` varchar(50) NOT NULL,
  `year` varchar(50) NOT NULL,
  `userid` varchar(50) NOT NULL,
  `r_cell11` varchar(50) DEFAULT NULL,
  `r_cell12` varchar(50) DEFAULT NULL,
  `r_cell13` varchar(50) DEFAULT NULL,
  `r_cell14` varchar(50) DEFAULT NULL,
  `r_cell15` varchar(50) DEFAULT NULL,
  `r_cell21` varchar(50) DEFAULT NULL,
  `r_cell22` varchar(50) DEFAULT NULL,
  `r_cell23` varchar(50) DEFAULT NULL,
  `r_cell24` varchar(50) DEFAULT NULL,
  `r_cell25` varchar(50) DEFAULT NULL,
  `r_cell31` varchar(50) DEFAULT NULL,
  `r_cell32` varchar(50) DEFAULT NULL,
  `r_cell33` varchar(50) DEFAULT NULL,
  `r_cell34` varchar(50) DEFAULT NULL,
  `r_cell35` varchar(50) DEFAULT NULL,
  `r_cell41` varchar(50) DEFAULT NULL,
  `r_cell42` varchar(50) DEFAULT NULL,
  `r_cell43` varchar(50) DEFAULT NULL,
  `r_cell44` varchar(50) DEFAULT NULL,
  `r_cell45` varchar(50) DEFAULT NULL,
  `r_cell51` varchar(50) DEFAULT NULL,
  `r_cell52` varchar(50) DEFAULT NULL,
  `r_cell53` varchar(50) DEFAULT NULL,
  `r_cell54` varchar(50) DEFAULT NULL,
  `r_cell55` varchar(50) DEFAULT NULL,
  `r_cell61` varchar(50) DEFAULT NULL,
  `r_cell62` varchar(50) DEFAULT NULL,
  `r_cell63` varchar(50) DEFAULT NULL,
  `r_cell64` varchar(50) DEFAULT NULL,
  `r_cell65` varchar(50) DEFAULT NULL,
  `r_cell71` varchar(50) DEFAULT NULL,
  `r_cell72` varchar(50) DEFAULT NULL,
  `r_cell73` varchar(50) DEFAULT NULL,
  `r_cell74` varchar(50) DEFAULT NULL,
  `r_cell75` varchar(50) DEFAULT NULL,
  `r_cell81` varchar(50) DEFAULT NULL,
  `r_cell82` varchar(50) DEFAULT NULL,
  `r_cell83` varchar(50) DEFAULT NULL,
  `r_cell84` varchar(50) DEFAULT NULL,
  `r_cell85` varchar(50) DEFAULT NULL,
  `r_cell91` varchar(50) DEFAULT NULL,
  `r_cell92` varchar(50) DEFAULT NULL,
  `r_cell93` varchar(50) DEFAULT NULL,
  `r_cell94` varchar(50) DEFAULT NULL,
  `r_cell95` varchar(50) DEFAULT NULL,
  `r_cell101` varchar(50) DEFAULT NULL,
  `r_cell102` varchar(50) DEFAULT NULL,
  `r_cell103` varchar(50) DEFAULT NULL,
  `r_cell104` varchar(50) DEFAULT NULL,
  `r_cell105` varchar(50) DEFAULT NULL,
  `cityid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of year_message
-- ----------------------------
INSERT INTO `year_message` VALUES ('1', '11', '1', '1', '11', '1', '11', '1', '10', '1', '12', '鞍山', '电子商务综合型企业', 'B2C,C2C', '出口', '1', '1', '151', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2016-12-22', '爱狄特', '2016', '1', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `year_message` VALUES ('2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '沈阳', '', 'B2B,C2C', '', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2016-12-21', '2', '2', '1', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `year_message` VALUES ('3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '葫芦岛', '电子商务应用企业,电子商务服务企业', 'B2B,C2C', '', '33', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '2016-12-20', '3', '3', '1', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `year_message` VALUES ('4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '朝阳', '电子商务应用企业,电子商务综合型企业', 'B2B,B2C', '', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '2016-12-19', '4', '4', '1', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `year_message` VALUES ('5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '鞍山', '电子商务应用企业,电子商务服务企业', 'B2C,C2C', '进口,出口', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '2016-12-18', '5', '5', '1', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `year_message` VALUES ('6', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '大连', '电子商务应用企业,电子商务综合型企业', 'B2B,C2C', '进口', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2016-12-24', '伟业我爱我家', '2016', '2', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `year_message` VALUES ('7', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '鞍山', '电子商务应用企业,电子商务服务企业', 'B2C', '进口', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '2016-12-25', '9', '2014', '1', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `year_message` VALUES ('8', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '鞍山', '电子商务应用企业', 'B2B', '进口', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2016-12-25', '1', '2015', '14', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `year_message` VALUES ('9', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '大连', '电子商务应用企业', 'B2B', '进口', null, null, '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2016-12-26', '1', '2016', '3', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `year_message` VALUES ('10', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '鞍山', '电子商务应用企业', 'B2B', '进口', null, null, '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2016-12-26', '2', '2016', '3', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', null);
INSERT INTO `year_message` VALUES ('11', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '盘锦', '电子商务应用企业', 'B2C', '进口', null, null, '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9', '2017-01-01', '沈阳测试1', '2015', '2', '20', '5', '5', '5', '5', '10', '3', '3', '2', '2', '10', '2', '2', '3', '3', '7', '2', '2', '2', '1', '7', '2', '2', '2', '1', '6', '1', '1', '1', '3', '10', '3', '3', '2', '2', '10', '2', '2', '3', '3', '5', '1', '1', '1', '2', '5', '1', '1', '2', '1', null);
INSERT INTO `year_message` VALUES ('12', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '朝阳', '电子商务服务企业', 'B2C', '进口', null, null, '1', '1', '1', '1', '1', '1', '1', '1', '1', '11', '1', '11', '2017-01-01', '沈阳1', '2013', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `year_message` VALUES ('13', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '阜新', '电子商务服务企业', 'B2B', '进口', '', '', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '2017-01-01', '沈阳2014', '2014', '2', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', null);
