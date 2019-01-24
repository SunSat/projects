package com.sunsat.sathish.j2ee.health.login.controller;

import com.sunsat.sathish.j2ee.health.base.pojo.model.FormModel;
import com.sunsat.sathish.j2ee.health.login.loginException.LoginException;
import com.sunsat.sathish.j2ee.health.login.pojo.model.LoginResponseModel;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;
import com.sunsat.sathish.j2ee.health.login.service.LoginBusinessService;
import com.sunsat.sathish.j2ee.health.login.service.UserBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;

/**
 * Created by sathishkumar_su on 4/17/2018.
 */
@Controller
public class LoginController {

    @Autowired
    LoginBusinessService loginService;

    @Autowired
    UserBusinessService userService;


    @RequestMapping(value = {"/homepage.an","/"," * "},method = RequestMethod.GET)
    public String loadHomePage() {
        //loginService.createNewUser(new UserFormModel());
        return "homepage";
    }

    @RequestMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public UserFormModel peformLogin(@RequestParam  UserFormModel model, HttpServletRequest request, HttpServletResponse response) {

        HttpSession ses = request.getSession(true);
        if(ses.isNew()) {

        } else {
            ses.invalidate();
            ses = request.getSession(true);
        }
        UserFormModel model1 = new UserFormModel();
        model1.setUserName("Hello");
        model1.setPassword("Good");

        return new UserFormModel();
    }

    @RequestMapping(value="/signUpAction.an", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserFormModel performSignUp(@RequestBody UserFormModel model,HttpServletRequest request,HttpServletResponse response) {

        UserFormModel resModel = new UserFormModel();
        resModel.setMessage("success");

        String userName = model.getUserName();
        String password = model.getPassword();
        String emailId = model.getMailId();
        String cnfPassword = model.getConfirmPassword();

        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password) || StringUtils.isEmpty(emailId) || StringUtils.isEmpty(cnfPassword)) {
            resModel.setMessage("Please provide all necessary data.");
        } else {
            resModel = userService.createNewUser(model);
        }
        return  resModel;
    }


    @RequestMapping(value = "/passwordReset.do", method = RequestMethod.POST)
    public LoginResponseModel performPasswordReset() {
        return new LoginResponseModel();
    }

    @RequestMapping(value = "/checkExistingUserName.an", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserFormModel checkExistingUserName(@RequestBody UserFormModel model) {
        UserFormModel retModel = userService.getExistingUser(model);
        return retModel;
    }

}
