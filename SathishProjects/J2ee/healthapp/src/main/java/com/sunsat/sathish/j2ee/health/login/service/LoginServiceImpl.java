package com.sunsat.sathish.j2ee.health.login.service;

import com.sunsat.sathish.j2ee.health.login.loginException.LoginException;
import com.sunsat.sathish.j2ee.health.login.persistor.LoginDaoPersistorImpl;
import com.sunsat.sathish.j2ee.health.login.persistor.UserDaoPersistorImpl;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.UserDao;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("loginServiceImpl")
public class LoginServiceImpl extends LoginBusinessService<UserFormModel> {

    @Autowired
    UserDaoPersistorImpl userDaoPersistor;

    @Autowired
    LoginDaoPersistorImpl loginDaoPersistor;

    public UserFormModel createNewUser(UserFormModel model) {
        String userName = model.getUserName();
        UserBusiness userBusines = new UserBusiness();
        userBusines.setUserName(userName);
        userBusines.setPassword(model.getPassword());
        userBusines.setPasswordHash(model.getPassword());
        userBusines.setAccountStatus("created");
        userBusines.setCreationTime(new Date());
        userBusines.setExpiryTime(new Date());
        userBusines.setCreatedByDate(new Date());
        userBusines.setModifiedByDate(new Date());

        String query = "from UserDao u where u.userName = '"+"sat"+"'";
        List<UserDao> dao = userDaoPersistor.getByQuery(userDaoPersistor.getDaoClass(),query);
        if(dao != null && dao.size() > 1) {
            throw new LoginException("UserName already exists");
        }

        UserDao newUserDao = userDaoPersistor.persist(userBusines);
        model.setPrimarykeyId(newUserDao.getPrimarykeyId());
        model.setMessage("Account Created Successfully. Plz verify through your mail id.");
        return model;
    }

    public boolean checkUserExist(UserFormModel formModel) {
        String userName = formModel.getUserName();
        UserBusiness userBusines = new UserBusiness();
        userBusines.setUserName(userName);

        return true;
    }

    @Override
    public UserFormModel getExistingUser(UserFormModel model) {
        return null;
    }

    @Override
    public UserFormModel updateUser(UserFormModel model) {
        return null;
    }
}
