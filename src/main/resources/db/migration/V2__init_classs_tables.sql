CREATE TABLE `classs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) DEFAULT NULL COMMENT '班级名称',
  `class_code` varchar(255) DEFAULT NULL COMMENT '班级code',
  `class_level` varchar(255) DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
