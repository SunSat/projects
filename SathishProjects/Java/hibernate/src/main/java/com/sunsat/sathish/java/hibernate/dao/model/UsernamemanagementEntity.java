package com.sunsat.sathish.java.hibernate.dao.model;

import com.sunsat.sathish.java.hibernate.model.AbstractDaoModel;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by sathishkumar_su on 12/21/2017.
 */
@Entity
@Table(name = "usernamemanagement", schema = "", catalog = "kindle_controller_app")
public class UsernamemanagementEntity extends AbstractDaoModel {
    private Integer userid;
    private String username;
    private String password;
    private Timestamp passwordcreationdate;
    private Timestamp passwordexpirydate;
    private String status;
    private PersonaldetailEntity personaldetailByUserid;

    @Id
    @Column(name = "userid")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "passwordcreationdate")
    public Timestamp getPasswordcreationdate() {
        return passwordcreationdate;
    }

    public void setPasswordcreationdate(Timestamp passwordcreationdate) {
        this.passwordcreationdate = passwordcreationdate;
    }

    @Basic
    @Column(name = "passwordexpirydate")
    public Timestamp getPasswordexpirydate() {
        return passwordexpirydate;
    }

    public void setPasswordexpirydate(Timestamp passwordexpirydate) {
        this.passwordexpirydate = passwordexpirydate;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsernamemanagementEntity that = (UsernamemanagementEntity) o;

        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (passwordcreationdate != null ? !passwordcreationdate.equals(that.passwordcreationdate) : that.passwordcreationdate != null)
            return false;
        if (passwordexpirydate != null ? !passwordexpirydate.equals(that.passwordexpirydate) : that.passwordexpirydate != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (passwordcreationdate != null ? passwordcreationdate.hashCode() : 0);
        result = 31 * result + (passwordexpirydate != null ? passwordexpirydate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    public PersonaldetailEntity getPersonaldetailByUserid() {
        return personaldetailByUserid;
    }

    public void setPersonaldetailByUserid(PersonaldetailEntity personaldetailByUserid) {
        this.personaldetailByUserid = personaldetailByUserid;
    }
}
