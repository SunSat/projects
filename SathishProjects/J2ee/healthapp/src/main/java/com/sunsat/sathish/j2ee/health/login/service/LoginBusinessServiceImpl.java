package com.sunsat.sathish.j2ee.health.login.service;

import com.sunsat.sathish.j2ee.health.base.businessService.AbstractBusinessService;
import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;
import com.sunsat.sathish.j2ee.health.login.loginException.LoginException;
import com.sunsat.sathish.j2ee.health.login.persistor.LoginGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.login.pojo.business.LoginBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.UserDao;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("loginService")
public class LoginBusinessServiceImpl extends AbstractBusinessService<UserFormModel> implements LoginBusinessService {

    @Autowired
    @Qualifier("loginDaoPersistor")
    LoginGenericDaoPersistor loginDaoPer;



    public UserFormModel createNewUser(UserFormModel model) {
        //LoginDaoPersistorImpl loginPersistor = LoginDaoPersistorImpl.getInstance();
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

        LoginBusiness bussiness = new LoginBusiness();

        String query = "from UserDao u where u.userName = '"+"sat"+"'";
        List<UserDao> dao = null;//userDaoPersistor.getByQuery(userDaoPersistor.getDaoClass(),query);
        if(dao != null && dao.size() > 1) {
            throw new LoginException("UserName already exists");
        }

        //userDaoPersistor.add(userBusines);
        model.setPrimarykeyId(userBusines.getPrimarykeyId());
        loginDaoPer.persist(bussiness);
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

    @Override
    public UserFormModel getByPrimarykey(UserFormModel baseModel) {
        return null;
    }

    @Override
    public List<UserFormModel> getAllByType(UserFormModel baseModel) {
        return null;
    }

    @Override
    public List<UserFormModel> getByQuery(String query) {
        return null;
    }

    @Override
    public Long getMaxRow(UserFormModel baseModel) {
        return null;
    }

    @Override
    public UserFormModel save(UserFormModel baseModel) {
        return null;
    }

    @Override
    public boolean delete(UserFormModel baseMolel) {
        return false;
    }

    @Override
    public boolean update(UserFormModel baseModel) {
        return false;
    }

    @Override
    public Long getCount(UserFormModel baseModel) {
        return null;
    }

}
