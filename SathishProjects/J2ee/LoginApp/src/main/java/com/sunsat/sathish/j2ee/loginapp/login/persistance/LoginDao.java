package com.sunsat.sathish.j2ee.loginapp.login.persistance;

import com.sunsat.sathish.j2ee.loginapp.login.pojo.model.LoginModel;
import com.sunsat.sathish.j2ee.loginapp.login.pojo.service.LoginService;

/**
 * Created by anitha on 5/1/2018.
 */
public interface LoginDao {
    public int add(LoginService loginService);
    public boolean delete(LoginService loginService);
    public LoginModel getByUserName(LoginService loginService);
    public boolean update(LoginService loginService);
}
