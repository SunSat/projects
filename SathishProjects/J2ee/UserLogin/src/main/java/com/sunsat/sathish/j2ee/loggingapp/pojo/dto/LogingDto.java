package com.sunsat.sathish.j2ee.loggingapp.pojo.dto;

import java.util.Date;

/**
 * Created by ssundar2 on 27-02-2017.
 */
public class LogingDto {

    private int id;
    private Date loggingTime;
    private Date loggoutTime;
    private String status;
    private String machine;
    private String ipAddr;

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

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

}
