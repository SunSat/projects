package com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.daoModel;

import com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.serviceModel.AbstractBaseService;
import com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.serviceModel.UserNameService;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Created by sathishkumar_su on 5/4/2018.
 */

@Entity
@Table(name = "username")
public class UserNameModel extends AbstractBaseModel {

    @Id
    @Column(name = "username_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "username")
    String userName;

    @Column(name = "password")
    String password;

    public UserNameModel() {
        super("UserNameModel");
    }

    public UserNameModel(String userName, String password) {
        this("UserNameModel");
        this.userName = userName;
        this.password = password;
    }

    public UserNameModel(String userName) {
        super("UserNameModel");
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "UserNameModel{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public void getValuesAsService(AbstractBaseService sv) {
        UserNameService uNameService = (UserNameService) sv;
        uNameService.setId(this.getId());
        uNameService.setUserName(this.getUserName());
        uNameService.setPassword(this.getPassword());
    }
}
