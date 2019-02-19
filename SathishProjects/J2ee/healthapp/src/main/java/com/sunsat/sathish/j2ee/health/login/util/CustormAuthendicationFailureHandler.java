package com.sunsat.sathish.j2ee.health.login.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunsat.sathish.j2ee.health.base.pojo.model.FormModel;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustormAuthendicationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        FormModel model = new FormModel();
        model.setResponseStatus("failure");
        model.setResponseMessage("Invalid Username Or Password!");
        response.setContentType("application/json;charset=UTF-8");
        new ObjectMapper().writeValue(response.getWriter(),model);
    }
}
