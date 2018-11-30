/*create database health;

CREATE TABLE `health`.`user` (
  `userid` bigint(10) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `creationdate` varchar(45) DEFAULT NULL,
  `expirydate` varchar(45) DEFAULT NULL,
  `userstatus` varchar(10) DEFAULT NULL,
  `accountstatus` varchar(10) DEFAULT NULL,
  `isdeleted` char(1) DEFAULT NULL,
  `isAdmin` char(1) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `personalid_UNIQUE` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `health`.`login` (
  `loginid` BIGINT(10) NOT NULL,
  `userid` BIGINT(10) NULL,
  `status` VARCHAR(10) NULL,
  `logintime` VARCHAR(20) NULL,
  `logouttime` VARCHAR(20) NULL,
  `message` VARCHAR(100) NULL,
  PRIMARY KEY (`loginid`));

CREATE TABLE `health`.`oldpassword` (
  `oldpasswordid` BIGINT(10) NOT NULL,
  `userid` BIGINT(10) NULL,
  `oldpassword` VARCHAR(45) NULL,
  `creationdate` VARCHAR(45) NULL,
  `expirydate` VARCHAR(45) NULL,
  `message` VARCHAR(100) NULL,
  PRIMARY KEY (`oldpasswordid`));

CREATE TABLE `health`.`loginatempt` (
  `id` BIGINT(10) NOT NULL,
  `userid` BIGINT(10) NULL,
  `count` INT NULL,
  `message` VARCHAR(100) NULL,
  `attempttime` VARCHAR(20) NULL,
  PRIMARY KEY (`id`));
*/

CREATE TABLE `user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `password_hash` varchar(500) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `expiry_time` datetime DEFAULT NULL,
  `account_status` varchar(20) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(10) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `login` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(10) NOT NULL,
  `login_time` varchar(30) DEFAULT NULL,
  `logout_time` varchar(30) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `created_by` bigint(10) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `modified_by` bigint(10) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_id_uindex` (`user_id`),
  CONSTRAINT `login_to_user_fk` FOREIGN KEY (`user_id`) REFERENCES u_user (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `communication` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(10) NOT NULL,
  `mob1` varchar(15) DEFAULT NULL,
  `is_mob1_verified` tinyint(1) DEFAULT NULL,
  `mob1_cnf_token` int(11) DEFAULT NULL,
  `mob1_cnf_token_expiry_date` datetime DEFAULT NULL,
  `email1` varchar(50) DEFAULT NULL,
  `is_email1_verified` tinyint(1) DEFAULT NULL,
  `email1_cnf_token` int(11) DEFAULT NULL,
  `email1_cnf_token_expiry_date` datetime DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `created_by` mediumtext,
  `modified_date` date DEFAULT NULL,
  `modified_by` mediumtext,
  `deleted` tinyint(1) DEFAULT NULL,
  `message` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `communication_id_uindex` (`user_id`),
  CONSTRAINT `communication_To_user_fk` FOREIGN KEY (`user_id`) REFERENCES u_user (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `loginsource` (
  `id` bigint(10) NOT NULL,
  `userid` bigint(10) DEFAULT NULL,
  `source` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `loginSource_To_UserId_idx` (`userid`),
  CONSTRAINT `loginSource_To_UserId` FOREIGN KEY (`userid`) REFERENCES u_user (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `oldpassword` (
  `id` bigint(10) NOT NULL,
  `user_id` bigint(10) DEFAULT NULL,
  `old_password` varchar(500) DEFAULT NULL,
  `old_password_hash` varchar(500) DEFAULT NULL,
  `creation_time` varchar(30) DEFAULT NULL,
  `expiry_time` varchar(30) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oldpassword_user_id_to_User_User_id_idx` (`user_id`),
  CONSTRAINT `oldpassword_user_id_to_User_User_id` FOREIGN KEY (`user_id`) REFERENCES u_user (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8

