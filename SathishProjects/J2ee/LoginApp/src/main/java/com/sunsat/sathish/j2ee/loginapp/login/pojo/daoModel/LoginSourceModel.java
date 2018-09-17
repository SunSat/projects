package com.sunsat.sathish.j2ee.loginapp.login.pojo.daoModel;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Created by anitha on 5/1/2018.
 */

/*
  `id` INT NOT NULL,
  `userid` INT NULL,
  `login_source` VARCHAR(20) NULL,
  `source_user_name` VARCHAR(50) NULL,
  `delete` TINYINT(1) NULL,
 */
@Entity
@Table(name = "login_source")
public class LoginSourceModel {

    @Id
    @Column(name = "login_source_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @JoinColumn(name = "username_id")
    @OneToOne(cascade = CascadeType.ALL)
    UserNameModel userNameModel;

    @Column(name = "login_source")
    String loginSource;

    @Column(name = "source_user_name")
    String sourceUserName;

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
}
