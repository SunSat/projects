package com.anisat.authendication.jwtauth.config.jwt;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    public JwtResponse(String accessToken) {
        this.accessToken = accessToken;
    }
    private String accessToken;
    private String refereshToken;
}
