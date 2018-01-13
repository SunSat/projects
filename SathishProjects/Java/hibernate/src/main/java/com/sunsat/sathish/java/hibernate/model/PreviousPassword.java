package com.sunsat.sathish.java.hibernate.model;

import java.util.Date;

/**
 * Created by sathishkumar_su on 12/21/2017.
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

 */
public class PreviousPassword extends AbstractDaoModel {
    private int userId;
    private String previousUserName;
    private String previousPassword;
    private Date passwordCreationDate;
    private Date passwordExpiryDate;
}
