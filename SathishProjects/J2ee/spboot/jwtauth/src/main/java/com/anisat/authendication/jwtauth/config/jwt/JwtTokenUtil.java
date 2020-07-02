package com.anisat.authendication.jwtauth.config.jwt;

import com.anisat.authendication.jwtauth.service.dto.UserDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import javax.swing.text.html.HTMLDocument;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import static com.anisat.authendication.jwtauth.config.jwt.Constants.*;


@Component
public class JwtTokenUtil {

    private SecretKey key;

    @PostConstruct
    public void init() throws NoSuchAlgorithmException{
        generateSignerKey();
    }

    private byte[] getEncryptedSecrete() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(MESSAGE_DIGEST_ALGORITHM);
        return md.digest(SECRET_KEY.getBytes());
    }

    private Key generateSignerKey() throws NoSuchAlgorithmException {
        key = Keys.hmacShaKeyFor(getEncryptedSecrete());
       return key;
    }

    public String generateToken(UserDto user) throws NoSuchAlgorithmException {
        Map<String,Object> claimsMap = new HashMap<>();
        claimsMap.put("scopes",user.getAuthorities());
        claimsMap.put("refreshToken",true);

        long currentDate = System.currentTimeMillis();
        return Jwts.builder()
                .addClaims(claimsMap)
                .setIssuer("http://localhost:8080")
                .setIssuedAt(new Date(currentDate))
                .setExpiration(new Date(currentDate + ACCESS_TOKEN_VALIDITY_SECONDS))
                .signWith(key,SignatureAlgorithm.HS512)
                .setId(UUID.randomUUID().toString())
                .setSubject(user.getUserName())
                .compact();

    }

    public String getUsernameFromToken(String token) {
        return getParsedJwt(token).getBody().getSubject();
    }

    public Date getExpirationDateFromToken(String token) {
        return getParsedJwt(token).getBody().getExpiration();
    }

    public boolean isTokenExpired(String token) {
        Date expirationDate = getParsedJwt(token).getBody().getExpiration();
        return expirationDate.before(new Date());
    }

    public Collection<GrantedAuthority> getScope(String token) {
        return (Collection<GrantedAuthority>)getParsedJwt(token).getBody().get("scopes");
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        Jws<Claims> parsedJwt = getParsedJwt(token);
        if(!parsedJwt.getBody().getSubject().equals(userDetails.getUsername())) {
            return false;
        }
        if(parsedJwt.getBody().getExpiration().before(new Date())) {
            return false;
        }
        return true;
    }

    public Jws<Claims> getParsedJwt(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
    }

    public String generateRefereshToken(String token) {
        String refereshToken = null;
        Claims claims = null;
        try {
            Jws<Claims> claimsJws = getParsedJwt(token);
            claims = claimsJws.getBody();
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        } catch (Exception e) {
            throw new RuntimeException("Invalid Token.");
        }
        if(null != claims) {
            UserDto userDto = new UserDto();
            userDto.setAuthorities(claims.get("scopes",List.class));
            userDto.setUserName(claims.getSubject());
            try {
                refereshToken = generateToken(userDto);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("No Such Algorithm");
            }
        }
        return refereshToken;
    }

}
