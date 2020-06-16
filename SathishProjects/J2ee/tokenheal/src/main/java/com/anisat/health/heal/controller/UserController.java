package com.anisat.health.heal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

@RestController
//@RequestMapping("/login")
public class UserController {


    //@GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @PostMapping("/login")
    @ResponseBody
    public boolean performLogin(HttpRequestHandler req) {
        return true;
    }

    @GetMapping("/getId")
    @ResponseBody
    public void getHomePage(HttpServletRequest req, HttpServletResponse res) {
        CsrfToken token = (CsrfToken) req.getAttribute(CsrfToken.class.getName());
        res.setHeader(token.getHeaderName(),token.getToken());
        res.setStatus(200);
    }

}
