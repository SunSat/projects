package com.sunsat.sathish.j2ee.health.login.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunsat.sathish.j2ee.health.base.pojo.model.FormModel;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String userName = (String)authentication.getPrincipal();
        UserFormModel model = new UserFormModel();
        model.setUserName(userName);
        model.setResponseStatus("successful");
        response.setContentType("application/json;charset=UTF-8");
        (new ObjectMapper()).writeValue(response.getWriter(),model);
    }
}
