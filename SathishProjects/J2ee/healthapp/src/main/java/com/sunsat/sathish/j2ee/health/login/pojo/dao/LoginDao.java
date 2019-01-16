package com.sunsat.sathish.j2ee.health.login.pojo.dao;

import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.business.BaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;
import com.sunsat.sathish.j2ee.health.login.pojo.business.LoginBusiness;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */
// @Entity
@Table(name = "login")
public class LoginDao extends AbstractBaseDao<LoginBusiness, BaseDataFilter> {

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
    public LoginBusiness getBusinessValue(BaseDataFilter df) {
        LoginBusiness logBu = new LoginBusiness();
        logBu.setPrimaryKeyId(getPrimarykeyId());
        return logBu;
    }

    @Override
    public void setBusinessValue(LoginBusiness businessValue) {
        this.setPrimarykeyId(businessValue.getPrimaryKeyId());
    }

    @Override
    public void setPrimarykeyId(Long primarykeyId) {

    }
    @Column(name = "created_by")
    private Long createdById;

    @Column(name = "modified_by")
    private Long modifiedById;

    @Column(name = "created_date")
    private Date createdByDate;

    @Column(name = "modified_date")
    private Date modifiedByDate;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "message")
    private String message;

    @Override
    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    @Override
    public Long getModifiedById() {
        return modifiedById;
    }

    public void setModifiedById(Long modifiedById) {
        this.modifiedById = modifiedById;
    }

    @Override
    public Date getCreatedByDate() {
        return createdByDate;
    }

    public void setCreatedByDate(Date createdByDate) {
        this.createdByDate = createdByDate;
    }

    @Override
    public Date getModifiedByDate() {
        return modifiedByDate;
    }

    public void setModifiedByDate(Date modifiedByDate) {
        this.modifiedByDate = modifiedByDate;
    }

    @Override
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public void setIsDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
