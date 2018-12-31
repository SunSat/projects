package com.sunsat.sathish.j2ee.health.login.controller;

import com.sunsat.sathish.j2ee.health.login.loginException.LoginException;
import com.sunsat.sathish.j2ee.health.login.pojo.model.LoginResponseModel;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;
import com.sunsat.sathish.j2ee.health.login.service.LoginBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by sathishkumar_su on 4/17/2018.
 */
@Controller
public class LoginController {

    @Autowired
    @Qualifier("loginServiceImpl")
    LoginBusinessService loginService;


    @RequestMapping(value = {"/homepage.an","/"," * "},method = RequestMethod.GET)
    public String loadHomePage() {
        return "homepage";
    }

    @RequestMapping("/loginAction.do")
    public UserFormModel peformLogin(@RequestBody UserFormModel model, HttpServletRequest request, HttpServletResponse response) {

        HttpSession ses = request.getSession(true);
        if(ses.isNew()) {

        } else {
            ses.invalidate();
            ses = request.getSession(true);
        }
        return new UserFormModel();
    }

    @RequestMapping("/signUpAction.an")
    public UserFormModel performSignUp(@RequestBody UserFormModel model,HttpServletRequest request,HttpServletResponse response) {

        UserFormModel resModel = new UserFormModel();
        resModel.setMessage("success");
        String userName = model.getUserName();
        String password = model.getPassword();
        String emailId = model.getMailId();
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password) || StringUtils.isEmpty(emailId)) {
            resModel.setMessage("Please provide all necessary data.");
        } else {
            try {
                //resModel = loginService.createNewUser(model);
            }catch (LoginException lo) {
                resModel.setMessage("Error while crating User. Please contact Admin.");
            }
        }
        return  resModel;
    }


    @RequestMapping(value = "/passwordReset.do", method = RequestMethod.POST)
    public LoginResponseModel performPasswordReset() {
        return new LoginResponseModel();
    }

    @RequestMapping(value = "/checkExistingUserName.an", method = RequestMethod.POST)
    @ResponseBody
    public String checkExistingUserName(@RequestBody UserFormModel model) {

        return "succss";
    }

}
