package com.sunsat.sathish.j2ee.loginapp.login.persistance.impl;

import com.sunsat.sathish.j2ee.loginapp.login.persistance.LoginDao;
import com.sunsat.sathish.j2ee.loginapp.login.pojo.daoModel.LoginModel;
import com.sunsat.sathish.j2ee.loginapp.login.pojo.serviceModel.UserNameService;
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
    public int add(UserNameService userNameService) {
        convertServiceToModel(userNameService,loginModel);
        Session session = this.factory.getCurrentSession();
        session.persist(loginModel);
        return loginModel.getId();
    }

    @Override
    public boolean delete(UserNameService userNameService) {
        return false;
    }

    @Override
    public LoginModel getByUserName(UserNameService userNameService) {
        return null;
    }

    @Override
    public boolean update(UserNameService userNameService) {
        return false;
    }

    public void convertServiceToModel(UserNameService service,LoginModel model) {
        model.setId(service.getId());
    }
}
