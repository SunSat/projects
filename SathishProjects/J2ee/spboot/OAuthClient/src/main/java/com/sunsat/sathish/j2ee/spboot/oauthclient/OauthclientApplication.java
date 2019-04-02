package com.sunsat.sathish.j2ee.spboot.oauthclient;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableOAuth2Sso
@Configuration
public class OauthclientApplication extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable().
                antMatcher("/**").authorizeRequests().
                antMatchers("/","/login**").permitAll().
                anyRequest().authenticated();
    }


    public static void main(String[] args) {
        SpringApplication.run(OauthclientApplication.class, args);
    }

}
