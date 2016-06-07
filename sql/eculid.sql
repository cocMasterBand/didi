CREATE TABLE `didi_euclid` (
	`id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
	`date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '日期',
	`time_piece` int(11) NOT NULL COMMENT '时间片, 从0, 到1440',
	`start_id` int(11) NOT NULL DEFAULT '-1' COMMENT '起点区域id',
	`start_hash` varchar(128) NOT NULL DEFAULT '' COMMENT '起点hash',
	`weather` int(11) NOT NULL DEFAULT '0' COMMENT '天气指数',
	`PM` int(11) NOT NULL DEFAULT '0' COMMENT 'pm2.5指数',
	`temperature` tinyint(4) NOT NULL DEFAULT '0' COMMENT '温度',
	`poi_class` varchar(4096) NOT NULL DEFAULT '' COMMENT '地理特征',
	`tj_level` int(11) NOT NULL DEFAULT '0' COMMENT '拥堵程度',
	`euclid_value` double NOT NULL DEFAULT '0' COMMENT '欧几里得距离值',
	`request` int(11) NOT NULL DEFAULT '0' COMMENT '呼叫总数',
	`response` int(11) NOT NULL DEFAULT '0' COMMENT '相应总数',
	PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
