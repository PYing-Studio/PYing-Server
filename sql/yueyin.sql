/*
Navicat MySQL Data Transfer

Source Server         : 119.29.135.223
Source Server Version : 50626
Source Host           : 119.29.135.223:3306
Source Database       : pyin

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-06-06 01:36:52
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `yueyin`
-- ----------------------------
DROP TABLE IF EXISTS `yueyin`;
CREATE TABLE `yueyin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `order_id` int(11) NOT NULL,
  `num` int(11) DEFAULT NULL COMMENT '买了多少张票',
  `friends` varchar(255) DEFAULT '',
  `status` int(11) DEFAULT NULL COMMENT '0：约影信息失效；1：约影信息',
  `movie_id` int(11) DEFAULT NULL,
  `movie_name` varchar(255) DEFAULT NULL,
  `cinema_id` varchar(255) DEFAULT NULL,
  `cinema_name` varchar(255) DEFAULT NULL,
  `show_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yueyin
-- ----------------------------
INSERT INTO `yueyin` VALUES ('24', 'lin', '38', '1', null, '1', null, '蓝精灵：寻找神秘村', null, '沙湾3D数字电影院', '2017-06-06 08:00:00');
INSERT INTO `yueyin` VALUES ('25', 'zz', '39', '1', null, '1', null, '迷失Z城', null, '沙湾3D数字电影院', '2017-06-06 09:00:00');
