package com.sunsat.sathish.j2ee.health.login.controller;

import com.sunsat.sathish.j2ee.health.base.businessService.BaseBusinessService;
import com.sunsat.sathish.j2ee.health.base.pojo.model.FormModel;
import com.sunsat.sathish.j2ee.health.login.loginException.LoginException;
import com.sunsat.sathish.j2ee.health.login.pojo.business.CommunicationBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.model.LoginResponseModel;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;
import com.sunsat.sathish.j2ee.health.login.service.CommunicationBusinessService;
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

    @Autowired
    CommunicationBusinessService communicationService;

    @RequestMapping(value = {"/homepage.an","/","/index.jsp"},method = RequestMethod.GET)
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
        String userName = model.getUserName();
        String password = model.getPassword();
        String emailId = model.getMailId();
        String cnfPassword = model.getConfirmPassword();

        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password) || StringUtils.isEmpty(emailId) || StringUtils.isEmpty(cnfPassword)) {
            resModel.setResponseMessage("Please provide all necessary data.");
            resModel.setResponseStatus("Error");
            return resModel;
        }

        resModel = userService.getExistingUser(model);
        String existUserName = resModel.getUserName();
        if (existUserName != null && existUserName.trim().length() > 0) {
            resModel.setResponseMessage("User Already Exists. Please give different UserName.");
            resModel.setResponseStatus("Error");
        } else {
            resModel = userService.createNewUser(model);
            Long newPrimaryKeyId = resModel.getPrimarykeyId();
            if(newPrimaryKeyId != null &&  newPrimaryKeyId > 0) {
                communicationService.createNewCommunication(resModel);
                resModel.setResponseMessage("User Successfully Created. Please verify your EMail.");
                resModel.setResponseStatus("successful");
            } else {
                resModel.setResponseMessage("Error Creting new Uesr. Please try after sometime.");
                resModel.setResponseStatus("Error");
            }
        }
        return  resModel;
    }


    @RequestMapping(value = "/passwordReset.do", method = RequestMethod.POST)
    public LoginResponseModel performPasswordReset() {
        return new LoginResponseModel();
    }

    @RequestMapping(value = "/checkUserNameForSignUp.an", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserFormModel checkExistingUserName(@RequestBody UserFormModel model) {
        UserFormModel retModel = userService.getExistingUser(model);
        String uName = retModel.getUserName();
        if(null != uName && uName.trim().length() > 0 ) {
            retModel.setResponseStatus("Error");
            retModel.setResponseMessage("UserName Exists.");
        } else {
            retModel.setResponseStatus("successful");
            retModel.setResponseMessage("UserName Not Exists.");
        }
        return retModel;
    }

}
