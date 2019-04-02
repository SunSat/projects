package com.sunsat.sathish.j2ee.security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SecuritydemoApplication extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(SecuritydemoApplication.class, args);
    }


    @GetMapping("/sample")
    public String getSample() {
        return "sample-111122";
    }

    @GetMapping("/student111")
    public String getStudent() {
        return "<form action='/logout'><button type='submit'>Logout</button></form>";
    }

    @GetMapping()
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/sample").permitAll().anyRequest().authenticated().and().formLogin().and().logout().invalidateHttpSession(true).clearAuthentication(true);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("sat").password("{noop}sat").roles("USER");
    }
}
