package com.sunsat.sathish.j2ee.loginapp.login.controller;

import com.sunsat.sathish.j2ee.loginapp.login.pojo.formModel.LoggedUserFormModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPBinding;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by anitha on 5/1/2018.
 */
@Controller
public class LoginController {

    org.apache.log4j.Logger logger  = org.apache.log4j.Logger.getLogger(LoginController.class);

    @RequestMapping(value = {"/homepage.do","/"," * "})
    public String showHome() {
        return "homepage";
    }

    @RequestMapping(value = "/loginSamePageAction.do", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public @ResponseBody LoggedUserFormModel performLogin(HttpServletRequest request) {

        String uName = request.getParameter("uname");
        String psw = request.getParameter("passwd");
        boolean isSuccess = true;
        LoggedUserFormModel formModel = new LoggedUserFormModel();
        formModel.setUserId(1);
        formModel.setUserName("satunar");
        formModel.setLoggedTime(new Date());
        formModel.setMessage("successful");
        formModel.setFullUserName("Sathish Kumar Sundara");
        formModel.setMailId("sundar.sat84@gmail.com");
        return formModel;
    }

    @RequestMapping(value = "/signSamePageUpAction.do", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public @ResponseBody LoggedUserFormModel performSignUpAction(HttpServletRequest request) {
        LoggedUserFormModel formModel = new LoggedUserFormModel();
        formModel.setUserId(1);
        formModel.setUserName("satunar");
        formModel.setLoggedTime(new Date());
        formModel.setMessage("successful");
        formModel.setFullUserName("Sathish Kumar Sundara");
        formModel.setMailId("sundar.sat84@gmail.com");
        return formModel;
    }

    @RequestMapping("/sample.do")
    public String performSample(ModelMap map) {
        LoggedUserFormModel formModel = new LoggedUserFormModel();
        formModel.setUserId(1);
        formModel.setUserName("satunar");
        formModel.setLoggedTime(new Date());
        formModel.setMessage("successful");
        formModel.setFullUserName("Sathish Kumar Sundara");
        formModel.setMailId("sundar.sat84@gmail.com");
        map.put("user",formModel);
        return "sample";
    }

    @ResponseBody
    @RequestMapping(value = "/loginAction.do", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoggedUserFormModel PerformLogin(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("");
        String uName = request.getParameter("loginUserName");
        String psw = request.getParameter("loginPassword");
        boolean isSuccess = true;
        LoggedUserFormModel formModel = new LoggedUserFormModel();
        formModel.setUserId(1);
        formModel.setUserName("satunar");
        formModel.setLoggedTime(new Date());
        formModel.setMessage("successful");
        formModel.setFullUserName("Sathish Kumar Sundara");
        formModel.setMailId("sundar.sat84@gmail.com");
        return formModel;
    }

    @ResponseBody
    @RequestMapping(value = "/signUpAction.do",method = RequestMethod.POST)
    public LoggedUserFormModel performSignUp(HttpServletRequest request) {
        String uName = request.getParameter("uName");
        String password = request.getParameter("password");
        LoggedUserFormModel formModel = new LoggedUserFormModel();
        formModel.setUserId(null);
        formModel.setUserName(uName);
        formModel.setMessage("User "+uName+" created successfully. Please check your mail your mail for confirmation.");
        return formModel;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public LoggedUserFormModel performLogout(HttpServletRequest request) {
        LoggedUserFormModel formModel = new LoggedUserFormModel();
        return formModel;
    }
}
