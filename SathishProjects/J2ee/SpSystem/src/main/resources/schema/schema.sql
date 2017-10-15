CREATE SCHEMA `spsystems` ;

CREATE TABLE `barcodetracker` (
  `trackingid` int(11) DEFAULT NULL,
  `barcodeid` varchar(20) DEFAULT NULL,
  `type` varchar(5) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `isrejected` varchar(5) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `message` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `login` (
  `trackingid` int(11) NOT NULL,
  `logingtime` datetime DEFAULT NULL,
  `logouttime` datetime DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`trackingid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `trackingid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `dateofbirth` date DEFAULT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `isadmin` varchar(5) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `dateofjoin` date DEFAULT NULL,
  `dateofleave` date DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`trackingid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
