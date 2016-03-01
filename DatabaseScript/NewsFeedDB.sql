USE newsfeed;
DROP TABLE IF EXISTS `internet_feed`;
CREATE TABLE `internet_feed` (
  `id` int(11) NOT NULL,
  `headline` varchar(200) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='internet feed table';
INSERT INTO `internet_feed` VALUES (3,'Roger Federer defeats Nadal',3),(103,'Indiana Hoosiers Win the Football Championship in Bloomington',3),(107,'Tony Stark the movie character set to launch another sequel of Iron Man Movies',2),(110,'Tata Motors acquires Jaguar from GM',1),(111,'Bollywood movies to be shooted in Universal Studios from now',2);
DROP TABLE IF EXISTS `news_feed`;
CREATE TABLE `news_feed` (
  `id` int(11) NOT NULL,
  `headline` varchar(200) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='newspaper feed table';
INSERT INTO `news_feed` VALUES (3,'Roger Federer defeats Nadal',3),(103,'Indiana Hoosiers Win the Football Championship in Bloomington',3),(107,'Tony Stark the movie character set to launch another sequel of Iron Man Movies',2),(110,'Tata Motors acquires Jaguar from GM',1),(111,'Bollywood movies to be shooted in Universal Studios from now',2);
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `id_seq` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='THis table used to get the current ongoing sequence of the feed insertions.';
INSERT INTO `sequence` VALUES (113);
DROP TABLE IF EXISTS `twitter_feed`;
CREATE TABLE `twitter_feed` (
  `id` int(11) NOT NULL,
  `headline` varchar(200) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='twitter feed table';
INSERT INTO `twitter_feed` VALUES (3,'Roger Federer defeats Nadal',3),(103,'Indiana Hoosiers Win the Football Championship in Bloomington',3),(107,'Tony Stark the movie character set to launch another sequel of Iron Man Movies',2),(110,'Tata Motors acquires Jaguar from GM',1),(111,'Bollywood movies to be shooted in Universal Studios from now',2);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
INSERT INTO `user` VALUES (1,'super','user','1111111111','su@su.com','root',2,NULL),(2,'Medha','Gokhale','1234567890','medhahg@gmail.com','medhahg',0,NULL),(9,'Vivek','Supe','8123697654','vsupe@umail.iu.edu','Milind1@',1,1),(11,'Medha','Gokhale','3333333333','medhahg@gmail.com','Milind1@',1,3),(12,'Milind','Gokhale','9898989898','mgokhale@indiana.edu','Milind1@',1,2),(13,'Abhishek','Rakshe','2323232323','abhi@abhi.com','Milind1@',0,0),(14,'Diana','Ciric','3313232323','diana.ciric@gmail.com','Milind1@',1,2),(15,'Vishal','Pradhan','4343434343','vp@vp.com','Milind1@',0,0);
