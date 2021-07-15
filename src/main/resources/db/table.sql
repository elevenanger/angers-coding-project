DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`(
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modified_date` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `name` varchar(20) NOT NULL COMMENT '用户姓名',
    `mobile_no` varchar(11) NOT NULL COMMENT '用户手机号',
    `sex` TINYINT(1) COMMENT '性别,0:MALE;1:FEMALE',
    `birthday` VARCHAR(8) COMMENT '生日',--TODO 改成精确的日期格式
    `nick_name` varchar(20) NOT NULL COMMENT '用户昵称',
    `password` varchar(255) NOT NULL COMMENT '密码',
    PRIMARY KEY (`id`),
    INDEX idx_user_info_mobile_no (`mobile_no`),
    UNIQUE uk_user_info_nickname (`nick_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='用户信息表';


DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modified_date` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `bucket_name` varchar(255) NOT NULL COMMENT '桶名',
    `file_prefix` varchar(255) NOT NULL COMMENT '文件前缀',
    `origin_name` varchar(255) NOT NULL COMMENT '原文件名',
    `actual_name` varchar(255) NOT NULL COMMENT '上传后文件名',
    `status` varchar(255) NOT NULL COMMENT '状态',
    `url` varchar(255) NOT NULL COMMENT '文件访问地址',
    PRIMARY KEY (`id`),
    INDEX idx_file_info_upload_date (`create_date`),
    INDEX idx_file_info_bucket_name (`bucket_name`),
    UNIQUE uk_file_info_url (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='文件信息表';