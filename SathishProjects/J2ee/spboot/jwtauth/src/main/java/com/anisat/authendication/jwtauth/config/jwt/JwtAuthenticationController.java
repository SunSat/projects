package com.anisat.authendication.jwtauth.config.jwt;

import com.anisat.authendication.jwtauth.controller.model.UserModel;
import com.anisat.authendication.jwtauth.service.JwtUserDetailsService;
import com.anisat.authendication.jwtauth.service.convertor.JwtServiceConvertor;
import com.anisat.authendication.jwtauth.service.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

import static com.anisat.authendication.jwtauth.config.jwt.Constants.HEADER_STRING;
import static com.anisat.authendication.jwtauth.config.jwt.Constants.TOKEN_PREFIX;

@RestController
@CrossOrigin
@Log4j2
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private JwtServiceConvertor jwtServiceConvertor;

    @RequestMapping(value = "/authendicate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        String userName = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        if (authentication.isAuthenticated()) {
            UserDto userDto = userDetailsService.loadByUserName(userName);
            final String token = jwtTokenUtil.generateToken(userDto);
            return ResponseEntity.ok(new JwtResponse(token));
        }
        return ResponseEntity.ok(401);
    }

    @PostMapping("/authendicate/signup")
    public String createNewUser(@RequestBody UserModel userModel) {
        UserDto userDto = jwtServiceConvertor.getUserDtoFromModel(userModel);
        userDto.setAuthorities(Arrays.asList("USER"));
        userDto = userDetailsService.createNewUser(userDto);
        return "User Created Successfully.";
    }

    @RequestMapping(value = "/authendicate/referesh", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationRefereshToken(@RequestHeader(name = HEADER_STRING) String authTokenHeader) throws Exception {

        String authToken = "";
        Claims claims = null;
        if (authTokenHeader != null && authTokenHeader.startsWith(TOKEN_PREFIX)) {
            authToken = jwtTokenUtil.generateRefereshToken(authTokenHeader.replace(TOKEN_PREFIX, ""));
        } else {
            throw new RuntimeException("No Token");
        }
        return ResponseEntity.ok(new JwtResponse(authToken));
    }
}
