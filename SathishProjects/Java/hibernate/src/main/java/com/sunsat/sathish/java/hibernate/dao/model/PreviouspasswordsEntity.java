package com.sunsat.sathish.java.hibernate.dao.model;

import com.sunsat.sathish.java.hibernate.model.AbstractDaoModel;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by sathishkumar_su on 12/21/2017.
 */
@Entity
@Table(name = "previouspasswords", schema = "", catalog = "kindle_controller_app")
public class PreviouspasswordsEntity extends AbstractDaoModel {
    private Integer previouspasswordid;
    private Integer userid;
    private String previoususername;
    private String previouspassword;
    private Timestamp passwordcreationdate;
    private Timestamp passwordexpirydate;
    private PersonaldetailEntity personaldetailByUserid;

    @Id
    @Column(name = "previouspasswordid")
    public Integer getPreviouspasswordid() {
        return previouspasswordid;
    }

    public void setPreviouspasswordid(Integer previouspasswordid) {
        this.previouspasswordid = previouspasswordid;
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
    @Column(name = "previoususername")
    public String getPrevioususername() {
        return previoususername;
    }

    public void setPrevioususername(String previoususername) {
        this.previoususername = previoususername;
    }

    @Basic
    @Column(name = "previouspassword")
    public String getPreviouspassword() {
        return previouspassword;
    }

    public void setPreviouspassword(String previouspassword) {
        this.previouspassword = previouspassword;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreviouspasswordsEntity that = (PreviouspasswordsEntity) o;

        if (previouspasswordid != null ? !previouspasswordid.equals(that.previouspasswordid) : that.previouspasswordid != null)
            return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (previoususername != null ? !previoususername.equals(that.previoususername) : that.previoususername != null)
            return false;
        if (previouspassword != null ? !previouspassword.equals(that.previouspassword) : that.previouspassword != null)
            return false;
        if (passwordcreationdate != null ? !passwordcreationdate.equals(that.passwordcreationdate) : that.passwordcreationdate != null)
            return false;
        if (passwordexpirydate != null ? !passwordexpirydate.equals(that.passwordexpirydate) : that.passwordexpirydate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = previouspasswordid != null ? previouspasswordid.hashCode() : 0;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (previoususername != null ? previoususername.hashCode() : 0);
        result = 31 * result + (previouspassword != null ? previouspassword.hashCode() : 0);
        result = 31 * result + (passwordcreationdate != null ? passwordcreationdate.hashCode() : 0);
        result = 31 * result + (passwordexpirydate != null ? passwordexpirydate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    public PersonaldetailEntity getPersonaldetailByUserid() {
        return personaldetailByUserid;
    }

    public void setPersonaldetailByUserid(PersonaldetailEntity personaldetailByUserid) {
        this.personaldetailByUserid = personaldetailByUserid;
    }
}
