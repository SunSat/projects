package com.sunsat.sathish.j2ee.loginapp.login.controller;

import com.sunsat.sathish.j2ee.loginapp.login.pojo.formModel.LogingFormModel;
import com.sunsat.sathish.j2ee.loginapp.util.ApplicationHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;

/**
 * Created by anitha on 5/1/2018.
 */
@Controller
public class LoginController {

    //org.apache.log4j.Logger logger  = org.apache.log4j.Logger.getLogger(LoginController.class);

    @RequestMapping(value = {"/homepage.an","/"," * "},method = RequestMethod.GET)
    public String showHome(HttpServletRequest request) {
        ApplicationHelper.clearCookie(request);
        ApplicationHelper.clearSession(request);
        return "homepage";
    }

    @RequestMapping("/sample.do")
    public String performSample(ModelMap map) {
        LogingFormModel formModel = new LogingFormModel();
        /*formModel.setUserId(1);
        formModel.setUserName("satunar");
        formModel.setLoggedTime(new Date());
        formModel.setMessage("successful");
        formModel.setFullUserName("Sathish Kumar Sundara");
        formModel.setMailId("sundar.sat84@gmail.com");*/
        map.put("user",formModel);
        return "sample";
    }

    @ResponseBody
    @RequestMapping(value = "/loginAction.an", method = RequestMethod.POST)
    public LogingFormModel PerformLogin(@RequestBody LogingFormModel model, HttpServletRequest request, HttpServletResponse response) {

        LogingFormModel formModel = new LogingFormModel();

        boolean isSuccess = true;
        if(!model.getUserName().equals("1") || !model.getPassword().equals("1")) {
            formModel.setMessage("unsuccessful");
            return formModel;
        }

        formModel.setMessage("successful");
        formModel.setUserId(1l);
        formModel.setUserName(model.getUserName());
        formModel.setMailId("sundar.sat84@gmail.com");

        Cookie cookie = new Cookie("userId",formModel.getUserId()+"");
        cookie.setMaxAge(60 * 3);
        response.addCookie(cookie);

        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(60 * 3);
        if(session.isNew()) {
            session.setAttribute("user", formModel);
        }
        formModel.setSessionId(session.getId());
        return formModel;
    }

    @ResponseBody
    @RequestMapping(value = "/signUpAction.an",method = RequestMethod.POST)
    public LogingFormModel performSignUp(HttpServletRequest request) {
        String uName = request.getParameter("uName");
        String password = request.getParameter("password");
        LogingFormModel formModel = new LogingFormModel();
        /*formModel.setUserId(null);
        formModel.setUserName(uName);
        formModel.setMessage("User "+uName+" created successfully. Please check your mail your mail for confirmation.");*/
        return formModel;
    }

    @ResponseBody
    @RequestMapping(value = "/logoutAction.do", method = RequestMethod.POST)
    public LogingFormModel performLogout(HttpServletRequest request,@RequestBody LogingFormModel formModel) {
        String sessionId = formModel.getSessionId();
        Long userId = formModel.getUserId();
        String userName = formModel.getUserName();

        Cookie[] cooArr = request.getCookies();
        for(Cookie cookie  : cooArr) {
            if(cookie.getName().equals("userId")) {
                cookie.setMaxAge(0);
                break;
            }
        }
        request.getSession().invalidate();
        return formModel;
    }
}
