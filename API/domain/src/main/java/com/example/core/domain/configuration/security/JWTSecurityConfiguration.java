package com.example.core.domain.configuration.security;

public class JWTSecurityConfiguration {
    public static final long EXPIRATION_INTERVAL = 10 * 60 * 1000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER = "Authorization";
    public static final String TOKEN_NAME = "jwt";
}
