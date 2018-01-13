package com.sunsat.sathish.java.hibernate.model;

/**
 * Created by sathishkumar_su on 12/21/2017.
 CREATE TABLE `purchaseplan` (
 `purchaseplanid` int(11) NOT NULL,
 `meterialid` int(11) DEFAULT NULL,
 `userid` int(11) DEFAULT NULL,
 `buyingoption` varchar(45) DEFAULT NULL,
 `willinggroupid` int(11) DEFAULT NULL,
 PRIMARY KEY (`purchaseplanid`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 */
public class PurchasePlan extends AbstractDaoModel {

}
