package com.sunsat.sathish.j2ee.loginapp.login.pojo.serviceModel;

/**
 * Created by sathishkumar_su on 5/3/2018.
 */
public class LoginService {

    int id;
    int userId;
    int loginSourceId;
    String loginTime;
    String logoutTime;
    String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLoginSourceId() {
        return loginSourceId;
    }

    public void setLoginSourceId(int loginSourceId) {
        this.loginSourceId = loginSourceId;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
