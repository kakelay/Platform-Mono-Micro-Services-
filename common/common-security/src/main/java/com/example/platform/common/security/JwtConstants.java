package com.example.platform.common.security;

import java.time.Duration;

public final class JwtConstants {
    public static final String TOKEN_TYPE = "JWT";
    public static final String CLAIM_AUTHORITIES = "authorities";
    public static final String CLAIM_USER_ID = "user_id";
    public static final String ISSUER = "platform-auth-service";
    public static final Duration ACCESS_TOKEN_EXPIRE = Duration.ofMinutes(15);
    public static final Duration REFRESH_TOKEN_EXPIRE = Duration.ofDays(30);

    private JwtConstants() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }
}
