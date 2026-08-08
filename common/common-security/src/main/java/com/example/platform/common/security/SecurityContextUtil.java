package com.example.platform.common.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class SecurityContextUtil {

    private SecurityContextUtil() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }

    public static String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        Object principal = authentication.getPrincipal();
        return principal instanceof String ? (String) principal : principal != null ? principal.toString() : null;
    }

    public static boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated();
    }

    public static List<String> getAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return List.of();
        }
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        return authorities == null ? List.of() : authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }
}
