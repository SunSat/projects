package com.anisat.authendication.jwtauth.config.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.anisat.authendication.jwtauth.config.jwt.Constants.*;

@Configuration
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    //OrRequestMatcher matcher;

    AntPathRequestMatcher matcher;

    public JwtAuthenticationFilter() {

    }

    @PostConstruct
    public void init() {
        /*matcher = new OrRequestMatcher(
                new AntPathRequestMatcher(ACCESS_TOKEN_URL,"POST"),
                new AntPathRequestMatcher(REFRESH_TOKEN_URL,"POST")
        );*/
        matcher = new AntPathRequestMatcher(ACCESS_TOKEN_URL+"/**", "POST");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if(!matcher.matches(request)) {
            String header = request.getHeader(HEADER_STRING);
            String username = null;
            String authToken = null;

            if (header != null && header.startsWith(TOKEN_PREFIX)) {
                authToken = header.replace(TOKEN_PREFIX,"");
                try {
                    username = jwtTokenUtil.getUsernameFromToken(authToken);
                } catch (IllegalArgumentException e) {
                    logger.error("an error occured during getting username from token", e);
                    throw e;
                } catch (ExpiredJwtException e) {
                    logger.warn("the token is expired and not valid anymore", e);
                    throw e;
                } catch(SignatureException e){
                    logger.error("Authentication Failed. Username or Password not valid.");
                    throw e;
                }
            } else {
                logger.warn("couldn't find bearer string, will ignore the header");
            }

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    logger.info("authenticated user " + username + ", setting security context");
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
