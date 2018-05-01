package com.sunsat.sathish.j2ee.loginapp.login.persistance.impl;

import com.sunsat.sathish.j2ee.loginapp.login.persistance.LoginDao;
import com.sunsat.sathish.j2ee.loginapp.login.pojo.model.LoginModel;
import com.sunsat.sathish.j2ee.loginapp.login.pojo.service.LoginService;
import com.sunsat.sathish.j2ee.loginapp.persistance.AbstractDao;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by anitha on 5/1/2018.
 */

public class LoginDaoImpl implements LoginDao {

    @Autowired
    private SessionFactory factory;

    @Autowired
    LoginModel loginModel;

    public void setSessionFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public int add(LoginService loginService) {
        convertServiceToModel(loginService,loginModel);
        Session session = this.factory.getCurrentSession();
        session.persist(loginModel);
        return loginModel.getId();
    }

    @Override
    public boolean delete(LoginService loginService) {
        return false;
    }

    @Override
    public LoginModel getByUserName(LoginService loginService) {
        return null;
    }

    @Override
    public boolean update(LoginService loginService) {
        return false;
    }

    public void convertServiceToModel(LoginService service,LoginModel model) {
        model.setId(service.getId());
    }
}
