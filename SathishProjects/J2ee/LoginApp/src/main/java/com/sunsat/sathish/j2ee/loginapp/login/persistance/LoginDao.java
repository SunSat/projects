package com.sunsat.sathish.j2ee.loginapp.login.persistance;

import com.sunsat.sathish.j2ee.loginapp.login.pojo.daoModel.LoginModel;
import com.sunsat.sathish.j2ee.loginapp.login.pojo.serviceModel.UserNameService;

/**
 * Created by anitha on 5/1/2018.
 */
public interface LoginDao {
    public int add(UserNameService userNameService);
    public boolean delete(UserNameService userNameService);
    public LoginModel getByUserName(UserNameService userNameService);
    public boolean update(UserNameService userNameService);
}
