package com.anisat.authendication.jwtauth.config.jwt;

public class Constants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
    public static final long REFRESH_TOKEN_VALIDITY_SECONDS = 100 * 1000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SECRET_KEY = "hello world";
    public static final String MESSAGE_DIGEST_ALGORITHM = "SHA-512";
    public static final String ACCESS_TOKEN_URL = "/authendicate";
    public static final String REFRESH_TOKEN_URL = "/authendicate/referesh";
}
