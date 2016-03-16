USE newsfeed;
DROP TABLE IF EXISTS `internet_feed`;
CREATE TABLE `internet_feed` (
  `id` int(11) NOT NULL,
  `headline` varchar(200) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='internet feed table';

DROP TABLE IF EXISTS `news_feed`;
CREATE TABLE `news_feed` (
  `id` int(11) NOT NULL,
  `headline` varchar(200) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='newspaper feed table';

DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `id_seq` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='THis table used to get the current ongoing sequence of the feed insertions.';

DROP TABLE IF EXISTS `twitter_feed`;
CREATE TABLE `twitter_feed` (
  `id` int(11) NOT NULL,
  `headline` varchar(200) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='twitter feed table';

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `contact_number` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 NOT NULL,
  `role` tinyint(1) NOT NULL DEFAULT '0',
  `department` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
