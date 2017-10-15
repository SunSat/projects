package com.sunsat.sathish.j2ee.spsystem.dto;

import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * Created by ssundar2 on 28-03-2017.
 */

@Scope("prototype")
public class UserDto {

    private int trackingId;
    private String userId  = "";
    private String name = "" ;
    private String password = "" ;
    private Date dateofbirth;
    private String gender;
    private String mobile;
    private String isAdmin = "";
    private String address;
    private Date dateofjoin;
    private Date dateofleave;
    private String status = "";

    public int getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(int trackingId) {
        this.trackingId = trackingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateofjoin() {
        return dateofjoin;
    }

    public void setDateofjoin(Date dateofjoin) {
        this.dateofjoin = dateofjoin;
    }

    public Date getDateofleave() {
        return dateofleave;
    }

    public void setDateofleave(Date dateofleave) {
        this.dateofleave = dateofleave;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "trackingId=" + trackingId +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", gender='" + gender + '\'' +
                ", mobile='" + mobile + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                ", address='" + address + '\'' +
                ", dateofjoin=" + dateofjoin +
                ", dateofleave=" + dateofleave +
                ", status='" + status + '\'' +
                '}';
    }
}
