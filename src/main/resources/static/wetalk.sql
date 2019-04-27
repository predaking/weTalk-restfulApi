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

 Date: 27/04/2019 23:22:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `publish_time` datetime(6) NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `praise_count` int(5) DEFAULT NULL,
  `transmit_count` int(5) DEFAULT NULL,
  `comment_count` int(5) DEFAULT NULL,
  `article_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `transmit_id` int(5) DEFAULT NULL,
  `transmit_content` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `transmit_nickname` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id` int(5) NOT NULL,
  `user_id` int(5) NOT NULL,
  `nickname` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('北京市', '2019-04-11 13:35:28.000000', '今天终于打上了少允段位。。哈哈哈', 8, 0, 0, '原创', -1, NULL, NULL, 65, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-11 15:49:54.000000', '一周又过去了。。。。。。。。。。。。。', 5, 0, 0, '原创', -1, NULL, NULL, 66, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-11 20:22:02.000000', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', 1, 3, 12, '原创', -1, NULL, NULL, 67, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-18 14:56:35.000000', '时间转换居然都能出问题。。。', 0, 2, 1, '原创', -1, NULL, NULL, 72, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-18 16:47:40.802000', '呵呵', 0, 1, 0, '转发', 72, '时间转换居然都能出问题。。。', '快银', 89, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-18 16:51:21.410000', '真是醉了', 0, 0, 0, '转发', 72, '时间转换居然都能出问题。。。', '快银', 90, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-18 17:25:33.000000', '你是不是傻', 0, 0, 0, '原创', -1, NULL, NULL, 91, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-18 17:28:39.000000', '没啥想说的', 0, 1, 0, '原创', -1, NULL, NULL, 92, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-18 22:17:50.000000', 'mmm', 0, 1, 0, '原创', -1, NULL, NULL, 94, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-18 22:19:10.000000', '刷新了么？', 0, 0, 1, '原创', -1, NULL, NULL, 95, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-18 22:24:26.339000', '能转发不', 0, 1, 0, '转发', 92, '没啥想说的', '快银', 96, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-21 22:30:14.408000', '转发了', 0, 0, 0, '转发', 96, '能转发不', '快银', 97, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-21 22:40:39.192000', '呵呵呵呵', 0, 0, 0, '转发', 89, '呵呵', '快银', 98, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-23 17:27:53.162000', 'emmmm', 0, 0, 0, '转发', 94, 'mmm', '快银', 99, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-23 17:30:22.000000', '还是有好多问题啊啊啊啊', 0, 0, 0, '原创', -1, NULL, NULL, 100, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-23 19:45:27.000000', '热的要死', 0, 0, 0, '原创', -1, NULL, NULL, 101, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-26 17:01:59.000000', 'wwwwwwwww', 0, 0, 0, '原创', -1, NULL, NULL, 102, 6, '快银', '/api/img/3084e5cbaadc8bb8.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-26 18:00:30.000000', '我也发一条吧', 0, 0, 1, '原创', -1, NULL, NULL, 103, 7, '萨维塔', '/api/img/1b5dd3f2ac2c046.jpg');
INSERT INTO `article` VALUES ('北京市', '2019-04-27 22:47:46.000000', 'emmm', 0, 0, 0, '原创', -1, NULL, NULL, 113, 105, '辣鸡', '/static/img/head-boy.8a61cf0.jpg');

-- ----------------------------
-- Table structure for article_picture
-- ----------------------------
DROP TABLE IF EXISTS `article_picture`;
CREATE TABLE `article_picture`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `picture_id` int(5) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_picture
-- ----------------------------
INSERT INTO `article_picture` VALUES (9, '693c25b7777266e6.jpg', 59);
INSERT INTO `article_picture` VALUES (10, '721f4ff682a2bc8f.jpg', 59);
INSERT INTO `article_picture` VALUES (11, '730b66c5b8b3fbe9.jpg', 59);
INSERT INTO `article_picture` VALUES (12, '1488813520987.jpg', 60);
INSERT INTO `article_picture` VALUES (13, '1488813687315.jpg', 60);
INSERT INTO `article_picture` VALUES (14, '-5d0134790175fcfa.jpg', 61);
INSERT INTO `article_picture` VALUES (15, '-5e7dde3fe3988418.jpg', 61);
INSERT INTO `article_picture` VALUES (16, '-5efaae29f35625db.jpg', 61);
INSERT INTO `article_picture` VALUES (17, '-5d0134790175fcfa.jpg', 62);
INSERT INTO `article_picture` VALUES (18, '-5e7dde3fe3988418.jpg', 62);
INSERT INTO `article_picture` VALUES (19, '-5efaae29f35625db.jpg', 62);
INSERT INTO `article_picture` VALUES (20, '-5d0134790175fcfa.jpg', 63);
INSERT INTO `article_picture` VALUES (21, '-5e7dde3fe3988418.jpg', 63);
INSERT INTO `article_picture` VALUES (22, '-5efaae29f35625db.jpg', 63);
INSERT INTO `article_picture` VALUES (23, '-5d0134790175fcfa.jpg', 64);
INSERT INTO `article_picture` VALUES (24, '-5e7dde3fe3988418.jpg', 64);
INSERT INTO `article_picture` VALUES (25, '-5efaae29f35625db.jpg', 64);
INSERT INTO `article_picture` VALUES (26, '-30fa569aedc509d3.jpg', 65);
INSERT INTO `article_picture` VALUES (27, '-16111477d4f80c99.jpg', 66);
INSERT INTO `article_picture` VALUES (28, '7067499c60871a47.jpg', 66);
INSERT INTO `article_picture` VALUES (29, '63e3a254c5202e57.jpg', 67);
INSERT INTO `article_picture` VALUES (30, '-27387e1b11f76547.jpg', 72);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `comment_id` int(5) NOT NULL,
  `comment_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_user_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_time` datetime(6) NOT NULL,
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment_user_id` int(5) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 67, '快银', '/api/img/3084e5cbaadc8bb8.jpg', '2019-04-21 20:20:57.600000', '。。。', 6);
INSERT INTO `comment` VALUES (2, 67, '快银', '/api/img/3084e5cbaadc8bb8.jpg', '2019-04-21 22:00:16.136000', 'emmmmmmm', 6);
INSERT INTO `comment` VALUES (3, 67, '快银', '/api/img/3084e5cbaadc8bb8.jpg', '2019-04-21 22:19:23.904000', 'lllll', 6);
INSERT INTO `comment` VALUES (4, 67, '快银', '/api/img/3084e5cbaadc8bb8.jpg', '2019-04-21 22:23:01.410000', '》》》》》》》》》', 6);
INSERT INTO `comment` VALUES (5, 67, '快银', '/api/img/3084e5cbaadc8bb8.jpg', '2019-04-21 22:25:10.727000', 'fuck', 6);
INSERT INTO `comment` VALUES (6, 67, '快银', '/api/img/3084e5cbaadc8bb8.jpg', '2019-04-21 22:26:29.209000', 'what？', 6);
INSERT INTO `comment` VALUES (7, 67, '快银', '/api/img/3084e5cbaadc8bb8.jpg', '2019-04-21 22:27:04.037000', 'ddddddd', 6);
INSERT INTO `comment` VALUES (8, 67, '快银', '/api/img/3084e5cbaadc8bb8.jpg', '2019-04-21 22:28:05.271000', 'ggg', 6);
INSERT INTO `comment` VALUES (9, 67, '快银', '/api/img/3084e5cbaadc8bb8.jpg', '2019-04-21 22:28:13.831000', 'ooooo', 6);
INSERT INTO `comment` VALUES (10, 72, '萨维塔', '/api/img/1b5dd3f2ac2c046.jpg', '2019-04-22 13:22:25.074000', '不知道', 7);
INSERT INTO `comment` VALUES (18, 67, '辣鸡', '/static/img/head-boy.8a61cf0.jpg', '2019-04-27 20:31:45.948000', 'what？', 105);
INSERT INTO `comment` VALUES (19, 103, '辣鸡', '/static/img/head-boy.8a61cf0.jpg', '2019-04-27 22:41:43.568000', 'emmm', 105);

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
INSERT INTO `hibernate_sequence` VALUES (114);

-- ----------------------------
-- Table structure for praise
-- ----------------------------
DROP TABLE IF EXISTS `praise`;
CREATE TABLE `praise`  (
  `user_id` int(5) NOT NULL,
  `article_id` int(5) NOT NULL,
  `praise_state` int(2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of praise
-- ----------------------------
INSERT INTO `praise` VALUES (6, 65, 1);
INSERT INTO `praise` VALUES (105, 67, 1);

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `reply_id` int(5) NOT NULL,
  `reply_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reply_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reply_user_id` int(5) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES (1, 6, '快银', 'shit', 6);
INSERT INTO `reply` VALUES (3, 10, '萨维塔', '为啥不知道', 7);
INSERT INTO `reply` VALUES (7, 19, '辣鸡', 'emm', 105);

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 111 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (6, '快银', NULL, NULL, NULL, '15624950080', 'jt2vk35I', '3084e5cbaadc8bb8.jpg');
INSERT INTO `user` VALUES (7, '萨维塔', NULL, NULL, NULL, '15624950080', 'jt2vk35I', '1b5dd3f2ac2c046.jpg');
INSERT INTO `user` VALUES (9, '龚伟', NULL, NULL, NULL, '15624950080', 'jt2vk35I', NULL);
INSERT INTO `user` VALUES (10, '二货', NULL, NULL, NULL, '10086', 'jt2vk35I', '37932fde88df2399.jpg');
INSERT INTO `user` VALUES (11, '关羽', NULL, NULL, NULL, '10086', 'jt2vk35I', '1297476468079.jpg');
INSERT INTO `user` VALUES (12, '庞德', NULL, NULL, NULL, '10010', 'jt2vk35I', '234f86c9408aec8d.jpg');
INSERT INTO `user` VALUES (68, '玉藻前', NULL, NULL, NULL, '10086', 'jt2vk35I', NULL);
INSERT INTO `user` VALUES (69, '大天狗', NULL, NULL, NULL, '10086', 'jt2vk35I', NULL);
INSERT INTO `user` VALUES (70, '白藏主', NULL, NULL, NULL, '10086', 'jt2vk35I', NULL);
INSERT INTO `user` VALUES (71, '鬼切', NULL, NULL, NULL, '10086', 'jt2vk35I', '1488813520987.jpg');
INSERT INTO `user` VALUES (104, '山风', NULL, NULL, NULL, '10086', 'jt2vk35I', NULL);
INSERT INTO `user` VALUES (105, '辣鸡', '男', '2019-04-27', '北京市', '10086', 'jt2vk35I', NULL);
INSERT INTO `user` VALUES (107, '花鸟卷', NULL, NULL, NULL, '10010', 'jt2vk35I', NULL);
INSERT INTO `user` VALUES (108, '茨木', NULL, NULL, NULL, '10010', 'jt2vk35I', NULL);
INSERT INTO `user` VALUES (109, '荒', NULL, NULL, NULL, '10010', 'jt2vk35I', NULL);
INSERT INTO `user` VALUES (110, '酒吞', NULL, NULL, NULL, '10010', 'jt2vk35I', NULL);

SET FOREIGN_KEY_CHECKS = 1;
