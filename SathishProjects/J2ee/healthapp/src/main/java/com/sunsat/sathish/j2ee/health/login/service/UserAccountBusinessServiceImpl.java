package com.sunsat.sathish.j2ee.health.login.service;

import com.sunsat.sathish.j2ee.health.base.mail.communicator.MailCommunicator;
import com.sunsat.sathish.j2ee.health.base.util.GeneralAppUtil;
import com.sunsat.sathish.j2ee.health.login.persistor.*;
import com.sunsat.sathish.j2ee.health.login.pojo.business.CommunicationBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.LoginBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.RoleBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.UserDao;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

@Service("userService")
public class UserAccountBusinessServiceImpl implements UserAccountBusinessService {

    @Autowired
    UserGenericDaoPersistor userDaoPersistor;

    @Autowired
    CommunicationGenericDaoPersistor commDaoPersistor;

    @Autowired
    LoginGenericDaoPersistor loginDaoPersistor;

    @Autowired
    PersonalDetailGenericDaoPersistor personalDetailDaoPersistor;

    @Autowired
    RoleGenericDaoPersistor roleDaoPersistor;

    @Autowired
    MailCommunicator mailCommunicator;



    @Transactional
    @Override
    public UserBusiness createNewUser(UserFormModel model) {
        UserBusiness ub = new UserBusiness();
        ub.setUserName(model.getUserName());
        ub.setPassword(model.getPassword());
        ub.setPasswordHash(model.getPassword());
        ub.setCreationTime(model.getCreationTime());
        ub.setExpiryTime(model.getExpiryTime());
        ub.setAccountStatus(model.getAccountStatus());
        ub.setCreatedByDate(GeneralAppUtil.getCurrentTime());
        ub.setCreatedById(0l);
        ub.setModifiedByDate(GeneralAppUtil.getCurrentTime());
        ub.setModifiedById(0l);
        ub.setIsDeleted(0);
        return userDaoPersistor.createNewUser(ub);
    }

    @Transactional
    @Override
    public UserBusiness getExistingUser(UserFormModel model) {
        return userDaoPersistor.getUserByUserName(model.getUserName());
/*
        UserFormModel retModel = new UserFormModel();
        retModel.setOperationType(model.getOperationType());
        retModel.setSubOperationType(model.getSubOperationType());
        if(ub != null && ub.getUserName().equals(model.getUserName()))  {
            retModel.setUserName(ub.getUserName());
            retModel.setPrimarykeyId(ub.getPrimaryKeyId());
        }
        return retModel;
*/
    }

    @Override
    public UserBusiness loadUserById(UserFormModel model) {
        UserBusiness ub = new UserBusiness();
        ub.setPrimaryKeyId(model.getPrimarykeyId());
        return userDaoPersistor.getUserDetails(ub);
    }

    @Override
    public UserBusiness updateUser(UserFormModel model) {
        return null;
    }

    @Override
    public UserFormModel performLogin(UserFormModel model) {
        UserBusiness ub  = new UserBusiness();
        ub.setPassword(model.getPassword());
        ub.setUserName(model.getUserName());
        ub = userDaoPersistor.performLogin(ub);
        model.setMessage(ub.getMessage());
        model.setPassword("");
        model.setPrimarykeyId(ub.getPrimaryKeyId());
        return model;
    }

    @Override
    public LoginBusiness createOrUpdateLogin(UserFormModel model) {

        LoginBusiness lb = null;
        UserBusiness ub = new UserBusiness();
        ub.setPrimaryKeyId(model.getPrimarykeyId());
        ub = userDaoPersistor.getUserDetails(ub);
        lb = ub.getLoginBusiness();
        if(lb != null && lb.getStatus().equalsIgnoreCase("LOGOUT")) {
            lb.setLoginTime(GeneralAppUtil.getCurrentTime());
            lb.setLogoutTime(null);
            lb.setStatus("LOGIN");
            lb.setUserBusiness(ub);
            lb.setCreatedByDate(GeneralAppUtil.getCurrentTime());
            lb.setCreatedById(ub.getPrimaryKeyId());
            lb.setModifiedByDate(GeneralAppUtil.getCurrentTime());
            lb.setModifiedById(ub.getPrimaryKeyId());
            lb.setIsDeleted(0);
            lb = loginDaoPersistor.updateLogin(lb);
        } else {
            lb = new LoginBusiness();
            lb.setLoginTime(GeneralAppUtil.getCurrentTime());
            lb.setStatus("LOGIN");
            lb.setLogoutTime(null);
            lb.setUserBusiness(ub);
            lb.setCreatedByDate(GeneralAppUtil.getCurrentTime());
            lb.setCreatedById(ub.getPrimaryKeyId());
            lb.setModifiedByDate(GeneralAppUtil.getCurrentTime());
            lb.setModifiedById(ub.getPrimaryKeyId());
            lb.setIsDeleted(0);
            lb = loginDaoPersistor.createNewLogin(lb);
        }
        return lb;
    }

    @Override
    public LoginBusiness updateLogin(UserFormModel model) {
        return null;
    }

    @Override
    public UserFormModel invalidateAccount(UserFormModel model) {
        return null;
    }

    @Override
    public CommunicationBusiness createCommunication(UserFormModel model) {
        CommunicationBusiness comb = new CommunicationBusiness();
        comb.setEmail1(model.getMailId());
        comb.setEmail1Verified(false);
        comb.setEmail1CnfToken(Integer.parseInt(GeneralAppUtil.getOtp()));
        Calendar cal = GeneralAppUtil.getCurrentCalender();
        cal.add(Calendar.HOUR,24);
        comb.setEmail1CnfTokenExpiryDate(cal.getTime());
        comb.setMobile1Verified(false);
        comb.setMobile1(null);
        comb.setIsDeleted(0);
        comb.setCreatedByDate(GeneralAppUtil.getCurrentTime());
        comb.setCreatedById(0l);
        comb.setModifiedByDate(GeneralAppUtil.getCurrentTime());
        comb.setModifiedById(0l);
        UserBusiness ub = new UserBusiness();
        ub.setPrimaryKeyId(model.getPrimarykeyId());
        comb.setUserBusiness(ub);
        commDaoPersistor.createNewComm(comb);
        return comb;
    }

    @Override
    public CommunicationBusiness updateCommunication(UserFormModel model) {
        return null;
    }

    @Override
    public UserFormModel checkPasswordExpiryDate(UserFormModel model) {
        return null;
    }

    @Override
    public UserFormModel verifyMobile1(UserFormModel model) {
        return null;
    }

    @Override
    public UserFormModel verifyMailId1(UserFormModel model) {
        return null;
    }

    @Override
    public UserFormModel generateTokenForMobile1(UserFormModel model) {
        return null;
    }

    @Override
    public UserFormModel generateTokenForMailId1(UserFormModel model) {
        return null;
    }


    @Override
    public RoleBusiness createNewRole(UserFormModel model) {
        return null;
    }

    @Override
    public RoleBusiness updaateRole(UserFormModel model) {
        return null;
    }

    @Override
    public RoleBusiness deleteRole(UserFormModel model) {
        return null;
    }
}
