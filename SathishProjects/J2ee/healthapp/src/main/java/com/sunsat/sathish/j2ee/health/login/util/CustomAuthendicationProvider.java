package com.sunsat.sathish.j2ee.health.login.util;

import com.sunsat.sathish.j2ee.health.login.pojo.business.RoleBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;
import com.sunsat.sathish.j2ee.health.login.service.UserAccountBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class CustomAuthendicationProvider implements AuthenticationProvider {

    @Autowired
    UserAccountBusinessService userService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        UserFormModel model = new UserFormModel();
        model.setUserName(userName);
        model.setPassword(password);
        model = userService.performLogin(model);
        if(model.getMessage().equalsIgnoreCase("successful")) {
            UserBusiness ub = userService.getExistingUser(model);
            List<RoleBusiness> rbList = ub.getRoleBusinesses();
            List<GrantedAuthority> authorities = new ArrayList<>(1);
            for(RoleBusiness rb : rbList) {
                authorities.add(new SimpleGrantedAuthority(rb.getRoleName()));
            }
            return new UsernamePasswordAuthenticationToken(ub,"",authorities);
        }
        throw new BadCredentialsException(model.getMessage());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
