package com.sunsat.sathish.j2ee.health.login.controller;

import com.sunsat.sathish.j2ee.health.login.pojo.model.LoginModel;
import com.sunsat.sathish.j2ee.health.login.pojo.model.LoginResponseModel;
import com.sunsat.sathish.j2ee.health.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sathishkumar_su on 4/17/2018.
 */
@Controller("loginController")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    @Qualifier("loginService")
    LoginService loginService;

    @RequestMapping("/login.do")
    public LoginResponseModel peformLogin() {
        loginService.validateLogin();
        return new LoginResponseModel();
    }

    @RequestMapping("/signUp.do")
    public LoginResponseModel performSignUp() {
        return new LoginResponseModel();
    }

    @RequestMapping("/passwordReset.do")
    public LoginResponseModel performPasswordReset() {
        return new LoginResponseModel();
    }

}
