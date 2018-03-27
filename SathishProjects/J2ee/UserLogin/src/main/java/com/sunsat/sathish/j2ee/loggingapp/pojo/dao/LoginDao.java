package com.sunsat.sathish.j2ee.loggingapp.pojo.dao;

import java.util.Date;

/**
 * Created by ssundar2 on 24-02-2017.
 */
public class LoginDao extends AbstractDao {

    private Long userId;
    private Date loggingTime;
    private Date loggoutTime;
    private String status; // Login Or Logout Or Failed
    private String machineName;
    private String ipAddress;
    private String message; //Failed Message

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getLoggingTime() {
        return loggingTime;
    }

    public void setLoggingTime(Date loggingTime) {
        this.loggingTime = loggingTime;
    }

    public Date getLoggoutTime() {
        return loggoutTime;
    }

    public void setLoggoutTime(Date loggoutTime) {
        this.loggoutTime = loggoutTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
