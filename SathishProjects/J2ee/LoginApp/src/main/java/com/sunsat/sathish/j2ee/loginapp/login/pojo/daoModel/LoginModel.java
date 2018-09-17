package com.sunsat.sathish.j2ee.loginapp.login.pojo.daoModel;

import com.sunsat.sathish.j2ee.loginapp.pojo.model.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

/**
 * Created by anitha on 5/1/2018.
 */
/*
  `id` INT NOT NULL,
  `userid` INT NULL,
  `loginsourceid` INT NULL,
  `logintime` VARCHAR(25) NULL,
  `logouttime` VARCHAR(25) NULL,
  `status` VARCHAR(25) NULL,
 */
@Entity
@Table(name = "login")
public class LoginModel extends AbstractModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JoinColumn(name = "username_id",unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    UserNameModel userNameModel;

    @JoinColumn(name = "login_source_id",unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    LoginSourceModel loginSourceModel;

    @Column(name = "logintime")
    String loginTime;

    @Column(name = "logouttime")
    String logoutTime;

    @Column(name = "status")
    String status;

    @Override
    public Class getModelClassName() {
        return LoginModel.class;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserNameModel getUserNameModel() {
        return userNameModel;
    }

    public void setUserNameModel(UserNameModel userNameModel) {
        this.userNameModel = userNameModel;
    }

    public LoginSourceModel getLoginSourceModel() {
        return loginSourceModel;
    }

    public void setLoginSourceModel(LoginSourceModel loginSourceModel) {
        this.loginSourceModel = loginSourceModel;
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
