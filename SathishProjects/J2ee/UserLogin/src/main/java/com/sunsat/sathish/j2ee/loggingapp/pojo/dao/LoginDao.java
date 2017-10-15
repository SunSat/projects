package com.sunsat.sathish.j2ee.loggingapp.pojo.dao;

import java.util.Date;

/**
 * Created by ssundar2 on 24-02-2017.
 */
public class LoginDao {

    private int id;
    private Date loggingTime;
    private Date loggoutTime;
    private String status;
    private String machineName;
    private String ipAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginDao)) return false;

        LoginDao loginPojo = (LoginDao) o;

        if (getId() != loginPojo.getId()) return false;
        if (getLoggingTime() != null ? !getLoggingTime().equals(loginPojo.getLoggingTime()) : loginPojo.getLoggingTime() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(loginPojo.getStatus()) : loginPojo.getStatus() != null)
            return false;
        if (getMachineName() != null ? !getMachineName().equals(loginPojo.getMachineName()) : loginPojo.getMachineName() != null)
            return false;
        return !(getIpAddress() != null ? !getIpAddress().equals(loginPojo.getIpAddress()) : loginPojo.getIpAddress() != null);

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getLoggingTime() != null ? getLoggingTime().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getMachineName() != null ? getMachineName().hashCode() : 0);
        result = 31 * result + (getIpAddress() != null ? getIpAddress().hashCode() : 0);
        return result;
    }
}
