package com.sunsat.sathish.j2ee.health.login.pojo.model;

import com.sunsat.sathish.j2ee.health.base.pojo.model.FormModel;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.Date;

public class UserFormModel extends FormModel {

    private String userName;
    private String password;
    private String confirmPassword;
    private Boolean keepMeSingedIn;
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
    private String userId;
    private boolean isAdmin;
    private String userLike;
    private Long userLikeCount;

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

    public Boolean getKeepMeSingedIn() {
        return keepMeSingedIn;
    }

    public void setKeepMeSingedIn(Boolean keepMeSingedIn) {
        this.keepMeSingedIn = keepMeSingedIn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUserLike() {
        return userLike;
    }

    public void setUserLike(String userLike) {
        this.userLike = userLike;
    }

    public Long getUserLikeCount() {
        return userLikeCount;
    }

    public void setUserLikeCount(Long userLikeCount) {
        this.userLikeCount = userLikeCount;
    }
}
