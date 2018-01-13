CREATE DATABASE  IF NOT EXISTS `kindle_controller_app` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `kindle_controller_app`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: kindle_controller_app
-- ------------------------------------------------------
-- Server version	5.6.38-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `authorid` int(11) NOT NULL,
  `authorname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`authorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `balancedetail`
--

DROP TABLE IF EXISTS `balancedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `balancedetail` (
  `balanceid` int(11) NOT NULL,
  `groupid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `amountpaid` varchar(10) DEFAULT NULL,
  `amountpaiddate` date DEFAULT NULL,
  `amountreturned` varchar(10) DEFAULT NULL,
  `amountreturneddate` date DEFAULT NULL,
  `currentbalance` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`balanceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `categoryid` int(11) NOT NULL,
  `categorytitle` varchar(45) DEFAULT NULL,
  `parentcategoryid` int(11) NOT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `controllergroupdetail`
--

DROP TABLE IF EXISTS `controllergroupdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controllergroupdetail` (
  `groupid` int(11) NOT NULL,
  `groupname` varchar(45) DEFAULT NULL,
  `controllerid` varchar(60) DEFAULT NULL,
  `controllerpassword` varchar(200),
  `meterialids` text,
  `userids` text,
  `sharedamount` varchar(10) DEFAULT NULL,
  `memberscount` int(11) DEFAULT NULL,
  PRIMARY KEY (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `loginmanagement`
--

DROP TABLE IF EXISTS `loginmanagement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loginmanagement` (
  `loginid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `logintime` datetime DEFAULT NULL,
  `logouttime` datetime DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`loginid`),
  KEY `personaldetailTologinmanagement_idx` (`userid`),
  CONSTRAINT `personaldetailTologinmanagement` FOREIGN KEY (`userid`) REFERENCES `personaldetail` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `meterialmanagement`
--

