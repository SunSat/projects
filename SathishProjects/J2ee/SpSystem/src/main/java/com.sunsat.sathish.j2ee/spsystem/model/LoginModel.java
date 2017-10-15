package com.sunsat.sathish.j2ee.spsystem.model;

import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * Created by ssundar2 on 28-03-2017.
 */
@Scope("prototype")
public class LoginModel {

    private int userid;
    private String password;

    public LoginModel() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
