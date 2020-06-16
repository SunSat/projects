package com.anisat.token.heal.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomePageController {

    @GetMapping({"/","/index","/home"})
    public String getHomePage(HttpServletRequest request) {
        if(request.getUserPrincipal() != null) {
            if(((UsernamePasswordAuthenticationToken)request.getUserPrincipal()).isAuthenticated()) {
                return "home";
            }
        }
        return "index";
    }

    @GetMapping("/getId")
    @ResponseBody
    public void getHomePage(HttpServletRequest req, HttpServletResponse res) {
        CsrfToken token = (CsrfToken) req.getAttribute(CsrfToken.class.getName());
        res.setHeader(token.getHeaderName(),token.getToken());
        res.setStatus(200);
    }
}
