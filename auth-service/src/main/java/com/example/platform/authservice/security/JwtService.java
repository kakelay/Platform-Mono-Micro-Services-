package com.example.platform.authservice.security;

import com.example.platform.authservice.entity.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class JwtService {

    private final JwtEncoder jwtEncoder;
    private final long accessTokenExpirationSeconds;
    private final long refreshTokenExpirationSeconds;

    public JwtService(JwtEncoder jwtEncoder,
                      @Value("${security.jwt.access-token-expire-seconds:900}") long accessTokenExpirationSeconds,
                      @Value("${security.jwt.refresh-token-expire-seconds:2592000}") long refreshTokenExpirationSeconds) {
        this.jwtEncoder = jwtEncoder;
        this.accessTokenExpirationSeconds = accessTokenExpirationSeconds;
        this.refreshTokenExpirationSeconds = refreshTokenExpirationSeconds;
    }

    public String createAccessToken(UserEntity user) {
        Instant issuedAt = Instant.now();
        Instant expiresAt = issuedAt.plus(accessTokenExpirationSeconds, ChronoUnit.SECONDS);

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("auth-service")
                .issuedAt(issuedAt)
                .expiresAt(expiresAt)
                .subject(user.getUsername())
                .claim("user_id", user.getId().toString())
                .claim("roles", user.getRoles().stream().map(r -> r.getName()).toList())
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public String createRefreshToken(UserEntity user) {
        Instant issuedAt = Instant.now();
        Instant expiresAt = issuedAt.plus(refreshTokenExpirationSeconds, ChronoUnit.SECONDS);

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("auth-service")
                .issuedAt(issuedAt)
                .expiresAt(expiresAt)
                .subject(user.getUsername())
                .claim("type", "refresh")
                .claim("user_id", user.getId().toString())
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
