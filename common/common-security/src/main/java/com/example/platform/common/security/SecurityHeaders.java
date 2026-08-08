package com.example.platform.common.security;

import java.util.Collections;
import java.util.Map;

public final class SecurityHeaders {
    public static final Map<String, String> DEFAULT_SECURITY_HEADERS = Collections.unmodifiableMap(
            Map.of(
                    "X-Frame-Options", "DENY",
                    "X-Content-Type-Options", "nosniff",
                    "X-XSS-Protection", "1; mode=block",
                    "Referrer-Policy", "strict-origin-when-cross-origin"
            )
    );

    private SecurityHeaders() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }
}
