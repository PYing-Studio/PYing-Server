/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : pyin

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-05-31 00:07:24
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `cinema`
-- ----------------------------
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema` (
  `id` int(11) NOT NULL,
  `city_id` int(11) DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `maoyanjson` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cinema
-- ----------------------------

-- ----------------------------
-- Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL DEFAULT '0',
  `username` varchar(255) DEFAULT NULL,
  `movie_id` int(11) DEFAULT NULL,
  `movie_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------

-- ----------------------------
-- Table structure for `hot_movie`
-- ----------------------------
DROP TABLE IF EXISTS `hot_movie`;
CREATE TABLE `hot_movie` (
  `id` int(11) NOT NULL,
  `is_3d` int(1) DEFAULT NULL,
  `cat` varchar(255) DEFAULT NULL,
  `cnms` int(11) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `dur` int(11) DEFAULT NULL,
  `imax` int(1) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `late` int(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pn` int(11) DEFAULT NULL,
  `preSale` int(11) DEFAULT NULL,
  `rt` varchar(255) DEFAULT NULL,
  `sc` float DEFAULT NULL,
  `scm` varchar(255) DEFAULT NULL,
  `showData` varchar(255) DEFAULT NULL,
  `showinfo` varchar(255) DEFAULT NULL,
  `sn` int(11) DEFAULT NULL,
  `snum` int(11) DEFAULT NULL,
  `src` varchar(255) DEFAULT NULL,
  `star` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `vd` varchar(255) DEFAULT NULL,
  `ver` varchar(255) DEFAULT NULL,
  `wish` int(11) DEFAULT NULL,
  `maoyanjson` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hot_movie
-- ----------------------------

-- ----------------------------
-- Table structure for `movies`
-- ----------------------------
DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies` (
  `id` int(11) NOT NULL,
  `is_3d` int(1) DEFAULT NULL,
  `cat` varchar(255) DEFAULT NULL,
  `cnms` int(11) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `dur` int(11) DEFAULT NULL,
  `imax` int(1) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `late` int(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pn` int(11) DEFAULT NULL,
  `preSale` int(11) DEFAULT NULL,
  `rt` varchar(255) DEFAULT NULL,
  `sc` float DEFAULT NULL,
  `scm` varchar(255) DEFAULT NULL,
  `showData` varchar(255) DEFAULT NULL,
  `showinfo` varchar(255) DEFAULT NULL,
  `sn` int(11) DEFAULT NULL,
  `snum` int(11) DEFAULT NULL,
  `src` varchar(255) DEFAULT NULL,
  `star` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `vd` varchar(255) DEFAULT NULL,
  `ver` varchar(255) DEFAULT NULL,
  `wish` int(11) DEFAULT NULL,
  `dra` text,
  `maoyanjson` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movies
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `move_name` varchar(255) DEFAULT NULL,
  `cinema_id` varchar(255) NOT NULL,
  `cinema_name` varchar(255) DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `make_time` datetime DEFAULT NULL,
  `num` int(11) DEFAULT NULL COMMENT '买了多少张票',
  `seat` varchar(255) DEFAULT NULL,
  `statue` int(11) DEFAULT NULL COMMENT '0：超过支付时间；1：成功完成；2：等待支付；3：取消订单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '递增主键',
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `yueyin`
-- ----------------------------
DROP TABLE IF EXISTS `yueyin`;
CREATE TABLE `yueyin` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `move_name` varchar(255) DEFAULT NULL,
  `cinema_id` varchar(255) NOT NULL,
  `cinema_name` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `num` int(11) DEFAULT NULL COMMENT '买了多少张票',
  `friends` varchar(255) DEFAULT NULL,
  `statue` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yueyin
-- ----------------------------
