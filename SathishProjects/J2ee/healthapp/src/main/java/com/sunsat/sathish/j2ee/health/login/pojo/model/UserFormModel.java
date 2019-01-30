package com.sunsat.sathish.j2ee.health.login.pojo.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sunsat.sathish.j2ee.health.base.pojo.model.FormModel;

import java.util.Date;

public class UserFormModel extends FormModel {

    public UserFormModel() {
        setType(UserFormModel.class);
    }

    private String userId;
    private String userName;
    private String password;
    private String confirmPassword;
    private Bool keepMeSingedIn;
    private String firstName;
    private String lastName;
    private String dob;
    private String mailId;
    private String mobileNo;
    private String loginType;
    private String secreateCode;
    private String accountStatus;
    private Date creationTime;
    private Date expiryTime;
    private String passwordHash;

    public String getUserId() {
        Long primaryKeyId = getPrimarykeyId();
        return userId = primaryKeyId != null ?
                primaryKeyId != 0 ? primaryKeyId+"" : ""
                : "" ;
    }

    public void setUserId(String userId) {
        setPrimarykeyId(Long.parseLong(userId));
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Bool getKeepMeSingedIn() {
        return keepMeSingedIn;
    }

    public void setKeepMeSingedIn(Bool keepMeSingedIn) {
        this.keepMeSingedIn = keepMeSingedIn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getSecreateCode() {
        return secreateCode;
    }

    public void setSecreateCode(String secreateCode) {
        this.secreateCode = secreateCode;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
