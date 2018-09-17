package com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.daoModel;

import javax.persistence.*;

/**
 * Created by sathishkumar_su on 5/4/2018.
 */
@Entity
@Table(name = "login_source")
public class LoginSourceModel {

    @Id
    @Column(name = "login_source_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username_id",unique = true)
    private UserNameModel userModel;

    @Column(name = "login_source")
    private String loginSource;

    @Column(name = "source_user_name")
    private String sourceUserName;

    @Column(name = "delete")
    private int delete;

    public LoginSourceModel() {

    }

    public LoginSourceModel(UserNameModel userModel, String loginSource, String sourceUserName, int delete) {
        this.userModel = userModel;
        this.loginSource = loginSource;
        this.sourceUserName = sourceUserName;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserNameModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserNameModel userModel) {
        this.userModel = userModel;
    }

    public String getLoginSource() {
        return loginSource;
    }

    public void setLoginSource(String loginSource) {
        this.loginSource = loginSource;
    }

    public String getSourceUserName() {
        return sourceUserName;
    }

    public void setSourceUserName(String sourceUserName) {
        this.sourceUserName = sourceUserName;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }
}
