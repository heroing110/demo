/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : cms

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-03-03 13:47:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `season`
-- ----------------------------
DROP TABLE IF EXISTS `season`;
CREATE TABLE `season` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cell102` varchar(255) DEFAULT NULL,
  `cell103` varchar(255) DEFAULT NULL,
  `cell104` varchar(255) DEFAULT NULL,
  `cell105` varchar(255) DEFAULT NULL,
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
  `cell22` varchar(255) DEFAULT NULL,
  `cell23` varchar(255) DEFAULT NULL,
  `cell24` varchar(255) DEFAULT NULL,
  `cell25` varchar(255) DEFAULT NULL,
  `cell32` varchar(255) DEFAULT NULL,
  `cell33` varchar(255) DEFAULT NULL,
  `cell34` varchar(255) DEFAULT NULL,
  `cell35` varchar(255) DEFAULT NULL,
  `cell42` varchar(255) DEFAULT NULL,
  `cell43` varchar(255) DEFAULT NULL,
  `cell44` varchar(255) DEFAULT NULL,
  `cell45` varchar(255) DEFAULT NULL,
  `cell52` varchar(255) DEFAULT NULL,
  `cell53` varchar(255) DEFAULT NULL,
  `cell54` varchar(255) DEFAULT NULL,
  `cell55` varchar(255) DEFAULT NULL,
  `cell62` varchar(255) DEFAULT NULL,
  `cell63` varchar(255) DEFAULT NULL,
  `cell64` varchar(255) DEFAULT NULL,
  `cell65` varchar(255) DEFAULT NULL,
  `cell72` varchar(255) DEFAULT NULL,
  `cell73` varchar(255) DEFAULT NULL,
  `cell74` varchar(255) DEFAULT NULL,
  `cell75` varchar(255) DEFAULT NULL,
  `cell82` varchar(255) DEFAULT NULL,
  `cell83` varchar(255) DEFAULT NULL,
  `cell84` varchar(255) DEFAULT NULL,
  `cell85` varchar(255) DEFAULT NULL,
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
  `industry` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of season
-- ----------------------------
INSERT INTO `season` VALUES ('2', '1', '1', '1', '1', '1', '2', '1', '1', '1', '', '1', '', '1', '1', '1', '1', '', '', '沈阳企业1', '1', '010-1234567', '13845621321', '2016-03-01', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '沈阳企业1', '2', '2', '1', '2016', '16', '2', '2', null);
INSERT INTO `season` VALUES ('3', '1', '1', '1', '1', '1', '1', '1', '1', '1', '', '1', '', '1', '1', '1', '1', '', '', '沈阳企业1', '1', '010-1234567', '13845621321', '2016-03-01', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '沈阳企业1', '2', '2', '2', '2016', '16', '2', '2', null);
INSERT INTO `season` VALUES ('4', '1', '1', '1', '1', '1', '1', '1', '1', '1', '', '1', '', '1', '1', '1', '1', '', '', '沈阳企业1', '1', '010-1234567', '13845621321', '2016-03-01', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '沈阳企业1', '2', '2', '3', '2016', '16', '2', '2', null);
INSERT INTO `season` VALUES ('5', '1', '1', '1', '1', '1', '1', '1', '1', '1', '', '1', '', '1', '1', '1', '1', '', '', '沈阳企业1', '1', '010-1234567', '13845621321', '2016-03-01', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '沈阳企业1', '2', '2', '4', '2016', '16', '2', '2', null);
INSERT INTO `season` VALUES ('6', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '沈阳企业1', '3', '010-1234567', '13845621321', '2017-03-01', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '沈阳企业1', '2', '2', '1', '2017', '16', '2', '2', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

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
INSERT INTO `user` VALUES ('16', '2', 'e10adc3949ba59abbe56e057f20f883e', '2', 'shenyang1', '沈阳企业1', '沈阳企业1');
INSERT INTO `user` VALUES ('17', '3', 'e10adc3949ba59abbe56e057f20f883e', '2', 'dalian1', '大连企业1', '大连企业1');
INSERT INTO `user` VALUES ('18', '4', 'e10adc3949ba59abbe56e057f20f883e', '2', 'anshan1', '鞍山企业1', '鞍山企业1');
INSERT INTO `user` VALUES ('19', '5', 'e10adc3949ba59abbe56e057f20f883e', '2', 'fushun1', '抚顺企业1', '抚顺企业1');
INSERT INTO `user` VALUES ('20', '6', 'e10adc3949ba59abbe56e057f20f883e', '2', 'benxi', '本兮企业1', '本兮企业1');
INSERT INTO `user` VALUES ('21', '7', 'e10adc3949ba59abbe56e057f20f883e', '2', 'dandong', '丹东企业1', '丹东企业1');
INSERT INTO `user` VALUES ('22', '8', 'e10adc3949ba59abbe56e057f20f883e', '2', 'jinzhou', '锦州企业1', '锦州企业1');
INSERT INTO `user` VALUES ('23', '9', 'e10adc3949ba59abbe56e057f20f883e', '2', 'yingkou', '营口企业1', '营口企业1');
INSERT INTO `user` VALUES ('24', '10', 'e10adc3949ba59abbe56e057f20f883e', '2', 'fuxin', '抚顺企业1', '抚顺企业1');
INSERT INTO `user` VALUES ('25', '11', 'e10adc3949ba59abbe56e057f20f883e', '2', 'liaoyang', '辽阳企业1', '辽阳企业1');
INSERT INTO `user` VALUES ('26', '12', 'e10adc3949ba59abbe56e057f20f883e', '2', 'panjin', '盘锦企业1', '盘锦企业1');
INSERT INTO `user` VALUES ('27', '13', 'e10adc3949ba59abbe56e057f20f883e', '2', 'tieling', '铁岭企业1', '铁岭企业1');
INSERT INTO `user` VALUES ('28', '14', 'e10adc3949ba59abbe56e057f20f883e', '2', 'chaoyang', '朝阳企业1', '朝阳企业1');
INSERT INTO `user` VALUES ('29', '15', 'e10adc3949ba59abbe56e057f20f883e', '2', 'huludao', '葫芦岛企业1', '葫芦岛企业1');
INSERT INTO `user` VALUES ('30', '2', 'e10adc3949ba59abbe56e057f20f883e', '2', 'test1', '测试1', '测试1');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of year
-- ----------------------------
INSERT INTO `year` VALUES ('1', '放大', '1', '1', '1', '1', '13845637896', '1', '1', '1', '1', '1', '1', '', '1', '1', '1', '', '1', '1', '1', '沈阳企业1', '1', '010-1234567', '13412345678', '2017-03-01', '本溪', '沈阳企业1', 0xACED0005757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B47020000787000000001740006E8BF9BE58FA3, '电子商务综合型企业', '', '1', '1', '1', '1', '', '1', '1', '1', '1', '', '1', '1', '1', '1', '', '1', '1', '1', '1', '', '1', '1', '1', '1', '', '1', '1', '1', '1', '', '1', '1', '1', '1', '', '1', '1', '1', '1', '', '1', '1', '1', '1', '', '1', '1', '1', '1', 0xACED0005757200135B4C6A6176612E6C616E672E537472696E673BADD256E7E91D7B47020000787000000001740003423242, '2016', '16', '2', '2');
