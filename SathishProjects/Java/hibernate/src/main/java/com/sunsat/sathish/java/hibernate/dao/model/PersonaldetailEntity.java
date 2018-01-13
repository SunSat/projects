package com.sunsat.sathish.java.hibernate.dao.model;

import com.sunsat.sathish.java.hibernate.model.AbstractDaoModel;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by sathishkumar_su on 12/21/2017.
 */
@Entity
@Table(name = "personaldetail", schema = "", catalog = "kindle_controller_app")
public class PersonaldetailEntity extends AbstractDaoModel {
    private Integer userid;
    private String firstname;
    private String lastname;
    private String address1;
    private String address2;
    private String gender;
    private Date dob;
    private String city;
    private String state;
    private String country;
    private String mobile;
    private String mail;
    private Collection<LoginmanagementEntity> loginmanagementsByUserid;
    private Collection<PreviouspasswordsEntity> previouspasswordsesByUserid;
    private UsernamemanagementEntity usernamemanagementByUserid;

    @Id
    @Column(name = "userid")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "address1")
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Basic
    @Column(name = "address2")
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "dob")
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonaldetailEntity that = (PersonaldetailEntity) o;

        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (dob != null ? !dob.equals(that.dob) : that.dob != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "personaldetailByUserid")
    public Collection<LoginmanagementEntity> getLoginmanagementsByUserid() {
        return loginmanagementsByUserid;
    }

    public void setLoginmanagementsByUserid(Collection<LoginmanagementEntity> loginmanagementsByUserid) {
        this.loginmanagementsByUserid = loginmanagementsByUserid;
    }

    @OneToMany(mappedBy = "personaldetailByUserid")
    public Collection<PreviouspasswordsEntity> getPreviouspasswordsesByUserid() {
        return previouspasswordsesByUserid;
    }

    public void setPreviouspasswordsesByUserid(Collection<PreviouspasswordsEntity> previouspasswordsesByUserid) {
        this.previouspasswordsesByUserid = previouspasswordsesByUserid;
    }

    @OneToOne(mappedBy = "personaldetailByUserid")
    public UsernamemanagementEntity getUsernamemanagementByUserid() {
        return usernamemanagementByUserid;
    }

    public void setUsernamemanagementByUserid(UsernamemanagementEntity usernamemanagementByUserid) {
        this.usernamemanagementByUserid = usernamemanagementByUserid;
    }
}
