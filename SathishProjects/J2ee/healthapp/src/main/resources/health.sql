create database health;

CREATE TABLE `user` (
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