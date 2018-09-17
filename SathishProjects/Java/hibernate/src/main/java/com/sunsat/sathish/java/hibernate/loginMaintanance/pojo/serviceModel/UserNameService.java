package com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.serviceModel;

/**
 * Created by sathishkumar_su on 5/4/2018.
 */
public class UserNameService extends AbstractBaseService {

    String userName;
    String password;

    public UserNameService() {
    }

    public UserNameService(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserNameService(int id, String userName, String password) {
        super(id);
        this.userName = userName;
        this.password = password;
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
