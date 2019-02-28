package com.sunsat.sathish.j2ee.health.login.pojo.business;

import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;

import java.util.Date;
import java.util.List;

public class UserBusiness extends AbstractBaseBusiness<UserFormModel> {

    @Override
    public Class getType() {
        return UserBusiness.class;
    }

    private Long primaryKeyId;
    private String userName;
    private String password;
    private String passwordHash;
    private Date creationTime;
    private Date expiryTime;
    private String accountStatus;
    private CommunicationBusiness comBusiness;
    private LoginBusiness loginBusiness;
    private PersonalDetailBusiness personalDetailBusiness;
    private List<RoleBusiness> roleBusinesses;
    private String userLike;

    @Override
    public Long getPrimaryKeyId() {
        return primaryKeyId;
    }

    public void setPrimaryKeyId(Long primarykeyId) {
        this.primaryKeyId = primarykeyId;
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

    public CommunicationBusiness getComBusiness() {
        return comBusiness;
    }

    public void setComBusiness(CommunicationBusiness comBusiness) {
        this.comBusiness = comBusiness;
    }

    public LoginBusiness getLoginBusiness() {
        return loginBusiness;
    }

    public void setLoginBusiness(LoginBusiness loginBusiness) {
        this.loginBusiness = loginBusiness;
    }

    public PersonalDetailBusiness getPersonalDetailBusiness() {
        return personalDetailBusiness;
    }

    public void setPersonalDetailBusiness(PersonalDetailBusiness personalDetailBusiness) {
        this.personalDetailBusiness = personalDetailBusiness;
    }

    public List<RoleBusiness> getRoleBusinesses() {
        return roleBusinesses;
    }

    public void setRoleBusinesses(List<RoleBusiness> roleBusinesses) {
        this.roleBusinesses = roleBusinesses;
    }

    public String isUserLike() {
        return userLike;
    }

    public void setUserLike(String userLike) {
        this.userLike = userLike;
    }

    @Override
    public void populateData(UserFormModel userFormModel) {
        this.setPrimaryKeyId(userFormModel.getPrimarykeyId());
        this.setUserName(userFormModel.getUserName());
        this.setPassword(userFormModel.getPassword());
        this.setAccountStatus(userFormModel.getAccountStatus());
        this.setExpiryTime(userFormModel.getExpiryTime());
        this.setCreationTime(userFormModel.getCreationTime());
        this.setPasswordHash(userFormModel.getPasswordHash());
        this.setUserLike(userFormModel.getUserLike());
/*
        CommunicationBusiness comBusiness = new CommunicationBusiness();
        comBusiness.setEmail1(userFormModel.getMailId());
        comBusiness.setMobile1(userFormModel.getMobileNo());
        comBusiness.setUserBusiness(this);
        this.setComBusiness(comBusiness);
*/
        super.populateData(userFormModel);
    }

    @Override
    public void getData(UserFormModel model) {
        model.setUserName(this.getUserName());
        model.setPrimarykeyId(this.getPrimaryKeyId());
        model.setAccountStatus(this.getAccountStatus());
        model.setExpiryTime(this.getExpiryTime());
        model.setCreationTime(this.getCreationTime());
        model.setUserLike(this.isUserLike());
        super.getData(model);
    }
}
