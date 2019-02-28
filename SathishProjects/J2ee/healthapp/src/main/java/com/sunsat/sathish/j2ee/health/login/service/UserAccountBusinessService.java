package com.sunsat.sathish.j2ee.health.login.service;

import com.sunsat.sathish.j2ee.health.login.pojo.business.CommunicationBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.LoginBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.RoleBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;

import java.math.BigInteger;

public interface UserAccountBusinessService {
    public UserBusiness createNewUser(UserFormModel model);
    public UserBusiness getExistingUser(UserFormModel model);
    public UserBusiness getExistingUserById(UserFormModel model);
    public UserBusiness updateUser(UserFormModel model);
    public UserBusiness updateUser(UserBusiness ub);
    public UserFormModel performLogin(UserFormModel model);
    public LoginBusiness createOrUpdateLogin(UserFormModel model);
    public LoginBusiness updateLogin(UserFormModel model);
    public UserFormModel invalidateAccount(UserFormModel model);
    public CommunicationBusiness createCommunication(UserFormModel model);
    public CommunicationBusiness updateCommunication(UserFormModel model);
    public UserFormModel checkPasswordExpiryDate(UserFormModel model);
    public UserFormModel verifyMobile1(UserFormModel model);
    public UserFormModel verifyMailId1(UserFormModel model);
    public UserFormModel generateTokenForMobile1(UserFormModel model);
    public UserFormModel generateTokenForMailId1(UserFormModel model);
    public RoleBusiness createNewRole(UserFormModel model);
    public RoleBusiness updaateRole(UserFormModel model);
    public RoleBusiness deleteRole(UserFormModel model);
    public Long getLikeCount();
    public Long setLikeCount(Long count);
}
