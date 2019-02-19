package com.sunsat.sathish.j2ee.health.login.pojo.dao;

import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;
import com.sunsat.sathish.j2ee.health.login.persistor.LoginGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.login.persistor.UserPersistanceManager;
import com.sunsat.sathish.j2ee.health.login.pojo.business.LoginBusiness;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */
@Table(name = "login")
@Entity
public class LoginDao extends AbstractBaseDao<LoginBusiness, BaseDataFilter> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long primaryKeyId;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
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
    public Long getPrimaryKeyId() {
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

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public LoginBusiness getBusinessValue(BaseDataFilter df, LoginBusiness logbusiness, List<Class> parentClasses) {
        if(null == logbusiness) logbusiness = new LoginBusiness();
        if(null == parentClasses) {
            parentClasses = new ArrayList<>();
        }
        parentClasses.add(this.getClass());
        switch (df) {
            case BY_ALL:
                logbusiness.setPrimaryKeyId(this.getPrimaryKeyId());
                logbusiness.setLoginTime(this.getLoginTime());
                logbusiness.setLogoutTime(this.getLogoutTime());
                logbusiness.setStatus(this.getStatus());
                super.getBusinessValue(df,logbusiness,parentClasses);
                if(!parentClasses.contains(this.getClass())) {
                    parentClasses.add(this.getClass());
                    logbusiness.setUserBusiness(this.getUserDao().getBusinessValue(BaseDataFilter.BY_ALL,null,parentClasses));
                }
                break;
            case BY_BUSINESS_KEY:
                break;

        }

        return logbusiness;
    }

    @Override
    public void setBusinessValue(LoginBusiness businessValue) {
        this.setPrimaryKeyId(businessValue.getPrimaryKeyId());
        this.setLoginTime(businessValue.getLoginTime());
        this.setLogoutTime(businessValue.getLogoutTime());
        this.setStatus(businessValue.getStatus());
        super.setBusinessValue(businessValue);
        if(businessValue.getUserBusiness()!= null) {
            this.setUserDao(UserPersistanceManager.getInstance().getUserDaoPersistor().getByPrimaryKeyId(businessValue.getUserBusiness()));
        }
    }

    @Override
    public void setPrimaryKeyId(Long primarykeyId) {
        this.primaryKeyId = primarykeyId;
    }
}
