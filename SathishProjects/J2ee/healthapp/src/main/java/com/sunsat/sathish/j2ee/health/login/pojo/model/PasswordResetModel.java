package com.sunsat.sathish.j2ee.health.login.pojo.model;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */
public class PasswordResetModel extends LoginModel {

    String mailId;
    String token;
    String passwordResetOperation; //1. ResetPassword 2. ValidateToken 3. ResetPassword

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
