package com.anisat.health.heal.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@Configuration
public class HealthAppSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.authorizeRequests((a) -> {
                    a.antMatchers("/", "/error", "/webjars/**","/favicon.ico").permitAll().anyRequest().authenticated();
                }).exceptionHandling((e) -> { e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
                }).csrf((c) -> {c.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
                }).logout((l) -> {l.logoutSuccessUrl("/").permitAll();
                }).oauth2Login()
                .failureHandler((req, res, exception) -> {
                    req.getSession().setAttribute("error.message", exception.getMessage());
                });*/
        /*http.authorizeRequests(authCutomizer -> authCutomizer.antMatchers("/","/home","/webjars/**").permitAll().anyRequest().authenticated())
                .formLogin().loginPage("/login");*/

        http.addFilterBefore(new CUstomHttpAuthendicationFilter(), UsernamePasswordAuthenticationFilter.class).authorizeRequests().antMatchers("/","/home","/webjars/**","/resources/**","/getId","/greeting").
                permitAll().anyRequest().authenticated().and().formLogin().
                loginProcessingUrl("/login").and().logout().permitAll();


    }
    /*@Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }*/
}