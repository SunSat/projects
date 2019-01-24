package com.sunsat.sathish.j2ee.health.login.pojo.business;

import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;

import java.util.Date;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */
public class LoginBusiness extends AbstractBaseBusiness<UserFormModel> {

    private Long primaryKeyId;
    private Date loginTime;
    private Date logoutTime;
    private String status;

    @Override
    public Class getType() {
        return LoginBusiness.class;
    }

    public Long getPrimaryKeyId() {
        return primaryKeyId;
    }

    public void setPrimaryKeyId(Long primaryKeyId) {
        this.primaryKeyId = primaryKeyId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