DROP TABLE IF EXISTS `meterialmanagement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meterialmanagement` (
  `meterialid` int(11) NOT NULL,
  `title` varchar(500) DEFAULT NULL,
  `authorids` text,
  `edition` varchar(15) DEFAULT NULL,
  `isbnnumber` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `categoryids` text,
  `meterialtype` varchar(15) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`meterialid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `personaldetail`
--

DROP TABLE IF EXISTS `personaldetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personaldetail` (
  `userid` int(11) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `address1` varchar(150) DEFAULT NULL,
  `address2` varchar(150) DEFAULT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `previouspasswords`
--

DROP TABLE IF EXISTS `previouspasswords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `previouspasswords` (
  `previouspasswordid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `previoususername` varchar(45) DEFAULT NULL,
  `previouspassword` varchar(45) DEFAULT NULL,
  `passwordcreationtime` datetime DEFAULT NULL,
  `passwordexpirytime` datetime DEFAULT NULL,
  KEY `personaldetailTopreviouspassword` (`userid`),
  CONSTRAINT `personaldetailTopreviouspassword` FOREIGN KEY (`userid`) REFERENCES `personaldetail` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `purchaseplan`
--

DROP TABLE IF EXISTS `purchaseplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseplan` (
  `purchaseplanid` int(11) NOT NULL,
  `meterialid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `buyingoption` varchar(45) DEFAULT NULL,
  `willinggroupid` int(11) DEFAULT NULL,
  PRIMARY KEY (`purchaseplanid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usernamemanagement`
--

DROP TABLE IF EXISTS `usernamemanagement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usernamemanagement` (
  `userid` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `passwordcreationdate` datetime DEFAULT NULL,
  `passwordexpirydate` datetime DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  CONSTRAINT `personaldetailToUsernamemgmt` FOREIGN KEY (`userid`) REFERENCES `personaldetail` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `voting`
--

DROP TABLE IF EXISTS `voting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voting` (
  `votingid` int(11) NOT NULL,
  `meterialid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `comments` varchar(100) DEFAULT NULL,
  `starrating` int(1) DEFAULT NULL,
  PRIMARY KEY (`votingid`),
  KEY `meterialTovoting` (`meterialid`),
  CONSTRAINT `meterialTovoting` FOREIGN KEY (`meterialid`) REFERENCES `meterialmanagement` (`meterialid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'kindle_controller_app'
--

--
-- Dumping routines for database 'kindle_controller_app'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-20 22:52:33
CREATE DATABASE  IF NOT EXISTS `kindle_controller_app` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `kindle_controller_app`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: kindle_controller_app
-- ------------------------------------------------------
-- Server version	5.6.38-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `authorid` int(11) NOT NULL,
  `authorname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`authorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `balancedetail`
--

DROP TABLE IF EXISTS `balancedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `balancedetail` (
  `balanceid` int(11) NOT NULL,
  `groupid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `amountpaid` varchar(10) DEFAULT NULL,
  `amountpaiddate` date DEFAULT NULL,
  `amountreturned` varchar(10) DEFAULT NULL,
  `amountreturneddate` date DEFAULT NULL,
  `currentbalance` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`balanceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `categoryid` int(11) NOT NULL,
  `parentcategoryid` int(11) NOT NULL,
  `categorytitle` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `controllergroupdetail`
--

DROP TABLE IF EXISTS `controllergroupdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controllergroupdetail` (
  `groupid` int(11) NOT NULL,
  `groupname` varchar(45) DEFAULT NULL,
  `controllerid` varchar(60) DEFAULT NULL,
  `controllerpassword` varchar(200),
  `meterialids` text,
  `userids` text,
  `sharedamount` varchar(10) DEFAULT NULL,
  `memberscount` int(11) DEFAULT NULL,
  PRIMARY KEY (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `loginmanagement`
--

DROP TABLE IF EXISTS `loginmanagement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loginmanagement` (
  `loginid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `logintime` datetime DEFAULT NULL,
  `logouttime` datetime DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `message` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`loginid`),
  KEY `personaldetailTologinmanagement_idx` (`userid`),
  CONSTRAINT `personaldetailTologinmanagement` FOREIGN KEY (`userid`) REFERENCES `personaldetail` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `meterialmanagement`
--

DROP TABLE IF EXISTS `meterialmanagement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meterialmanagement` (
  `meterialid` int(11) NOT NULL,
  `title` varchar(500) DEFAULT NULL,
  `authorids` text,
  `edition` varchar(15) DEFAULT NULL,
  `isbnnumber` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `categoryids` text,
  `meterialtype` varchar(15) DEFAULT NULL,
  `status` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`meterialid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `personaldetail`
--

DROP TABLE IF EXISTS `personaldetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personaldetail` (
  `userid` int(11) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `address1` varchar(150) DEFAULT NULL,
  `address2` varchar(150) DEFAULT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `previouspasswords`
--

DROP TABLE IF EXISTS `previouspasswords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `previouspasswords` (
  `previouspasswordid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `previoususername` varchar(45) DEFAULT NULL,
  `previouspassword` varchar(45) DEFAULT NULL,
  `passwordcreationdate` datetime DEFAULT NULL,
  `passwordexpirydate` datetime DEFAULT NULL,
  `message` VARCHAR(45) DEFAULT NULL,
  KEY `personaldetailTopreviouspassword` (`userid`),
  CONSTRAINT `personaldetailTopreviouspassword` FOREIGN KEY (`userid`) REFERENCES `personaldetail` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `purchaseplan`
--

DROP TABLE IF EXISTS `purchaseplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseplan` (
  `purchaseplanid` int(11) NOT NULL,
  `meterialid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `buyingoption` varchar(45) DEFAULT NULL,
  `willinggroupid` int(11) DEFAULT NULL,
  PRIMARY KEY (`purchaseplanid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usernamemanagement`
--

DROP TABLE IF EXISTS `usernamemanagement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usernamemanagement` (
  `userid` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `passwordcreationdate` datetime DEFAULT NULL,
  `passwordexpirydate` datetime DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  CONSTRAINT `personaldetailToUsernamemgmt` FOREIGN KEY (`userid`) REFERENCES `personaldetail` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `voting`
--

DROP TABLE IF EXISTS `voting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voting` (
  `votingid` int(11) NOT NULL,
  `meterialid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `comments` varchar(100) DEFAULT NULL,
  `starrating` int(1) DEFAULT NULL,
  PRIMARY KEY (`votingid`),
  KEY `meterialTovoting` (`meterialid`),
  CONSTRAINT `meterialTovoting` FOREIGN KEY (`meterialid`) REFERENCES `meterialmanagement` (`meterialid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'kindle_controller_app'
--

--
-- Dumping routines for database 'kindle_controller_app'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-20 22:52:33
