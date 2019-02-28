package com.sunsat.sathish.j2ee.health.login.pojo.business;

import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;
import com.sunsat.sathish.j2ee.health.base.pojo.model.FormModel;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;

import java.util.Date;

public class CommunicationBusiness extends AbstractBaseBusiness<UserFormModel> {

    private Long primaryKeyId;
    private UserBusiness userBusiness;
    private String mobile1;
    private boolean isMobile1Verified;
    private Integer mobile1CnfToken;
    private Date mobile1CnfTokenExpiryDate;
    private String email1;
    private boolean isEmail1Verified;
    private Integer email1CnfToken;
    private Date email1CnfTokenExpiryDate;

    @Override
    public Class getType() {
        return CommunicationBusiness.class;
    }


    @Override
    public Long getPrimaryKeyId() {
        return primaryKeyId;
    }

    public void setPrimaryKeyId(Long primaryKeyId) {
        this.primaryKeyId = primaryKeyId;
    }

    public UserBusiness getUserBusiness() {
        return userBusiness;
    }

    public void setUserBusiness(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public boolean isMobile1Verified() {
        return isMobile1Verified;
    }

    public void setMobile1Verified(boolean mobile1Verified) {
        isMobile1Verified = mobile1Verified;
    }

    public Integer getMobile1CnfToken() {
        return mobile1CnfToken;
    }

    public void setMobile1CnfToken(Integer mobile1CnfToken) {
        this.mobile1CnfToken = mobile1CnfToken;
    }

    public Date getMobile1CnfTokenExpiryDate() {
        return mobile1CnfTokenExpiryDate;
    }

    public void setMobile1CnfTokenExpiryDate(Date mobile1CnfTokenExpiryDate) {
        this.mobile1CnfTokenExpiryDate = mobile1CnfTokenExpiryDate;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public boolean isEmail1Verified() {
        return isEmail1Verified;
    }

    public void setEmail1Verified(boolean email1Verified) {
        isEmail1Verified = email1Verified;
    }

    public Integer getEmail1CnfToken() {
        return email1CnfToken;
    }

    public void setEmail1CnfToken(Integer email1CnfToken) {
        this.email1CnfToken = email1CnfToken;
    }

    public Date getEmail1CnfTokenExpiryDate() {
        return email1CnfTokenExpiryDate;
    }

    public void setEmail1CnfTokenExpiryDate(Date email1CnfTokenExpiryDate) {
        this.email1CnfTokenExpiryDate = email1CnfTokenExpiryDate;
    }

    @Override
    public void populateData(UserFormModel userFormModel) {
        this.setMobile1(userFormModel.getMobileNo());
        this.setEmail1(userFormModel.getMailId());
        super.populateData(userFormModel);
    }

    @Override
    public void getData(UserFormModel userFormModel) {
        super.getData(userFormModel);
    }
}
