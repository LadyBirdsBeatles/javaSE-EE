/*
 Navicat Premium Data Transfer

 Source Server         : 黄启迪property
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 172.16.11.94:3306
 Source Schema         : property

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 04/07/2019 15:54:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for access
-- ----------------------------
DROP TABLE IF EXISTS `access`;
CREATE TABLE `access`  (
  `Access_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `Access_carcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号',
  `Access_startdate` datetime(0) NULL DEFAULT NULL COMMENT '入场时间',
  `Access_enddate` datetime(0) NULL DEFAULT NULL COMMENT '退场时间',
  `Access_cost` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '费用',
  `Access_other1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段1',
  `Access_other2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段2',
  PRIMARY KEY (`Access_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '车辆出入表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of access
-- ----------------------------
INSERT INTO `access` VALUES (1, '川ABV370', '2019-07-01 15:56:24', '2019-07-01 17:25:10', '10', NULL, NULL);
INSERT INTO `access` VALUES (2, '冀FD78M6', '2019-07-01 16:13:13', '2019-07-01 17:23:05', '10', NULL, NULL);
INSERT INTO `access` VALUES (3, '津C8GC65', '2019-07-01 16:13:16', '2019-07-01 17:25:04', '10', NULL, NULL);
INSERT INTO `access` VALUES (4, '冀D61Q31', '2019-07-01 16:14:33', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (5, '渝B72E01', '2019-07-01 16:14:34', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (6, '沪DW4G96', '2019-07-01 16:14:34', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (7, '渝B27K4F', '2019-07-01 16:14:35', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (8, '冀A7640B', '2019-07-01 16:14:35', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (9, '津BI58V2', '2019-07-01 16:14:35', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (10, '沪A26R4I', '2019-07-01 16:14:35', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (11, '京A679VZ', '2019-07-01 16:14:35', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (12, '沪BK80X2', '2019-07-01 16:14:36', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (13, '冀C4ZA79', '2019-07-01 16:14:36', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (14, '冀GJ05Q6', '2019-07-01 16:14:36', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (15, '渝H08RH4', '2019-07-01 16:14:36', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (16, '冀T8QT03', '2019-07-01 16:14:36', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (17, '冀CA633O', '2019-07-01 16:14:36', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (18, '津E1L0G4', '2019-07-01 16:14:36', NULL, '10', NULL, NULL);
INSERT INTO `access` VALUES (19, '冀F23S1Y', '2019-07-01 16:14:37', '2019-07-03 11:45:37', '10', NULL, NULL);
INSERT INTO `access` VALUES (20, '京EK0245', '2019-07-01 16:14:37', '2019-07-03 11:45:49', '10', NULL, NULL);
INSERT INTO `access` VALUES (21, '冀HU9V61', '2019-07-01 16:14:37', '2019-07-03 16:19:27', '10', NULL, NULL);
INSERT INTO `access` VALUES (22, '京E5E9J6', '2019-07-04 12:45:03', NULL, '10', '1', NULL);
INSERT INTO `access` VALUES (23, '渝GP22I0', '2019-07-04 14:49:21', '2019-07-04 14:50:10', '10', '1', NULL);

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `admin_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `admin_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `admin_phonenumber` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `admin_post` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工岗位',
  `admin_power` int(12) NULL DEFAULT NULL COMMENT '管理员权限(0.超级管理员 1.客服 2.无权限)',
  `admin_salary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工薪资',
  `admin_date` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工加入公司时间',
  `admin_status` int(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '员工在职状态(0.在职 1.离职)',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '物业人员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '张大千', '123', '1871882459', '维修人员', 2, '4000', '2019-06-04 ', 0);
INSERT INTO `admin` VALUES (2, '王小玉', '123', '1721338362', '客服', 1, '5000', '2019-06-04 ', 0);
INSERT INTO `admin` VALUES (3, '王锡元', '123456', '1530801706', '客服', 1, '20000', '2019-06-04 ', 0);
INSERT INTO `admin` VALUES (4, '刘永强', '123456', '1530801715', '维修人员', 2, '20000', '2019-06-04 ', 0);
INSERT INTO `admin` VALUES (5, '陈国利', '123456', '1530801700', '保安队长', 0, '20000', '2019-06-04 ', 0);
INSERT INTO `admin` VALUES (6, '杨辉', '55bd8ebac92eb9f36bfe108cbdde75a1', '13555555555', '保安', 0, '18000', '2019-06-04 ', 0);
INSERT INTO `admin` VALUES (7, '刘建成', '123', '13111111111', '保安', 0, '12000', '2019-06-04 ', 0);
INSERT INTO `admin` VALUES (8, '周玉生', '123456', '15347895621', '保洁', 0, '6900', '2019-07-03', 1);
INSERT INTO `admin` VALUES (9, '祁同伟', '7057449c40e3807419827bc62dbe26bc', '15678562465', '保洁', 1, '18000', '2019-07-03', 0);
INSERT INTO `admin` VALUES (10, '唐立飞', '123456', '15325468452', '保安', 0, '55555', '2019-07-03', 1);
INSERT INTO `admin` VALUES (11, '许笠', 'faab42bc453b7d5075bb504bd480669f', '15308081708', '项目经理', 0, '9998', '2019-06-04', 0);
INSERT INTO `admin` VALUES (12, '黄启迪', '82fb39b6ab9f3f87bc46138bce8ee1f9', '17360105523', '客服', 1, '9998', '2019-06-04', 0);

-- ----------------------------
-- Table structure for appeal
-- ----------------------------
DROP TABLE IF EXISTS `appeal`;
CREATE TABLE `appeal`  (
  `appeal_id` int(11) NOT NULL AUTO_INCREMENT,
  `appeal_uid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `appeal_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `appeal_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `appeal_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '提交内容',
  `appeal_state` int(11) NULL DEFAULT NULL COMMENT '状态(0.未处理，1.处理中，2.处理完成待评价，3.已评价)',
  `admin_id` int(11) NULL DEFAULT NULL COMMENT '客服',
  `appeal_eva` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评价',
  PRIMARY KEY (`appeal_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '投诉评价' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appeal
-- ----------------------------
INSERT INTO `appeal` VALUES (1, 10, '邻居晚上太吵', '2019-07-04 11:39:58', '邻居晚上太吵', 3, 12, '');
INSERT INTO `appeal` VALUES (2, 9, '邻居晚上太吵', '2019-07-04 13:49:18', '邻居晚上太吵', 0, NULL, '未评价');
INSERT INTO `appeal` VALUES (3, 10, '邻居晚上太吵', '2019-07-04 15:05:11', '邻居晚上太吵', 0, NULL, '未评价');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `Car_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `Car_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号',
  `Car_exhaust` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排量',
  `Car_pid` int(11) NULL DEFAULT NULL COMMENT '车位id（0代表无车位）',
  `Car_uid` int(11) NULL DEFAULT NULL COMMENT '业主id',
  `Car_startdate` datetime(0) NULL DEFAULT NULL COMMENT '无车位时，通行证开始时间',
  `Car_enddate` datetime(0) NULL DEFAULT NULL COMMENT '无车位时，通行证结束时间',
  `Car_other1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段1',
  `Car_other2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段2',
  PRIMARY KEY (`Car_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '车辆表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES (1, '川AR7125', NULL, 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `car` VALUES (2, '川A12345', NULL, 3, 2, NULL, NULL, NULL, NULL);
INSERT INTO `car` VALUES (3, '川AT5126', NULL, 2, 3, NULL, NULL, NULL, NULL);
INSERT INTO `car` VALUES (4, '川CT5621', NULL, 5, 4, NULL, NULL, NULL, NULL);
INSERT INTO `car` VALUES (5, '川AY52016', NULL, 3, 6, NULL, NULL, NULL, NULL);
INSERT INTO `car` VALUES (6, '川AF9560', NULL, NULL, 3, '2019-07-01 00:00:00', '2020-08-01 00:00:00', NULL, NULL);
INSERT INTO `car` VALUES (7, '川BA12345', NULL, 7, 8, NULL, NULL, NULL, NULL);
INSERT INTO `car` VALUES (8, '川AB88888', NULL, 8, 9, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for cost
-- ----------------------------
DROP TABLE IF EXISTS `cost`;
CREATE TABLE `cost`  (
  `cost_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `cost_water` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '水费表',
  `cost_gas` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '燃气费',
  `cost_power` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电费',
  `cost_air` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '空调费',
  `cost_other` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他费用',
  `cost_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `cost_state` int(10) NULL DEFAULT NULL COMMENT '缴费状态(0.未缴费，1.已缴费)',
  `cost_uid` int(100) NULL DEFAULT NULL COMMENT '业主id',
  PRIMARY KEY (`cost_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '缴费表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cost
-- ----------------------------
INSERT INTO `cost` VALUES (1, '20', '20', '49', '40', '33', '2019-01-01 00:00:00', 1, 9);
INSERT INTO `cost` VALUES (2, '22', '30', '25', '33', '40', '2019-01-01 00:00:00', 1, 10);
INSERT INTO `cost` VALUES (3, '30', '35', '29', '35', '45', '2019-02-01 00:00:00', 1, 10);
INSERT INTO `cost` VALUES (4, '300', '25', '65', '30', '40', '2019-03-01 00:00:00', 1, 10);

-- ----------------------------
-- Table structure for msg
-- ----------------------------
DROP TABLE IF EXISTS `msg`;
CREATE TABLE `msg`  (
  `msg_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `msg_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 标题',
  `msg_partstarttime` datetime(0) NULL DEFAULT NULL COMMENT '活动发起时间',
  `msg_partendtime` datetime(0) NULL DEFAULT NULL COMMENT '活动结束时间',
  `msg_createtime` date NULL DEFAULT NULL COMMENT '创建时间',
  `msg_partstate` int(255) NULL DEFAULT NULL COMMENT '发布状态(0.进行中1.已过期)',
  `msg_admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布人',
  `msg_class` int(255) NOT NULL COMMENT '分类(0.公司1.小区2.公告3.社区活动）',
  `msg_other1` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文本内容',
  `msg_other2` int(11) NULL DEFAULT NULL COMMENT '预留字段2',
  `msg_other3` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`msg_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of msg
-- ----------------------------
INSERT INTO `msg` VALUES (2, 'hhhhhh骨灰盒', '2019-07-03 13:37:50', '2019-07-03 13:37:43', '2019-07-03', 2, '小黄', 5, 'sdfsdfsfsdf', NULL, NULL);
INSERT INTO `msg` VALUES (3, 'dfsdfsdf', '2019-07-03 10:50:27', '2019-07-03 00:00:00', '2019-07-03', 0, '小黄', 5, 'sdfsdfsdff', NULL, NULL);
INSERT INTO `msg` VALUES (4, 'ghjfghjfghj', '2019-07-03 10:50:37', '2019-07-03 10:50:39', '2019-07-04', 3, '小黄', 5, 'fghfghfgh', NULL, NULL);
INSERT INTO `msg` VALUES (5, '水电费水电费水电费', '2019-07-03 13:37:54', '2019-07-03 13:38:04', '2019-07-03', 2, '小黄', 5, '环境', NULL, NULL);
INSERT INTO `msg` VALUES (6, '电饭锅电饭锅电饭锅电饭锅', '2019-07-03 13:37:58', '2019-07-03 13:38:01', '2019-07-03', 1, '小黄', 5, '电饭锅电饭锅电饭锅水电费规定', NULL, NULL);
INSERT INTO `msg` VALUES (7, '11', NULL, NULL, '2019-07-04', NULL, '小黄', 5, '351', NULL, NULL);
INSERT INTO `msg` VALUES (8, '12', '2019-07-11 00:00:00', '2019-07-26 00:00:00', '2019-07-04', NULL, '小黄', 5, '123', NULL, NULL);
INSERT INTO `msg` VALUES (9, 'yjfghfgh', NULL, NULL, '2019-07-03', NULL, '小黄', 5, 'fghdfgdfghdfg', NULL, NULL);
INSERT INTO `msg` VALUES (10, 'hjkhjkhjkhjk', '2019-07-03 18:03:08', '2019-07-03 18:03:09', '2019-07-04', NULL, '小黄', 5, 'hjkhjkhjkjk', NULL, NULL);
INSERT INTO `msg` VALUES (11, '停电通知', NULL, NULL, '2019-07-04', NULL, '小黄', 2, '7月5号下午2点本公司将对小区电路进行维护,大概停电3小时,希望各位业主理解~', NULL, NULL);
INSERT INTO `msg` VALUES (12, '广场舞大赛', '2019-07-07 17:00:00', '2019-07-07 21:00:00', '2019-07-04', NULL, '小黄', 3, '本周日社区将会举办广场舞大赛,前三名将获得免费车位半年,请各位广场舞爱好者踊跃参与,物业中心报名', NULL, NULL);
INSERT INTO `msg` VALUES (13, 'jkujkujk', '2019-07-04 00:00:00', '2019-07-04 00:00:00', '2019-07-04', NULL, '小黄', 5, 'UK预计哭就哭健康', NULL, NULL);
INSERT INTO `msg` VALUES (14, '官方客服赶快来', '2019-07-04 00:00:00', '2019-07-04 00:00:00', '2019-07-04', NULL, '许笠', 5, ';领;领克', NULL, NULL);
INSERT INTO `msg` VALUES (15, '公司介绍', NULL, NULL, '2019-07-01', NULL, '许笠', 0, '金港物业（全称：金港物业发展有限公司）是万科企业股份有限公司的控股子公司，专注于住宅物业服务、商写物业服务、开发商服务、资产服务、楼宇智能化服务和基于客户移动互联网终端六大业务单元。\r\n截至2017年12月底，金港物业已布局中国20个具有发展潜力的大中城市，服务项目共计200个，合同面积近5000万平方米，服务40万户家庭，超100万人口，在管资产突破1亿元，在职员工人数超2000名。', NULL, NULL);
INSERT INTO `msg` VALUES (16, '小区介绍', NULL, NULL, '2019-07-04', NULL, '许笠', 1, '小区内部环境典雅幽静，绿化多，通过小区道路的合理组织，休闲设施的精心安排，提供自然、舒适的居住环境。周边配套齐全，设施完备，物业管理完善，保安24小时值班，住户素质高。社区主流健康向上，社区风气良好，邻里关系和谐。基础设施健全，周围商圈多，购物，就医，娱乐等方便快捷。为一个集生态环境、人文环境、信息化和管理控制自动化等优质服务为一体的高档个性化住宅小区。环境优美，丽水成天的风景给予了回归家庭、回归私域的生活体验。房屋楼层分布均匀，室内装修豪华气派，视眼非常宽广，采光较好。坐北朝南.', NULL, NULL);
INSERT INTO `msg` VALUES (17, '换个房间看到很反感', NULL, NULL, '2019-07-04', NULL, '许笠', 2, '会尽快回款计划科技', NULL, NULL);
INSERT INTO `msg` VALUES (18, '哈哈哈交', NULL, NULL, '2019-07-04', NULL, '黄启迪', 2, '哈哈哈哈扩军或军', NULL, NULL);
INSERT INTO `msg` VALUES (19, '规范交通费', '2019-07-09 00:00:00', '2019-07-04 00:00:00', '2019-07-04', NULL, '黄启迪', 3, 'VB不VC', NULL, NULL);

-- ----------------------------
-- Table structure for msgcount
-- ----------------------------
DROP TABLE IF EXISTS `msgcount`;
CREATE TABLE `msgcount`  (
  `msgcount_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `msgcount_pid` int(11) NULL DEFAULT NULL COMMENT '社区活动表',
  `msgcount_uid` int(11) NULL DEFAULT NULL COMMENT '用户表',
  `msgcount_readtime` datetime(0) NULL DEFAULT NULL COMMENT '阅读时间',
  PRIMARY KEY (`msgcount_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '浏览表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of msgcount
-- ----------------------------
INSERT INTO `msgcount` VALUES (1, 4, 2, '2019-07-03 15:13:29');
INSERT INTO `msgcount` VALUES (2, 7, 2, '2019-07-03 18:24:46');
INSERT INTO `msgcount` VALUES (3, 10, 2, '2019-07-03 18:24:52');
INSERT INTO `msgcount` VALUES (4, 11, 10, '2019-07-04 15:07:07');

-- ----------------------------
-- Table structure for park
-- ----------------------------
DROP TABLE IF EXISTS `park`;
CREATE TABLE `park`  (
  `Park_id` int(11) NOT NULL COMMENT '主键id',
  `Park_cid` int(11) NULL DEFAULT NULL COMMENT '车辆id',
  `Park_uid` int(11) NULL DEFAULT NULL COMMENT '私有车位业主id（0表示此车位非私有）',
  `Park_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车位位置(A-1-03)',
  `Park_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '价格',
  `Park_saledate` datetime(6) NULL DEFAULT NULL COMMENT '出售时间',
  PRIMARY KEY (`Park_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '车位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of park
-- ----------------------------
INSERT INTO `park` VALUES (1, 1, 2, '13栋地下2层', '130000', NULL);
INSERT INTO `park` VALUES (2, 3, 8, '13栋地下2层', '120000', '2019-07-02 22:00:23.000000');
INSERT INTO `park` VALUES (3, 2, 6, '13栋地下2层', '125000', '2019-07-02 21:37:30.000000');
INSERT INTO `park` VALUES (4, 5, 3, '13栋地下2层', '126000', '2019-07-02 21:46:09.000000');
INSERT INTO `park` VALUES (5, 3, 7, '11栋地下1层', '180000', '2019-07-02 21:28:56.000000');
INSERT INTO `park` VALUES (6, NULL, 5, '18栋地下2层', '120000', NULL);
INSERT INTO `park` VALUES (7, 7, 8, '9栋地下1层', '180000', '2019-07-02 22:08:30.000000');
INSERT INTO `park` VALUES (8, 8, 9, '9栋地下1层', '160000', '2019-07-02 22:39:32.000000');
INSERT INTO `park` VALUES (9, NULL, NULL, '2栋地下2层', '120000', NULL);
INSERT INTO `park` VALUES (10, NULL, NULL, '3栋地下2层', '160000', NULL);

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay`  (
  `pay_id` int(11) NOT NULL AUTO_INCREMENT,
  `pay_costid` int(255) NULL DEFAULT NULL COMMENT '缴费表id',
  `pay_date` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_way` int(11) NULL DEFAULT NULL COMMENT '支付方式（0.线下，1.线上）',
  PRIMARY KEY (`pay_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '支付信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay
-- ----------------------------
INSERT INTO `pay` VALUES (1, 1, '2019-07-04 13:50:53', 1);
INSERT INTO `pay` VALUES (2, 2, '2019-07-04 14:01:24', 1);
INSERT INTO `pay` VALUES (3, 4, '2019-07-04 15:00:41', 0);
INSERT INTO `pay` VALUES (4, 3, '2019-07-04 15:05:44', 1);

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair`  (
  `repair_id` int(11) NOT NULL AUTO_INCREMENT,
  `repair_uid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `repair_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `repair_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `repair_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '提交内容',
  `repair_state` int(11) NULL DEFAULT NULL COMMENT '状态(0.未处理，1.处理中，2.处理完成待评价，3.已评价)',
  `repair_eva` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评价',
  `admin_id` int(11) NULL DEFAULT NULL COMMENT '客服/员工id',
  PRIMARY KEY (`repair_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '报修表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES (1, 9, '水管爆裂', '2019-07-04 10:16:35', '水管爆裂', 0, '未评价', 1);
INSERT INTO `repair` VALUES (2, 10, '空調坏了', '2019-07-04 11:45:10', '空調坏了', 3, '好', 1);
INSERT INTO `repair` VALUES (3, 9, '大门坏了', '2019-07-04 13:48:05', '大门坏了', 1, '未评价', 1);
INSERT INTO `repair` VALUES (4, 10, '水管爆裂', '2019-07-04 15:04:25', '水管爆裂', 0, '未评价', NULL);

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `reply_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复类容',
  `reply_date` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  `reply_appid` int(11) NULL DEFAULT NULL COMMENT '投诉表(报修表)id',
  `reply_person` int(25) NULL DEFAULT NULL COMMENT '添加该回复人员(0.用户 1.客服)',
  `reply_type` int(11) NULL DEFAULT NULL COMMENT '回复类型（0.报修表，1.投诉表）',
  PRIMARY KEY (`reply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '回复表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES (1, '请尽快处理', '2019-07-04 11:48:13', 2, 0, 0);
INSERT INTO `reply` VALUES (3, '感谢', '2019-07-04 14:06:00', 2, 0, 0);
INSERT INTO `reply` VALUES (4, '正在处理', '2019-07-04 14:57:33', 3, 1, 0);
INSERT INTO `reply` VALUES (5, '处理', '2019-07-04 15:04:48', 4, 0, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_phonenumber` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `user_dress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业主地址',
  `user_size` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间大小',
  `user_type` int(11) NULL DEFAULT NULL COMMENT '状态(0.未删除，1.已删除)',
  `user_auth` int(255) NULL DEFAULT NULL COMMENT '权限（1.超级管理员2.管理员3.用户）',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '业主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '陈水凤', '83ac0721fabd9b3fee7abd67ae92b6c0', '13628854623', 'A-01-3001', '200平', 0, 3);
INSERT INTO `user` VALUES (2, '张丽芳', '83ac0721fabd9b3fee7abd67ae92b6c0', '13760523391', 'A-05-2004', '160平', 0, 3);
INSERT INTO `user` VALUES (3, '甄东航', '83ac0721fabd9b3fee7abd67ae92b6c0', '15308645931', 'A-10-3001', '180平', 0, 3);
INSERT INTO `user` VALUES (4, '赵伟', '83ac0721fabd9b3fee7abd67ae92b6c0', '15308081769', 'C-05-3001', '500平', 0, 3);
INSERT INTO `user` VALUES (5, '郑守强', '83ac0721fabd9b3fee7abd67ae92b6c0', '18565135470', 'B-10-1802', '160平', 0, 3);
INSERT INTO `user` VALUES (6, '李维真', '83ac0721fabd9b3fee7abd67ae92b6c0', '15902864529', 'A-03-0102', '120平', 0, 3);
INSERT INTO `user` VALUES (7, '陈东国', '83ac0721fabd9b3fee7abd67ae92b6c0', '16845213659', 'B-30-0509', '130平', 0, 3);
INSERT INTO `user` VALUES (8, '王宝珍', '83ac0721fabd9b3fee7abd67ae92b6c0', '16542351259', 'C-02-0106', '98平', 0, 3);
INSERT INTO `user` VALUES (9, '陈飞', '83ac0721fabd9b3fee7abd67ae92b6c0', '15983019221', 'B-01-1804', '100平', 0, 3);
INSERT INTO `user` VALUES (10, '蒋聪聪', 'b9853c88db11b2c49764d143f24b1ce9', '18718623602', 'A-02-1301', '200平', 0, 3);

-- ----------------------------
-- Procedure structure for access
-- ----------------------------
DROP PROCEDURE IF EXISTS `access`;
delimiter ;;
CREATE PROCEDURE `access`(in page INT(11),in limits INT(11),out rows int(11))
BEGIN
     set @rs=0;
     set @sqls=CONCAT('select * from access order by Access_startdate  desc ',' limit ',limits*(page-1),',',limits);
     set @r=CONCAT('select count(*) into @rs from access');
     PREPARE sql1 from @sqls;
     EXECUTE sql1;
     PREPARE sql2 from @r;
     EXECUTE sql2;
     set rows=@rs;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for admin
-- ----------------------------
DROP PROCEDURE IF EXISTS `admin`;
delimiter ;;
CREATE PROCEDURE `admin`(IN adminStatus int(11),in page INT(11),in limits INT(11),out rows int(11))
BEGIN
     set @rs=0;
     set @sqls=CONCAT(' SELECT * FROM admin WHERE admin_status =', 
    adminStatus,' limit ',limits*(page-1),',',limits);
     set @r=CONCAT('select count(*) into @rs from admin WHERE admin_status =', adminStatus);
     PREPARE sql1 from @sqls;
     EXECUTE sql1;
     PREPARE sql2 from @r;
     EXECUTE sql2;
     set rows=@rs;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for cars
-- ----------------------------
DROP PROCEDURE IF EXISTS `cars`;
delimiter ;;
CREATE PROCEDURE `cars`(in page INT(11),in limits INT(11),out rows int(11))
BEGIN
     set @rs=0;
     set @sqls=CONCAT('select car.Car_id,car.Car_card,car.Car_pid,u.user_name Car_other1,Car_startdate,Car_enddate,u.user_phonenumber ,car.Car_other2  
		 from car car left join user u
     on car.Car_uid = u.user_id order by car.Car_id desc ',' limit ',limits*(page-1),',',limits);
     set @r=CONCAT('select count(*) into @rs from access');
     PREPARE sql1 from @sqls;
     EXECUTE sql1;
     PREPARE sql2 from @r;
     EXECUTE sql2;
     set rows=@rs;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for costccfy
-- ----------------------------
DROP PROCEDURE IF EXISTS `costccfy`;
delimiter ;;
CREATE PROCEDURE `costccfy`(in userName varchar(255),in userPhonenumber varchar(255),in page int,in limits int,out count int)
BEGIN
set @rows=0;
    set @sqls=CONCAT("select * FROM cost,user where cost_uid=user_id  order by cost_date desc  limit ",limits*(page-1),',',limits);
     set @c=CONCAT("select count(*) into @rows FROM cost,user where cost_uid=user_id ");
     if userName is not NULL THEN
     set @sqls=CONCAT("select*from cost,user where cost_uid=user_id and user_name=",userName,"  order by cost_date desc limit ",limits*(page-1),',',limits);
     set @c=CONCAT("select count(*) into @rows from cost,user where cost_uid=user_id and user_name=",userName );
     ELSEIF userPhonenumber is not NULL THEN
      set @sqls=CONCAT("select*from cost,user where cost_uid=user_id and user_phonenumber=",userPhonenumber,"  order by cost_date desc limit ",limits*(page-1),',',limits);
      set @c=CONCAT("select count(*) into @rows from cost,user where cost_uid=user_id and user_phonenumber=",userPhonenumber );
     END IF;
    PREPARE s from @sqls;
    EXECUTE s;
    PREPARE s1 from @c;
    EXECUTE s1;
    set count=@rows;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for costfy
-- ----------------------------
DROP PROCEDURE IF EXISTS `costfy`;
delimiter ;;
CREATE PROCEDURE `costfy`(in userName varchar(255),in userPhonenumber varchar(255),in page int,in limits int,out count int)
BEGIN
set @rows=0;
    set @sqls=CONCAT("select * FROM cost,user where cost_uid=user_id and cost_state=0 order by cost_date desc  limit ",limits*(page-1),',',limits);
     set @c=CONCAT("select count(*) into @rows FROM cost,user where cost_uid=user_id and cost_state=0");
     if userName is not NULL THEN
     set @sqls=CONCAT("select*from cost,user where cost_uid=user_id and user_name=",userName," and cost_state=0 order by cost_date desc limit ",limits*(page-1),',',limits);
     set @c=CONCAT("select count(*) into @rows from cost,user where cost_uid=user_id and user_name=",userName," and cost_state=0" );
     ELSEIF userPhonenumber is not NULL THEN
      set @sqls=CONCAT("select*from cost,user where cost_uid=user_id and user_phonenumber=",userPhonenumber," and cost_state=0 order by cost_date desc limit ",limits*(page-1),',',limits);
      set @c=CONCAT("select count(*) into @rows from cost,user where cost_uid=user_id and user_phonenumber=",userPhonenumber," and cost_state=0" );
     END IF;
    PREPARE s from @sqls;
    EXECUTE s;
    PREPARE s1 from @c;
    EXECUTE s1;
    set count=@rows;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for cuser
-- ----------------------------
DROP PROCEDURE IF EXISTS `cuser`;
delimiter ;;
CREATE PROCEDURE `cuser`(in uid VARCHAR(255),in page INT(11),in limits INT(11),out rowis int)
BEGIN
	 set @rs=0;
     set @sqls=CONCAT('select*from user where user_id = ',uid,' limit ',limits*(page-1),',',limits);
     set @r=CONCAT('select count(*) into @rs from user where user_id = ',uid);
     PREPARE sql1 from @sqls;
     EXECUTE sql1;
     PREPARE sql2 from @r;
     EXECUTE sql2;
     set rowis=@rs;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for fy
-- ----------------------------
DROP PROCEDURE IF EXISTS `fy`;
delimiter ;;
CREATE PROCEDURE `fy`(in tablename VARCHAR(255),in page INT(11),in limits INT(11),out rows int(11))
BEGIN
     set @rs=0;
     set @sqls=CONCAT('select * from ',tablename,' order by ',tablename,'_','date desc ',' limit ',limits*(page-1),',',limits);
     set @r=CONCAT('select count(*) into @rs from ',tablename);
     PREPARE sql1 from @sqls;
     EXECUTE sql1;
     PREPARE sql2 from @r;
     EXECUTE sql2;
     set rows=@rs;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for msg
-- ----------------------------
DROP PROCEDURE IF EXISTS `msg`;
delimiter ;;
CREATE PROCEDURE `msg`(IN msgClass int(11),in page INT(11),in limits INT(11),out rows int(11))
BEGIN
     set @rs=0;
     set @sqls=CONCAT(' SELECT * FROM msg left JOIN msgcount on msg.msg_id = msgcount.msgcount_pid left JOIN `user` u on msgcount.msgcount_uid = u.user_id WHERE msg.msg_class =', 
    msgClass,' order by msg.msg_createtime desc,msg.msg_id desc',' limit ',limits*(page-1),',',limits);
     set @r=CONCAT('select count(*) into @rs from msg left JOIN msgcount on msg.msg_id = msgcount.msgcount_pid left JOIN `user` u on msgcount.msgcount_uid = u.user_id WHERE msg.msg_class =', msgClass);
     PREPARE sql1 from @sqls;
     EXECUTE sql1;
     PREPARE sql2 from @r;
     EXECUTE sql2;
     set rows=@rs;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for msgs
-- ----------------------------
DROP PROCEDURE IF EXISTS `msgs`;
delimiter ;;
CREATE PROCEDURE `msgs`(in page INT(11),in limits INT(11),out rowis int)
BEGIN
	 set @rs=0;
     set @sqls=CONCAT('select*from  msg limit ',limits*(page-1),',',limits);
     set @r=CONCAT('select count(*) into @rs from msg ');
     PREPARE sql1 from @sqls;
     EXECUTE sql1;
     PREPARE sql2 from @r;
     EXECUTE sql2;
     set rowis=@rs;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for myAccountpay
-- ----------------------------
DROP PROCEDURE IF EXISTS `myAccountpay`;
delimiter ;;
CREATE PROCEDURE `myAccountpay`(in uid VARCHAR(255),in page INT(11),in limits INT(11),out rows int(11))
BEGIN
     set @rs=0;
     set @sqls=CONCAT('select*from pay,cost,user where cost_id=pay_costid  and cost_uid=user_id and user_id=',uid,' limit ',limits*(page-1),',',limits);
     set @r=CONCAT('select count(*) into @rs from pay,cost,user where cost_id=pay_costid  and cost_uid=user_id and user_id=',uid);
     PREPARE sql1 from @sqls;
     EXECUTE sql1;
     PREPARE sql2 from @r;
     EXECUTE sql2;
     set rows=@rs;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for noappeal
-- ----------------------------
DROP PROCEDURE IF EXISTS `noappeal`;
delimiter ;;
CREATE PROCEDURE `noappeal`(in uid VARCHAR(255),in page INT(11),in limits INT(11),out rowis int)
BEGIN
	 set @rs=0;
     set @sqls=CONCAT('select*from  appeal where appeal_uid=',uid,' and  appeal_eva=未评价 and appeal_state between 0 and 1 order by  appeal_id DESC limit ',limits*(page-1),',',limits);
     set @r=CONCAT('select count(*) into @rs from appeal where appeal_uid=',uid,' and  appeal_eva=未评价 and appeal_state between 0 and 1 ');
     PREPARE sql1 from @sqls;
     EXECUTE sql1;
     PREPARE sql2 from @r;
     EXECUTE sql2;
     set rowis=@rs;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for norepair
-- ----------------------------
DROP PROCEDURE IF EXISTS `norepair`;
delimiter ;;
CREATE PROCEDURE `norepair`(in uid VARCHAR(255),in page INT(11),in limits INT(11),out rowis int)
BEGIN
	 set @rs=0;
     set @sqls=CONCAT('select*from  repair_uid=',uid,' and  repair_eva=未评价 and repair_state between 0 and 1 order by  repair_id DESC limit ',limits*(page-1),',',limits);
     set @r=CONCAT('select count(*) into @rs from repair where repair_uid=',uid,' and  repair_eva=未评价 and repair_state between 0 and 1 ');
     PREPARE sql1 from @sqls;
     EXECUTE sql1;
     PREPARE sql2 from @r;
     EXECUTE sql2;
     set rowis=@rs;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for onpays
-- ----------------------------
DROP PROCEDURE IF EXISTS `onpays`;
delimiter ;;
CREATE PROCEDURE `onpays`(in uid VARCHAR(255),in page INT(11),in limits INT(11),out rowis int)
BEGIN
	 set @rs=0;
     set @sqls=CONCAT('select*from  cost where cost_uid=',uid ,' and cost_state=0 order by  cost_id DESC limit ',limits*(page-1),',',limits);
     set @r=CONCAT('select count(*) into @rs from cost where cost_uid=',uid ,' and cost_state=0 ');
     PREPARE sql1 from @sqls;
     EXECUTE sql1;
     PREPARE sql2 from @r;
     EXECUTE sql2;
     set rowis=@rs;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pastappeal
-- ----------------------------
DROP PROCEDURE IF EXISTS `pastappeal`;
delimiter ;;
CREATE PROCEDURE `pastappeal`(in uid VARCHAR(255),in page INT(11),in limits INT(11),out rowis int)
BEGIN
	 set @rs=0;
     set @sqls=CONCAT('select*from  appeal where appeal_uid=',uid,' and appeal_state between 2 and 3 order by  appeal_id DESC limit ',limits*(page-1),',',limits);
     set @r=CONCAT('select count(*) into @rs from appeal where appeal_uid=',uid,' and appeal_state between 2 and 3 ');
     PREPARE sql1 from @sqls;
     EXECUTE sql1;
     PREPARE sql2 from @r;
     EXECUTE sql2;
     set rowis=@rs;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pastrepair
-- ----------------------------
DROP PROCEDURE IF EXISTS `pastrepair`;
delimiter ;;
CREATE PROCEDURE `pastrepair`(in uid VARCHAR(255),in page INT(11),in limits INT(11),out rowis int)
BEGIN
	 set @rs=0;
     set @sqls=CONCAT('select*from  repair where repair_uid=',uid,' and repair_state between 2 and 3 order by  repair_id DESC limit ',limits*(page-1),',',limits);
     set @r=CONCAT('select count(*) into @rs from repair where repair_uid=',uid,' and repair_state between 2 and 3 ');
     PREPARE sql1 from @sqls;
     EXECUTE sql1;
     PREPARE sql2 from @r;
     EXECUTE sql2;
     set rowis=@rs;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for payfy
-- ----------------------------
DROP PROCEDURE IF EXISTS `payfy`;
delimiter ;;
CREATE PROCEDURE `payfy`(IN `userName` varchar(255),IN `userPhonenumber` varchar(255),IN `page` int,IN `limits` int,OUT `count` int)
BEGIN
	set @rows=0;
    set @sqls=CONCAT("select * from pay,cost,user where pay_costid=cost_id and cost_uid=user_id order by pay_date desc  limit ",limits*(page-1),',',limits);
     set @c=CONCAT("select count(*) into @rows FROM pay,cost,user where pay_costid=cost_id and cost_uid=user_id");
     if userName is not NULL THEN
     set @sqls=CONCAT("select*from pay,cost,user where pay_costid=cost_id and cost_uid=user_id and user_name=",userName," order by pay_date desc limit ",limits*(page-1),',',limits);
     set @c=CONCAT("select count(*) into @rows from pay,cost,user where pay_costid=cost_id and cost_uid=user_id and user_name=",userName);
     ELSEIF userPhonenumber is not NULL THEN
      set @sqls=CONCAT("select*from pay,cost,user where pay_costid=cost_id and cost_uid=user_id and user_phonenumber=",userPhonenumber," order by pay_date desc limit ",limits*(page-1),',',limits);
      set @c=CONCAT("select count(*) into @rows from pay,cost,user where pay_costid=cost_id and cost_uid=user_id and user_phonenumber=",userPhonenumber );
     END IF;
    PREPARE s from @sqls;
    EXECUTE s;
    PREPARE s1 from @c;
    EXECUTE s1;
    set count=@rows;


END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for userfy
-- ----------------------------
DROP PROCEDURE IF EXISTS `userfy`;
delimiter ;;
CREATE PROCEDURE `userfy`(IN `userName` varchar(255),IN `page` int,IN `limits` int,OUT `count` int)
BEGIN
	  set @rows=0;
    set @sqls=CONCAT("select * FROM user where user_type=0 and user_auth=3 limit ",limits*(page-1),',',limits);
     set @c=CONCAT("select count(*) into @rows FROM user where user_type=0 and user_auth=3");
     if userName is not NULL THEN
     set @sqls=CONCAT("select*from user where user_name=",userName," and user_type=0 and user_auth=3 limit ",limits*(page-1),',',limits);
     set @c=CONCAT("select count(*) into @rows from user where user_name=",userName," and user_type=0 and user_auth=3" );
     END IF;
    PREPARE s from @sqls;
    EXECUTE s;
    PREPARE s1 from @c;
    EXECUTE s1;
    set count=@rows;

END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
