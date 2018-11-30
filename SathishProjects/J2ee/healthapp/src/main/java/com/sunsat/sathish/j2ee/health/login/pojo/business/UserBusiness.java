package com.sunsat.sathish.j2ee.health.login.pojo.business;

import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.model.FormModel;

import javax.persistence.Column;
import java.util.Date;

public class UserBusiness extends AbstractBaseBusiness<FormModel> {

    @Override
    public Class getType() {
        return UserBusiness.class;
    }

    private Long primarykeyId;
    private String userName;
    private String password;
    private String passwordHash;
    private Date creationTime;
    private Date expiryTime;
    private String accountStatus;



    @Override
    public Long getPrimarykeyId() {
        return primarykeyId;
    }

    @Override
    public void setPrimarykeyId(Long primarykeyId) {
        this.primarykeyId = primarykeyId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
