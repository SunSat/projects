package com.sunsat.sathish.j2ee.health.login.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;
import com.sunsat.sathish.j2ee.health.login.service.UserAccountBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
    @Autowired
    UserAccountBusinessService userAccountBusinessService;
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        super.onLogoutSuccess(request,response,authentication);
        UserBusiness ub = (UserBusiness)authentication.getPrincipal();
        UserFormModel model = new UserFormModel();
        model.setPrimarykeyId(ub.getPrimaryKeyId());
        model.setUserName(ub.getUserName());
        model.setAccountStatus("LOGOUT");
        userAccountBusinessService.updateLogin(model);

        model = new UserFormModel();
        model.setUserName("");
        model.setResponseStatus("successful");
        model.setResponseMessage(ub.getUserName() + "Logout Successfully.");
        response.setContentType("application/json;charset=UTF-8");
        (new ObjectMapper()).writeValue(response.getWriter(),model);
    }
}
