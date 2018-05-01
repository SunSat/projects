package com.sunsat.sathish.j2ee.loginapp.login.pojo.service;

/**
 * Created by anitha on 5/1/2018.
 */
public class LoginService {
    int id;
    String userName;
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
