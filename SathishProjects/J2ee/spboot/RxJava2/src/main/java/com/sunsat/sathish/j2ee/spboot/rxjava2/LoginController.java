package com.sunsat.sathish.j2ee.spboot.rxjava2;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = {"/","/index"})
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginRequestHandler( HttpRequest request) {
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getAllStudentRequestHandler() {
        return "allStudent";
    }

}
