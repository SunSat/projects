package com.sunsat.sathish.j2ee.health.login.pojo.model;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */
public class SignInModel extends LoginModel {

    String signInsource;
    UserModel userModel;

    public String getSignInsource() {
        return signInsource;
    }

    public void setSignInsource(String signInsource) {
        this.signInsource = signInsource;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
