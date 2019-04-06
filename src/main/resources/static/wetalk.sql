/*
 Navicat Premium Data Transfer

 Source Server         : weTalk
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : wetalk

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 06/04/2019 22:29:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `publish_time` time(6) NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `praise_count` int(5) DEFAULT 0,
  `transmit_count` int(5) DEFAULT 0,
  `comment_count` int(5) DEFAULT 0,
  `article_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0',
  `transmit_id` int(5) DEFAULT NULL,
  `transmit_content` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `transmit_nickname` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (15, '快银', 'jt2vk35I', '北京', '10:30:30.000000', 'emmmmmmmmmmmm', 0, 0, 0, '原创', NULL, NULL, NULL);
INSERT INTO `article` VALUES (16, '快银', 'jt2vk35I', '北京', '10:30:30.000000', 'emmmmmmmmmmmm', 0, 0, 0, '原创', NULL, NULL, NULL);
INSERT INTO `article` VALUES (17, '快银', 'jt2vk35I', '北京', '10:30:30.000000', 'emmmmmmmmmmmm', 0, 0, 0, '原创', NULL, NULL, NULL);
INSERT INTO `article` VALUES (18, '快银', 'jt2vk35I', '北京', '10:30:30.000000', 'emmmmmmmmmmmm', 0, 0, 0, '原创', 0, NULL, NULL);

-- ----------------------------
-- Table structure for article_picture
-- ----------------------------
DROP TABLE IF EXISTS `article_picture`;
CREATE TABLE `article_picture`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `picture_id` int(5) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(5) NOT NULL,
  `comment_id` int(5) NOT NULL,
  `comment_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_user_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_time` time(6) NOT NULL,
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (19);

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `id` int(5) NOT NULL,
  `reply_id` int(5) NOT NULL,
  `reply_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reply_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (6, '快银', NULL, NULL, NULL, '15624950080', 'jt2vk35I', '25f0627c9f85bcbb.jpg', NULL);
INSERT INTO `user` VALUES (7, '萨维塔', NULL, NULL, NULL, '15624950080', 'jt2vk35I', '1b5dd3f2ac2c046.jpg', NULL);
INSERT INTO `user` VALUES (9, '龚伟', NULL, NULL, NULL, '15624950080', 'jt2vk35I', NULL, NULL);
INSERT INTO `user` VALUES (10, '二货', NULL, NULL, NULL, '10086', 'jt2vk35I', '37932fde88df2399.jpg', NULL);
INSERT INTO `user` VALUES (11, '关羽', NULL, NULL, NULL, '10086', 'jt2vk35I', '1297476468079.jpg', NULL);
INSERT INTO `user` VALUES (12, '庞德', NULL, NULL, NULL, '10010', 'jt2vk35I', '234f86c9408aec8d.jpg', NULL);

SET FOREIGN_KEY_CHECKS = 1;
