package com.example.platform.common.security;

public final class SecurityConstants {
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";
    public static final String CORRELATION_ID_HEADER = "X-Correlation-Id";
    public static final String TRACE_ID_HEADER = "X-Trace-Id";
    public static final String REQUEST_ID_HEADER = "X-Request-Id";
    public static final String SECURITY_CONTEXT_HEADER = "X-Security-Context";
    public static final String CSRF_HEADER = "X-CSRF-Token";

    private SecurityConstants() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }
}
