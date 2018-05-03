package com.sunsat.sathish.j2ee.health.login.pojo.model;

import com.sunsat.sathish.j2ee.health.base.pojo.model.AbstractBaseModel;
import com.sunsat.sathish.j2ee.health.base.pojo.model.BaseModel;

/**
 * Created by sathishkumar_su on 2/26/2018.
 */
public class UserModel extends AbstractBaseModel {

    private String name;
    private String gender;
    private String dob;
    private String address;
    private String mob;
    private String mail;

    public UserModel() {
        setType("user");
    }

    public UserModel(String type) {
        setType(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
