package com.sunsat.sathish.j2ee.loggingapp.controllers;

import com.sunsat.sathish.j2ee.loggingapp.pojo.dto.LogingDto;
import com.sunsat.sathish.j2ee.loggingapp.pojo.model.LoggingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ssundar2 on 24-02-2017.
 */
@Controller
@RequestMapping("/login.sp")
public class LoginUserController {

    @Autowired
    LoggingModel model;

    @Autowired
    LogingDto logingDto;

    /*@ModelAttribute
    public LoggingModel addLoggingModel() {
        return model;
    }*/

    @RequestMapping(method = RequestMethod.POST, params = "Login")
    public String performLogingOperation(@ModelAttribute LoggingModel model) {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, params = "NewUser")
    public String performSignUpOperation() {
        return "user";
    }
}
