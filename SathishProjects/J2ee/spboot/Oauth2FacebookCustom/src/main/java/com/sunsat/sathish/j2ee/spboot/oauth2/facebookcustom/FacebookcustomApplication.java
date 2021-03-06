package com.sunsat.sathish.j2ee.spboot.oauth2.facebookcustom;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Configuration
@PropertySource("classpath:application.properties")
public class FacebookcustomApplication  extends WebSecurityConfigurerAdapter {

    private static java.util.List<String> clients = Arrays.asList("google");
    private static String CLIENT_PROPERTY_KEY = "spring.security.oauth2.client.registration.";

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(FacebookcustomApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests().anyRequest().authenticated().and().oauth2Login().
                clientRegistrationRepository(clientRegistrationRepository()).
                authorizedClientService(authorizedClientService());*/
        http.authorizeRequests().antMatchers("/oauth_login").
                permitAll().anyRequest().authenticated().and().oauth2Login().loginPage("/oauth_login");
    }

    @Bean
    public OAuth2AuthorizedClientService oAuth2AuthorizedClientService() {
        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        List<ClientRegistration> registrations = clients.stream()
                .map(c -> getRegistration(c))
                .filter(registration -> registration != null)
                .collect(Collectors.toList());

        return new InMemoryClientRegistrationRepository(registrations);
    }

    private ClientRegistration getRegistration(String client) {
        String clientId = env.getProperty(
                CLIENT_PROPERTY_KEY + client + ".client-id");

        if (clientId == null) {
            return null;
        }

        String clientSecret = env.getProperty(CLIENT_PROPERTY_KEY + client + ".client-secret");

        if (client.equals("google")) {
            return CommonOAuth2Provider.GOOGLE.getBuilder(client)
                    .clientId(clientId).clientSecret(clientSecret).build();
        }

        return null;
    }
}
