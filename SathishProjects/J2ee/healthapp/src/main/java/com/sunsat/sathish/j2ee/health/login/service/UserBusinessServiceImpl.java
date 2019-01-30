package com.sunsat.sathish.j2ee.health.login.service;

import com.sunsat.sathish.j2ee.health.base.mail.communicator.MailCommunicator;
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

    @Autowired
    MailCommunicator mailCommunicator;



    @Transactional
    @Override
    public UserFormModel createNewUser(UserFormModel model) {
        UserBusiness ub = new UserBusiness();
        ub.setUserName(model.getUserName());
        ub.setPassword(model.getPassword());
        ub.setPasswordHash(model.getPassword());
        ub.setCreationTime(new Date());
        ub.setExpiryTime(new Date());
        ub.setAccountStatus("initial");
        userDaoPersistor.createNewUser(ub);
        model.setPassword("");
        model.setConfirmPassword("");
        model.setPrimarykeyId(ub.getPrimaryKeyId());
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
            retModel.setUserName(ub.getUserName());
            retModel.setPrimarykeyId(ub.getPrimaryKeyId());
        }
        return retModel;
    }

    @Override
    public UserFormModel updateUser(UserFormModel model) {
        return null;
    }
}
