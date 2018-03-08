/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50617
 Source Host           : 10.91.35.20:3306
 Source Schema         : dwtest

 Target Server Type    : MySQL
 Target Server Version : 50617
 File Encoding         : 65001

 Date: 08/03/2018 08:02:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `productName` varchar(50) DEFAULT NULL,
  `dir_id` int(20) DEFAULT NULL,
  `salePrice` int(20) DEFAULT NULL,
  `supplier` varchar(50) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `cutoff` float(30,2) DEFAULT NULL,
  `costPrice` float(30,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dir_id` (`dir_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`dir_id`) REFERENCES `productdir` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES (1, '罗技M90', 3, 90, '罗技', '罗技', 0.50, 35.00);
INSERT INTO `product` VALUES (2, '罗技M100', 2, 49, '罗技', '罗技', 0.50, 33.00);
INSERT INTO `product` VALUES (3, '罗技M115', 2, 99, '罗技', '罗技', 0.60, 38.00);
INSERT INTO `product` VALUES (4, '罗技M25', 2, 80, '罗技', '罗技', 0.90, 39.00);
INSERT INTO `product` VALUES (5, '罗技木星轨迹球', 1, 182, '罗技', '罗技', 0.87, 80.00);
INSERT INTO `product` VALUES (6, '罗技木星轨迹球', 3, 614, '罗技', '罗技', 0.70, 199.00);
INSERT INTO `product` VALUES (7, '罗技 G9X', 3, 1196, '罗技', '罗技', 0.50, 340.00);
INSERT INTO `product` VALUES (8, '罗技 G9X', 4, 1080, '罗技', '罗技', 0.40, 360.00);
INSERT INTO `product` VALUES (9, '罗技 Gas', 4, 1440, '罗技', '罗技', 0.40, 480.00);
INSERT INTO `product` VALUES (10, '罗技M91', 2, 2520, '罗技', '罗技', 0.40, 840.00);
INSERT INTO `product` VALUES (11, '罗技M111', 2, 2760, '罗技', '罗技', 0.40, 920.00);
COMMIT;

-- ----------------------------
-- Table structure for productdir
-- ----------------------------
DROP TABLE IF EXISTS `productdir`;
CREATE TABLE `productdir` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `dirName` varchar(50) DEFAULT NULL,
  `parent_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=216 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productdir
-- ----------------------------
BEGIN;
INSERT INTO `productdir` VALUES (1, '鼠标', NULL);
INSERT INTO `productdir` VALUES (2, '无线鼠标', '1');
INSERT INTO `productdir` VALUES (3, '有线鼠标', '1');
INSERT INTO `productdir` VALUES (4, '游戏鼠标', '1');
COMMIT;

-- ----------------------------
-- Table structure for productstock
-- ----------------------------
DROP TABLE IF EXISTS `productstock`;
CREATE TABLE `productstock` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `product_id` int(20) DEFAULT NULL,
  `storeNum` int(20) DEFAULT NULL,
  `lastIncomeDate` datetime(6) DEFAULT NULL,
  `lastOutComeDate` datetime(6) DEFAULT NULL,
  `warningNum` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productstock
-- ----------------------------
BEGIN;
INSERT INTO `productstock` VALUES (1, 1, 182, '2018-03-07 14:54:24.000000', '2018-03-07 14:54:27.000000', 20);
INSERT INTO `productstock` VALUES (2, 2, 12, '2018-03-07 14:55:22.000000', '2018-03-07 14:55:24.000000', 20);
INSERT INTO `productstock` VALUES (3, 3, 12, '2018-03-07 14:56:44.000000', '2018-03-07 14:56:46.000000', 6);
INSERT INTO `productstock` VALUES (4, 4, 213, '2018-03-07 14:56:53.000000', '2018-03-07 14:56:51.000000', 3);
INSERT INTO `productstock` VALUES (5, 5, 32, '2018-03-07 14:56:55.000000', '2018-03-07 14:56:56.000000', 3);
INSERT INTO `productstock` VALUES (6, 6, 123, '2018-03-07 14:56:59.000000', '2018-03-07 14:57:00.000000', 12);
INSERT INTO `productstock` VALUES (7, 7, 2, '2018-03-07 14:57:03.000000', '2018-03-07 14:57:27.000000', 5);
INSERT INTO `productstock` VALUES (8, 8, 45, '2018-03-07 14:57:09.000000', '2018-03-07 14:57:24.000000', 11);
INSERT INTO `productstock` VALUES (9, 9, 545, '2018-03-07 14:57:13.000000', '2018-03-07 14:57:21.000000', 2);
INSERT INTO `productstock` VALUES (10, 10, 45, '2018-03-07 14:57:30.000000', '2018-03-07 14:58:28.000000', 12);
INSERT INTO `productstock` VALUES (11, 11, 65, '2018-03-07 14:57:38.000000', '2018-03-07 14:57:35.000000', 2);
INSERT INTO `productstock` VALUES (12, 12, 7, '2018-03-07 14:58:05.000000', '2018-03-07 14:58:25.000000', 4);
INSERT INTO `productstock` VALUES (13, 13, 23, '2018-03-07 14:58:08.000000', '2018-03-07 14:58:31.000000', 7);
INSERT INTO `productstock` VALUES (14, 14, 456, '2018-03-07 14:58:10.000000', '2018-03-07 14:58:34.000000', 6);
INSERT INTO `productstock` VALUES (15, 16, 17, '2018-03-07 14:58:12.000000', '2018-03-07 14:58:36.000000', 7);
INSERT INTO `productstock` VALUES (16, 17, 28, '2018-03-07 14:58:15.000000', '2018-03-07 14:58:39.000000', 7);
INSERT INTO `productstock` VALUES (17, 18, 11, '2018-03-07 14:58:18.000000', '2018-03-07 14:58:42.000000', 7);
INSERT INTO `productstock` VALUES (18, 19, 10, '2018-03-07 14:58:21.000000', '2018-03-07 14:58:45.000000', 7);
INSERT INTO `productstock` VALUES (19, 20, 56, '2018-03-07 14:58:48.000000', '2018-03-07 14:59:09.000000', 8);
INSERT INTO `productstock` VALUES (20, 21, 36, '2018-03-07 14:58:51.000000', '2018-03-07 14:59:12.000000', 12);
INSERT INTO `productstock` VALUES (21, 22, 17, '2018-03-07 14:58:53.000000', '2018-03-07 14:59:15.000000', 8);
INSERT INTO `productstock` VALUES (22, 23, 83, '2018-03-07 14:58:58.000000', '2018-03-07 14:59:19.000000', 12);
INSERT INTO `productstock` VALUES (23, 24, 87, '2018-03-07 14:59:01.000000', '2018-03-07 14:59:21.000000', 12);
INSERT INTO `productstock` VALUES (24, 26, 94, '2018-03-07 14:59:04.000000', '2018-03-07 14:59:25.000000', 12);
INSERT INTO `productstock` VALUES (25, 27, 12, '2018-03-07 14:59:06.000000', '2018-03-07 14:59:28.000000', 12);
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `name` varchar(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
