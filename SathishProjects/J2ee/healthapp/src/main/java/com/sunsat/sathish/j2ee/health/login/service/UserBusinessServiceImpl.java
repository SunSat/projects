package com.sunsat.sathish.j2ee.health.login.service;

import com.sunsat.sathish.j2ee.health.login.persistor.UserGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("userService")
public class UserBusinessServiceImpl implements UserBusinessService {

    @Autowired
    UserGenericDaoPersistor userDaoPersistor;


    @Transactional
    @Override
    public UserFormModel createNewUser(UserFormModel model) {
        UserBusiness ub = new UserBusiness();
        ub.setUserName(model.getUserName());
        ub.setPassword(model.getPassword());
        ub.setCreationTime(new Date());
        ub.setExpiryTime(new Date());
        UserBusiness retUb = userDaoPersistor.createNewUser(ub);
        model.setPassword("");
        model.setConfirmPassword("");
        model.setPrimarykeyId(retUb.getPrimaryKeyId());
        model.setMessage(retUb.getMessage());
        return model;
    }

    @Transactional
    @Override
    public UserFormModel getExistingUser(UserFormModel model) {
        UserBusiness ub = userDaoPersistor.getUserByUserName(model.getUserName());
        UserFormModel retModel = new UserFormModel();
        retModel.setOperationType(model.getOperationType());
        retModel.setSubOperationType(model.getSubOperationType());
        if(ub != null && ub.getUserName().equals(model.getUserName()))  {
            retModel.setMessage("UserName Already Exist.");
        } else {
            retModel.setMessage("successful");
        }
        return retModel;
    }

    @Override
    public UserFormModel updateUser(UserFormModel model) {
        return null;
    }
}
