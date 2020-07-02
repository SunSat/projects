package com.anisat.authendication.jwtauth.controller;

import com.anisat.authendication.jwtauth.controller.model.UserModel;
import com.anisat.authendication.jwtauth.service.JwtUserDetailsService;
import com.anisat.authendication.jwtauth.service.convertor.JwtServiceConvertor;
import com.anisat.authendication.jwtauth.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class HomepageController {

    @Autowired
    JwtUserDetailsService userDetailsService;

    @Autowired
    JwtServiceConvertor jwtServiceConvertor;

    @GetMapping("/home")
    public String loadHomePage() {
        return "home";
    }
}
