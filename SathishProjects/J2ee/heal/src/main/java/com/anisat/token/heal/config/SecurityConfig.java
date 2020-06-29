package com.anisat.token.heal.config;

import com.anisat.token.heal.config.handlers.LoginEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/index","/file/**","/webjars/**").permitAll()
                .anyRequest().authenticated().and()
                .formLogin()
                    .loginProcessingUrl("/manual_loggin")
                    .successHandler(loginEventHandler())
                    .permitAll()
                .and()
                .logout().logoutUrl("/logout")
                    .logoutSuccessUrl("/index")
                    .logoutSuccessHandler(loginEventHandler())
                .invalidateHttpSession(true).permitAll();

        http.oauth2Login();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("s")
                        .password("s")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public LoginEventHandler loginEventHandler() {
        return new LoginEventHandler();
    }

}
