package com.sunsat.sathish.j2ee.health.login.pojo.dao;

import com.sunsat.sathish.j2ee.health.base.persistor.BaseDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.PersistanceManager;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;
import com.sunsat.sathish.j2ee.health.login.persistor.UserPersistanceManager;
import com.sunsat.sathish.j2ee.health.login.pojo.business.CommunicationBusiness;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @Entity
@Table(name = "communication")
@Entity
public class CommunicationDao extends AbstractBaseDao<CommunicationBusiness, BaseDataFilter> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long primaryKeyId;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id")
    UserDao userDao;

    @Column(name = "mob1")
    String mobile1;

    @Column(name = "is_mob1_verified")
    boolean isMobile1Verified;

    @Column(name = "mob1_cnf_token")
    Integer mobile1CnfToken;

    @Column(name = "mob1_cnf_token_expiry_date")
    Date mobile1CnfTokenExpiryDate;

    @Column(name = "email1")
    String email1;

    @Column(name = "is_email1_verified")
    boolean isEmail1Verified;

    @Column(name = "email1_cnf_token")
    Integer email1CnfToken;

    @Column(name = "email1_cnf_token_expiry_date")
    Date email1CnfTokenExpiryDate;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Class getType() {
        return CommunicationDao.class;
    }

    @Override
    public Long getPrimaryKeyId() {
        return primaryKeyId;
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
    public void setPrimaryKeyId(Long primarykeyId) {
        this.primaryKeyId = primarykeyId;
    }

    @Override
    public void setBusinessValue(CommunicationBusiness businessValue) {
        this.setPrimaryKeyId(businessValue.getPrimaryKeyId());
        this.setEmail1(businessValue.getEmail1());
        this.setEmail1CnfToken(businessValue.getEmail1CnfToken());
        this.setEmail1CnfTokenExpiryDate(businessValue.getEmail1CnfTokenExpiryDate());
        this.setEmail1Verified(businessValue.isEmail1Verified());
        this.setMobile1(businessValue.getMobile1());
        this.setMobile1CnfToken(businessValue.getMobile1CnfToken());
        this.setMobile1CnfTokenExpiryDate(businessValue.getMobile1CnfTokenExpiryDate());
        this.setMobile1Verified(businessValue.isMobile1Verified());
        UserPersistanceManager mgr = UserPersistanceManager.getInstance();
        if(businessValue.getUserBusiness() != null) {
            this.setUserDao(mgr.getUserDaoPersistor().getByPrimaryKeyId(businessValue.getUserBusiness()));
        }
        super.setBusinessValue(businessValue);
    }

    @Override
    public CommunicationBusiness getBusinessValue(BaseDataFilter baseDataFilter, CommunicationBusiness businessValue,List<Class> parentClasses)   {
        if(null == businessValue) businessValue = new CommunicationBusiness();
        if(null == parentClasses) {
            parentClasses = new ArrayList<>();
        }
        parentClasses.add(this.getClass());
        switch (baseDataFilter) {
            case BY_ALL:
                businessValue.setPrimaryKeyId(this.getPrimaryKeyId());
                businessValue.setEmail1(this.getEmail1());
                businessValue.setEmail1CnfToken(this.getEmail1CnfToken());
                businessValue.setEmail1CnfTokenExpiryDate(this.getEmail1CnfTokenExpiryDate());
                businessValue.setEmail1Verified(this.isEmail1Verified());
                businessValue.setMobile1(this.getMobile1());
                businessValue.setMobile1CnfToken(this.getMobile1CnfToken());
                businessValue.setMobile1CnfTokenExpiryDate(this.getMobile1CnfTokenExpiryDate());
                businessValue.setMobile1Verified(this.isMobile1Verified());
                if(!parentClasses.contains(this.getUserDao().getClass())) {
                    parentClasses.add(this.getClass());
                    businessValue.setUserBusiness(this.getUserDao().getBusinessValue(baseDataFilter,null,parentClasses));
                }
                break;
            case BY_BUSINESS_KEY:
                break;
        }
        return businessValue;
    }
}
