package com.sunsat.sathish.java.hibernate.dao.model;

import com.sunsat.sathish.java.hibernate.model.AbstractDaoModel;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by sathishkumar_su on 12/21/2017.
 */
@Entity
@Table(name = "loginmanagement", schema = "", catalog = "kindle_controller_app")
public class LoginmanagementEntity extends AbstractDaoModel {
    private Integer loginid;
    private Integer userid;
    private Timestamp logintime;
    private Timestamp logouttime;
    private String status;
    private String message;
    private PersonaldetailEntity personaldetailByUserid;

    @Id
    @Column(name = "loginid")
    public Integer getLoginid() {
        return loginid;
    }

    public void setLoginid(Integer loginid) {
        this.loginid = loginid;
    }

    @Basic
    @Column(name = "userid")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "logintime")
    public Timestamp getLogintime() {
        return logintime;
    }

    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
    }

    @Basic
    @Column(name = "logouttime")
    public Timestamp getLogouttime() {
        return logouttime;
    }

    public void setLogouttime(Timestamp logouttime) {
        this.logouttime = logouttime;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginmanagementEntity that = (LoginmanagementEntity) o;

        if (loginid != null ? !loginid.equals(that.loginid) : that.loginid != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (logintime != null ? !logintime.equals(that.logintime) : that.logintime != null) return false;
        if (logouttime != null ? !logouttime.equals(that.logouttime) : that.logouttime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loginid != null ? loginid.hashCode() : 0;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (logintime != null ? logintime.hashCode() : 0);
        result = 31 * result + (logouttime != null ? logouttime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    public PersonaldetailEntity getPersonaldetailByUserid() {
        return personaldetailByUserid;
    }

    public void setPersonaldetailByUserid(PersonaldetailEntity personaldetailByUserid) {
        this.personaldetailByUserid = personaldetailByUserid;
    }
}
