package com.sunsat.sathish.java.hibernate.loginMaintanance.dao;

import com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.daoModel.UserNameModel;
import com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.serviceModel.UserNameService;
import org.hibernate.Session;
import org.hibernate.*;

import java.util.List;

/**
 * Created by sathishkumar_su on 5/4/2018.
 */
public class UserNameDao extends AbstractBaseDao {

    public UserNameDao(SessionFactory factory) {
        super(factory);
    }

    public UserNameDao() {

    }

    public void add(UserNameService uName) {
        UserNameModel model = new UserNameModel();
        model.setUserName(uName.getUserName());
        model.setPassword(uName.getPassword());
        add(model);
    }

    public UserNameModel getByName(UserNameService uName) {
        UserNameModel model = null;
        String sqlQuery = "from UserNameModel um where um.userName = :uName";
        Session ses = daoFactory.openSession();
        org.hibernate.query.Query<UserNameModel> query = ses.createQuery(sqlQuery, UserNameModel.class);
        query.setParameter("uName",uName.getUserName());
        List<UserNameModel> umList = query.list();
        if(umList != null && umList.size() > 0) {
            model =  umList.get(0);
        }
        return model;

    }

    public UserNameModel getById(UserNameService uName) {
        UserNameModel model = new UserNameModel();
        model.setId(uName.getId());
        return (UserNameModel) getById(model);
    }
}
