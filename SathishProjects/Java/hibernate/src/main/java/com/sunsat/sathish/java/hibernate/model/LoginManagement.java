package com.sunsat.sathish.java.hibernate.model;

import java.util.Date;

/**
 * Created by sathishkumar_su on 12/21/2017.
 *
 CREATE TABLE `loginmanagement` (
 `loginid` int(11) NOT NULL,
 `userid` int(11) NOT NULL,
 `logintime` datetime DEFAULT NULL,
 `logouttime` datetime DEFAULT NULL,
 `status` varchar(25) DEFAULT NULL,
 PRIMARY KEY (`loginid`),
 KEY `personaldetailTologinmanagement_idx` (`userid`),
 CONSTRAINT `personaldetailTologinmanagement` FOREIGN KEY (`userid`) REFERENCES `personaldetail` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE

 */
public class LoginManagement extends AbstractDaoModel {

    private int userId;
    private Date logingTime;
    private Date logoutTime;
    private String status;
    private String message;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getLogingTime() {
        return logingTime;
    }

    public void setLogingTime(Date logingTime) {
        this.logingTime = logingTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
