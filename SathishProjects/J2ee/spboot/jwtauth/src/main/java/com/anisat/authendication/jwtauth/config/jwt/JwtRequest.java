package com.anisat.authendication.jwtauth.config.jwt;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class JwtRequest {
    String username;
    String password;
}
