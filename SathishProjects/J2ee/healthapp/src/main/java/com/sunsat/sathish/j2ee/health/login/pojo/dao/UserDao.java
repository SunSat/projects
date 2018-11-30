package com.sunsat.sathish.j2ee.health.login.pojo.dao;

import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */

@Entity
@Table(name = "user")
public class UserDao extends AbstractBaseDao<UserBusiness> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long primarykeyId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "creation_time")
    private Date creationTime;

    @Column(name = "expiry_time")
    private Date expiryTime;

    @Column(name = "account_status")
    private String accountStatus;


    @Override
    public Class getType() {
        return UserDao.class;
    }

    public Long getPrimarykeyId() {
        return primarykeyId;
    }

    public void setPrimarykeyId(Long primarykeyId) {
        this.primarykeyId = primarykeyId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public UserBusiness getBusinessValue() {
        UserBusiness business = new UserBusiness();
        return business;
    }

    @Override
    public void setBusinessValue(UserBusiness businessValue) {
        this.setUserName(businessValue.getUserName());
        this.setPassword(businessValue.getPassword());
        this.setPasswordHash(businessValue.getPasswordHash());
        this.setAccountStatus(businessValue.getAccountStatus());
        this.setCreationTime(businessValue.getCreationTime());
        this.setExpiryTime(businessValue.getExpiryTime());
        this.setCreatedByDate(businessValue.getCreatedByDate());
        this.setModifiedByDate(businessValue.getModifiedByDate());
        this.setIsDeleted(businessValue.isDeleted());
    }
}
