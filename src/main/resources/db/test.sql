-----------------
----用户信息表
------------------
DROP TABLE IF EXISTS  `personal_user`;
CREATE TABLE `personal_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `username` varchar(255) DEFAULT NULL COMMENT 'username',
  `cellphone` varchar(255) DEFAULT NULL COMMENT '手机',
  `nickname` varchar(255) DEFAULT NULL COMMENT 'nickname',
  `is_delete` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `access_token` varchar(255) DEFAULT NULL COMMENT '访问token',
  `access_expired_time` datetime DEFAULT NULL COMMENT '过期时间',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `phone_systems` varchar(50) DEFAULT NULL COMMENT '手机系统',
  `phone_model` varchar(50) DEFAULT NULL COMMENT '手机型号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
