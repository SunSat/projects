package com.sunsat.sathish.java.hibernate.model;

/**
 * Created by sathishkumar_su on 12/21/2017.
 * CREATE TABLE `controllergroupdetail` (
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

 */
public class ControllerGroupDetail extends AbstractDaoModel {

    String groupName;
    String controllerId;
    String controllerPassword;
    //Set<>


}
