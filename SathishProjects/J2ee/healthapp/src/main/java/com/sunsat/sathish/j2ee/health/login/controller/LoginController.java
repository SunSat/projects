package com.sunsat.sathish.j2ee.health.login.controller;

import com.sunsat.sathish.j2ee.health.base.mail.communicator.MailCommunicator;
import com.sunsat.sathish.j2ee.health.base.util.GeneralAppUtil;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.model.LoginResponseModel;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;
import com.sunsat.sathish.j2ee.health.login.service.CommunicationBusinessService;
import com.sunsat.sathish.j2ee.health.login.service.UserAccountBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by sathishkumar_su on 4/17/2018.
 */
@Controller
public class LoginController {


    @Autowired
    UserAccountBusinessService userService;

    @Autowired
    CommunicationBusinessService communicationService;

    @Autowired
    MailCommunicator mailCommunicator;

    @Autowired
    @Qualifier("jdbcAuthenticationManager")
    AuthenticationManager authManager;

    @RequestMapping(value = {"/homepage.an","/","/index.jsp"},method = RequestMethod.GET)
    public String loadHomePage(HttpServletRequest request,HttpServletResponse response) {
        //loginService.createNewUser(new UserFormModel());
/*
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.getName() != null && auth.getName().equalsIgnoreCase("anonymousUser")) {
            return "homepage";
        }
        new SecurityContextLogoutHandler().logout(request,response,auth);
*/

        return "homepage";
    }

    @RequestMapping(value = "/loginAction.an", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public @ResponseBody UserFormModel peformLogin(@ModelAttribute UserFormModel model, HttpServletRequest request, HttpServletResponse response) {

        Authentication newAuth = null;
        try {
            newAuth = authManager.authenticate(new UsernamePasswordAuthenticationToken(model.getUserName(),model.getPassword()));
            if(newAuth.isAuthenticated()) {
                model.setMessage("successful");
                GeneralAppUtil.setAuthentication(newAuth);
                UserBusiness ub = (UserBusiness) newAuth.getPrincipal();
                model.setPrimarykeyId(ub.getPrimaryKeyId());
                userService.createOrUpdateLogin(model);
                model.setResponseStatus("successful");
                model.setResponseMessage("successful");
            }
        }catch(BadCredentialsException be) {
            model.setResponseStatus("error");
            model.setResponseMessage(be.getMessage());
        }catch (UsernameNotFoundException un) {
            model.setResponseStatus("error");
            model.setResponseMessage(un.getMessage());
        }
        return model;
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

        UserBusiness ub = userService.getExistingUser(model);
        if(ub != null && ub.getUserName().trim().equalsIgnoreCase(userName)) {
            resModel.setResponseMessage("User Already Exists. Please give different UserName.");
            resModel.setResponseStatus("Error");
        } else {
            //Create new User.
            Calendar cal = Calendar.getInstance(Locale.US);
            model.setCreationTime(cal.getTime());
            cal.add(Calendar.MONTH,3);
            model.setExpiryTime(cal.getTime());
            model.setAccountStatus("INITIAL");
            model.setIsDeleted(0);
            ub = userService.createNewUser(model);
            model.setPrimarykeyId(ub.getPrimaryKeyId());
            //User Created Succsssfully.
            userService.createCommunication(model);
            resModel.setResponseMessage("User Successfully Created. Please verify your EMail before Login.");
            resModel.setResponseStatus("successful");
        }
        return  resModel;
    }


    @RequestMapping(value = "/passwordReset.do", method = RequestMethod.POST)
    public LoginResponseModel performPasswordReset() {
        return new LoginResponseModel();
    }

    @RequestMapping(value = "/checkUserNameForSignUp.an", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserFormModel checkExistingUserName(@RequestBody UserFormModel model) {
        UserBusiness ub = userService.getExistingUser(model);
        UserFormModel retModel = new UserFormModel();
        String uName = ub.getUserName();
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
