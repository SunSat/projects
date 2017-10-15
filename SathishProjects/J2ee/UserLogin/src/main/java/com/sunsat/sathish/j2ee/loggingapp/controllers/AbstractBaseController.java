package com.sunsat.sathish.j2ee.loggingapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ssundar2 on 24-02-2017.
 */

@Controller
@RequestMapping("/")
public class AbstractBaseController {

    @RequestMapping (method= RequestMethod.GET)
    public void processRequest(ModelMap model) {
        //check all the username
    }
}
