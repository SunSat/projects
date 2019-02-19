package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.BaseDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.UserDao;

public interface UserGenericDaoPersistor {

    public UserBusiness createNewUser(UserBusiness ub);
    public UserBusiness getUserDetails(UserBusiness ub);
    public UserBusiness updateUserDetails(UserBusiness ub);
    public UserBusiness getUserByUserName(String un);
    public UserBusiness deleteUserById(UserBusiness ub);
    public String validateUser(UserBusiness ub);
    public String validateUserMailId(UserBusiness ub);
    public String validateUserMobNo(UserBusiness ub);
    public UserBusiness performLogin(UserBusiness ub);
    public UserDao getByPrimaryKeyId(UserBusiness ub);
}
