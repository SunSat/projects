package com.anisat.authendication.jwtauth.config.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


@Component
public class JwtTokenUtil {

    private String secretKey = "hello world";
    private String mdAlgorithm = "SHA-512";
    private Integer tokenExpiryMillSec = 60 * 60 * 1000;
    private Integer refereshTokenExpiryInMillSec = 100 * 1000;
    private SecretKey key;

    @PostConstruct
    public void init() throws NoSuchAlgorithmException{
        generateSignerKey();
    }

    private byte[] getEncryptedSecrete() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(mdAlgorithm);
        return md.digest(secretKey.getBytes());
    }

    private Key generateSignerKey() throws NoSuchAlgorithmException {
        key = Keys.hmacShaKeyFor(getEncryptedSecrete());
       return key;
    }

    public String generateToken(UserDetails user) throws NoSuchAlgorithmException {
        Map<String,Object> claimsMap = new HashMap<>();
        claimsMap.put("scopes",user.getAuthorities());
        claimsMap.put("refreshToken",true);
        long currentDate = System.currentTimeMillis();
        System.out.println("Current Date is : " + new Date(currentDate) + " &. Expire after" + new Date(currentDate + tokenExpiryMillSec));
        return Jwts.builder()
                .addClaims(claimsMap)
                .setIssuer("http://localhost:8080")
                .setIssuedAt(new Date(currentDate))
                .setExpiration(new Date(currentDate + tokenExpiryMillSec))
                .signWith(key,SignatureAlgorithm.HS512)
                .setId(UUID.randomUUID().toString())
                .setSubject(user.getUsername())
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

    private Jws<Claims> getParsedJwt(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
    }

}
