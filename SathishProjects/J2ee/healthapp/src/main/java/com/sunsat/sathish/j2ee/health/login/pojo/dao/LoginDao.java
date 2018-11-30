package com.sunsat.sathish.j2ee.health.login.pojo.dao;

import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.business.BaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;
import com.sunsat.sathish.j2ee.health.login.pojo.business.LoginBusiness;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */
@Entity
@Table(name = "login")
public class LoginDao extends AbstractBaseDao<LoginBusiness> {

    @Id
    @Column(name = "id")
    @GeneratedValue
    Long primaryKeyId;

    @Column(name="user_id")
    @OneToOne
    @JoinColumn(name = "user_id")
    UserDao userDao;

    @Column(name = "login_time")
    Date loginTime;

    @Column(name = "logout_time")
    Date logoutTime;

    @Column(name = "status")
    String status;

    @Override
    public Class getType() {
        return LoginDao.class;
    }

    @Override
    public Long getPrimarykeyId() {
        return primaryKeyId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public String getStatus() {
        return status;
    }

    public void setPrimaryKeyId(Long primaryKeyId) {
        this.primaryKeyId = primaryKeyId;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void setPrimarykeyId(Long primarykeyId) {

    }

    @Override
    public LoginBusiness getBusinessValue() {
        LoginBusiness logBu = new LoginBusiness();
        logBu.setPrimaryKeyId(getPrimarykeyId());
        return logBu;
    }

    @Override
    public void setBusinessValue(LoginBusiness businessValue) {
        this.setPrimaryKeyId(businessValue.getPrimaryKeyId());
    }
}
