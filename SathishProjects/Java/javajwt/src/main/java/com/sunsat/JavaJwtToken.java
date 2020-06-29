package com.sunsat;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class JavaJwtToken {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        String st = "hello world";
        byte[] messageDigest = md.digest(st.getBytes());
        SecretKey jwtKey = Keys.hmacShaKeyFor(messageDigest);
        String jwts1 = Jwts.builder().setIssuer("hello").setSubject("sat").signWith(jwtKey,SignatureAlgorithm.HS512).compact();
        System.out.println(jwts1);
        System.out.println(Jwts.parserBuilder().setSigningKey(jwtKey).build().parseClaimsJws(jwts1));

    }
}
