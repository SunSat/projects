package com.sunsat.sathish.j2ee.loginapp.login.pojo.model;

import com.sunsat.sathish.j2ee.loginapp.pojo.model.AbstractModel;

import javax.persistence.*;

/**
 * Created by anitha on 5/1/2018.
 */
@Entity
@Table(name="username")
public class UserNameModel extends AbstractModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "username")
    String userName;

    @Column(name = "password")
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

    public Class<UserNameModel> getModelClassName() {
        return UserNameModel.class;
    }

}
