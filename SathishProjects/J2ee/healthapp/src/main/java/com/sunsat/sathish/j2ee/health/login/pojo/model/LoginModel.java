package com.sunsat.sathish.j2ee.health.login.pojo.model;

import com.sunsat.sathish.j2ee.health.base.pojo.model.AbstractBaseModel;

import java.util.Date;

/**
 * Created by sathishkumar_su on 2/26/2018.
 */
public class LoginModel extends AbstractBaseModel {
    String userName;
    String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
