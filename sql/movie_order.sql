/*
Navicat MySQL Data Transfer

Source Server         : 119.29.135.223
Source Server Version : 50626
Source Host           : 119.29.135.223:3306
Source Database       : pyin

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-06-06 01:36:42
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `movie_order`
-- ----------------------------
DROP TABLE IF EXISTS `movie_order`;
CREATE TABLE `movie_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(11) DEFAULT NULL COMMENT '0：取消订单；1：成功完成；2：等待支付；3：超过支付时间',
  `has_yueyin` int(1) DEFAULT '0' COMMENT '该订单是否发出约影',
  `username` varchar(255) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `movie_name` varchar(255) DEFAULT NULL,
  `cinema_id` int(11) NOT NULL,
  `cinema_name` varchar(255) DEFAULT NULL,
  `show_time` datetime DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `make_time` datetime DEFAULT NULL,
  `num` int(11) DEFAULT NULL COMMENT '买了多少张票',
  `seat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie_order
-- ----------------------------
INSERT INTO `movie_order` VALUES ('37', '1', '1', 'lin', '38977', '迷失Z城', '1', '沙湾3D数字电影院', '2017-06-06 08:00:00', '2017-06-06 00:12:44', '2017-06-06 00:12:39', '1', '');
INSERT INTO `movie_order` VALUES ('38', '1', '1', 'lin', '78610', '蓝精灵：寻找神秘村', '1', '沙湾3D数字电影院', '2017-06-06 08:00:00', '2017-06-06 00:39:49', '2017-06-06 00:39:43', '1', '');
INSERT INTO `movie_order` VALUES ('39', '1', '1', 'zz', '38977', '迷失Z城', '1', '沙湾3D数字电影院', '2017-06-06 09:00:00', '2017-06-06 00:51:19', '2017-06-06 00:51:12', '1', '');
