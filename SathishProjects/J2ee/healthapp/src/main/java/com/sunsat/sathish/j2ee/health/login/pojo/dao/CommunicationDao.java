package com.sunsat.sathish.j2ee.health.login.pojo.dao;

import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.business.BaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;
import com.sunsat.sathish.j2ee.health.login.pojo.business.CommunicationBusiness;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "communication")
public class CommunicationDao extends AbstractBaseDao<CommunicationBusiness> {

    @Id
    @Column(name = "id")
    @GeneratedValue
    Long primaryKeyId;

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

    @Override
    public Class getType() {
        return CommunicationDao.class;
    }

    @Override
    public Long getPrimarykeyId() {
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
    public void setPrimarykeyId(Long primarykeyId) {

    }

    @Override
    public CommunicationBusiness getBusinessValue() {
        return null;
    }

    @Override
    public void setBusinessValue(CommunicationBusiness businessValue) {

    }
}
