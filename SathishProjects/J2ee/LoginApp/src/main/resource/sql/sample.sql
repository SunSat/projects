CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `mailid` varchar(60) NOT NULL,
  `mobile` varchar(12) DEFAULT NULL,
  `dob` varchar(25) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `isblocked` tinyint(4) DEFAULT NULL,
  `failureattemptcount` tinyint(4) DEFAULT NULL,
  `message` varchar(100) DEFAULT NULL,
  `createdby` varchar(50) DEFAULT NULL,
  `createddt` date DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  `modifieddt` date DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_user_id_uindex` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `logintime` varchar(45) DEFAULT NULL,
  `logouttime` varchar(45) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`login_id`),
  KEY `login_to_username_id_idx` (`user_id`),
  CONSTRAINT `login_to_user_table_user_id` FOREIGN KEY (`login_id`) REFERENCES u_user (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
