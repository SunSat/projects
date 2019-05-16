package com.sunsat.sathish.j2ee.health.login.controller;

import com.sunsat.sathish.j2ee.health.base.util.mail.communicator.MailCommunicator;
import com.sunsat.sathish.j2ee.health.base.util.mail.pojo.business.MailBusiness;
import com.sunsat.sathish.j2ee.health.base.util.GeneralAppUtil;
import com.sunsat.sathish.j2ee.health.base.util.template.pojo.TemplateModel;
import com.sunsat.sathish.j2ee.health.base.util.template.service.TemplateBusinessService;
import com.sunsat.sathish.j2ee.health.login.pojo.business.CommunicationBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.LoginBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.RoleBusiness;
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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.java2d.loops.FillRect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.*;

import static com.sunsat.sathish.j2ee.health.base.util.GeneralConstants.*;

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

    @Autowired
    TemplateBusinessService templateBusinessService;



    @RequestMapping(value = {"/homepage.an","/","/index.jsp"},method = RequestMethod.GET)
    public String loadHomePage(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
        UserBusiness ub = GeneralAppUtil.getLoggedUserDetails();
        Long count = 0l;//userService.getLikeCount();
        modelMap.put(LIKE_COUNT,count);
        boolean isAdmin = false;
        if(ub.getUserName().equalsIgnoreCase(ANNOYMOUS_USER)) {
            session.setAttribute(LOGGED_USER_ID,0);
        } else {
            session.setAttribute(LOGGED_USER_ID,ub.getPrimaryKeyId());
            session.setAttribute(LOGGED_USER_NAME,ub.getUserName());
            modelMap.put(USER_LIKE,ub.isUserLike());
            isAdmin = GeneralAppUtil.isAdmin();
            session.setAttribute(IS_ADMIN,isAdmin);
        }
        return "homepage";
        /*return "sample_react";*/
    }

    @RequestMapping(value = "/loginAction.an", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public @ResponseBody UserFormModel peformLogin(@ModelAttribute UserFormModel model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Authentication newAuth = null;
        String exception = "";
        try {
            newAuth = authManager.authenticate(new UsernamePasswordAuthenticationToken(model.getUserName(),model.getPassword()));
            if(newAuth.isAuthenticated()) {
                GeneralAppUtil.setAuthentication(newAuth);
                UserBusiness ub = (UserBusiness) newAuth.getPrincipal();
                model.setPrimarykeyId(ub.getPrimaryKeyId());
                userService.createOrUpdateLogin(model);
                model.setResponseStatus("successful");
                model.setResponseMessage("successful");
                model.setUserName(ub.getUserName());
                model.setMessage("successful");
                /*model.setUserLike(ub.isUserLike());*/
                session.setAttribute(LOGGED_USER_NAME,ub.getUserName());
                session.setAttribute(LOGGED_USER_ID,ub.getPrimaryKeyId());
                boolean isAdmin = GeneralAppUtil.isAdmin();
                model.setAdmin(isAdmin);
                session.setAttribute(IS_ADMIN,isAdmin);
                model.setUserLike(ub.isUserLike());
                return model;
            }
        }catch(BadCredentialsException be) {
            exception = be.getMessage();
        }catch (UsernameNotFoundException un) {
            exception = un.getMessage();
        }
        model.setResponseStatus("error");
        model.setResponseMessage(exception);
        model.setAdmin(false);
        session.setAttribute(LOGGED_USER_ID,0);
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
        if(ub != null && ub.getUserName() != null && ub.getUserName().trim().equalsIgnoreCase(userName)) {
            resModel.setResponseMessage("User Already Exists. Please give different UserName.");
            resModel.setResponseStatus("Error");
        } else {
            //Create new User.
            model.setCreationTime(GeneralAppUtil.getCurrentTime());
            model.setExpiryTime(GeneralAppUtil.addDateTime(Calendar.DAY_OF_MONTH, PASSWORD_EXPIRE_DURATION_DAYS));
            model.setAccountStatus("INITIAL");
            model.setIsDeleted(0);
            ub = userService.createNewUser(model);
            model.setPrimarykeyId(ub.getPrimaryKeyId());
            //User Created Succsssfully.
            CommunicationBusiness cmb = userService.createCommunication(model);

            TemplateModel templateModel =new TemplateModel();
            templateModel.setTemplateName(NEW_USER_REGISTRATION_TEMPLATE_NAME);
            templateModel = templateBusinessService.getByTemplateName(templateModel);
            Map<String,Object> modelObject = new HashMap<>();
            modelObject.put("userName",ub.getUserName());
            modelObject.put("otp",cmb.getEmail1CnfToken());
            templateModel.setModelObject(modelObject);

            //Need to send a mail id.
            MailBusiness mb = new MailBusiness();
            List<String> li = new ArrayList();
            li.add(cmb.getEmail1());
            mb.setToAddress(li);
            mb.setSubject("Welcome Mail From HealthyLifeTechnique.com, Please activate your account.");
            mb.setBody(templateBusinessService.mergeTemplate(templateModel));
            mb.setFunctionality("NewUserRegistration");
            mb.setHasAttachement(false);
            mb.setSendDate(GeneralAppUtil.getCurrentTime());

            if(mailCommunicator.sendMail(mb)) {
                mb.setMailSent(true);
            } else {
                mb.setMailSent(false);
            }

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

    @RequestMapping(value = "/logoutAction.do",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserFormModel performLogout(@RequestBody UserFormModel model) {
        UserFormModel model1 = new UserFormModel();
        model1.setResponseStatus("successful");
        model1.setResponseMessage("successful");
        return model;
    }

    @RequestMapping(value = "/userLike.do",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserFormModel performUserLike(@RequestBody UserFormModel model) {
        Long updatedCount = userService.getLikeCount();
        Long userId = GeneralAppUtil.getLoggedUserId();
        model.setPrimarykeyId(userId);
        boolean needToUpdte = false;
        UserBusiness ub = userService.getExistingUserById(model);
        if("true".equalsIgnoreCase(model.getUserLike())) {
            if(!ub.isUserLike().equalsIgnoreCase("false")) {
                model.setUserLike("false");
                updatedCount--;
                ub.setUserLike("false");
                needToUpdte = true;
            }
        } else {
            if(!ub.isUserLike().equalsIgnoreCase("true")) {
                model.setUserLike("true");
                updatedCount++;
                ub.setUserLike("true");
                needToUpdte = true;
            }
        }
        if(needToUpdte) {
            userService.updateUser(ub);
            userService.setLikeCount(updatedCount);
            model.setUserLikeCount(updatedCount);
        }
        return model;
    }
}
