package com.example.platform.common.security;

public final class JwtUtils {

    private JwtUtils() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }

    public static String resolveToken(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith(SecurityConstants.BEARER_PREFIX)) {
            return null;
        }
        return authorizationHeader.substring(SecurityConstants.BEARER_PREFIX.length()).trim();
    }

    public static boolean isBearerAuthorization(String authorizationHeader) {
        return authorizationHeader != null && authorizationHeader.startsWith(SecurityConstants.BEARER_PREFIX);
    }

    public static String buildBearerToken(String token) {
        return SecurityConstants.BEARER_PREFIX + token;
    }
}
