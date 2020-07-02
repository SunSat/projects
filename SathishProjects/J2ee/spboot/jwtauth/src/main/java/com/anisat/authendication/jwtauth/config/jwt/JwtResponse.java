package com.anisat.authendication.jwtauth.config.jwt;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class JwtResponse {

    public JwtResponse(String accessToken) {
        this.accessToken = accessToken;
    }
    private String accessToken;
}
