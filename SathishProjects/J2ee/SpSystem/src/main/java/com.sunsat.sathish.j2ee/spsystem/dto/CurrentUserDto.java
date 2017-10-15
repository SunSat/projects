package com.sunsat.sathish.j2ee.spsystem.dto;

import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * Created by ssundar2 on 29-03-2017.
 */
@Scope("session")
public class CurrentUserDto {

    int trackingId;
    String userId;
    String isAdmin;
    Date logingTime;
    String name;

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

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getLogingTime() {
        return logingTime;
    }

    public void setLogingTime(Date logingTime) {
        this.logingTime = logingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = userName;
    }
}
