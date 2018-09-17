package com.sunsat.sathish.java.hibernate.loginMaintanance.dao;

import com.sunsat.sathish.java.hibernate.exception.LoginException;
import com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.daoModel.UserNameModel;
import com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.serviceModel.UserNameService;
import com.sunsat.sathish.java.hibernate.model.AbstractDaoModel;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by sathishkumar_su on 5/11/2018.
 */
public class LoginManagementDao<T extends AbstractDaoModel> extends AbstractBaseDao {

    public UserNameService getUserByUserName(UserNameService service) throws LoginException {
        UserNameModel model = new UserNameModel();
        model.setUserName(service.getUserName());
        String query = "from UserNameModel as un where un.userName = :uName";
        Session ses = daoFactory.openSession();
        Query<UserNameModel> unameQuery = ses.createQuery(query,UserNameModel.class);
        unameQuery.setParameter("uName",service.getUserName());
        List<UserNameModel> liModel = unameQuery.getResultList();
        if(liModel == null || liModel.size() == 0) {
            throw new LoginException("Invalid UserName and Password");
        }
        UserNameModel uNameModel = liModel.get(0);
        uNameModel.getValuesAsService(service);
        return service;
    }


}
