-- 品牌信息
CREATE TABLE IF NOT EXISTS `pms_brand` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`first_letter` varchar(1) DEFAULT NULL COMMENT '首字母',
	`sort` tinyint(6) DEFAULT NULL COMMENT '排序',
	`factory_status` tinyint(1) DEFAULT '0' COMMENT '是否为品牌制造商：0->不是；1->是',
	`show_status` tinyint(1) DEFAULT '1' COMMENT '是否展示：0->不是；1->是',
	`product_count` bigint(10) DEFAULT '0' COMMENT '库存',
	`product_comment_count` bigint(10) DEFAULT '0' COMMENT '产品评论数',
	`logo` varchar(256) DEFAULT NULL COMMENT '品牌logo',
	`big_pic` varchar(256) DEFAULT NULL COMMENT '专区大图',
	`brand_story` text DEFAULT NULL COMMENT '品牌故事',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;