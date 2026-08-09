package com.example.platform.gatewayservice.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;

@Configuration
@EnableWebFluxSecurity
public class GatewaySecurityConfig {

    @Value("${security.jwt.secret:default-secret-key-default-secret-key}")
    private String jwtSecret;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .csrf().disable()
                .authorizeExchange(exchange -> exchange
                        .pathMatchers(HttpMethod.OPTIONS).permitAll()
                        .pathMatchers("/actuator/**").permitAll()
                        .pathMatchers("/api/v1/auth/**").permitAll()
                        .pathMatchers("/api/v1/status/**").permitAll()
                        .pathMatchers("/api/v1/**").authenticated()
                        .anyExchange().permitAll())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt())
                .cors().and()
                .httpBasic().disable();
        return http.build();
    }

    @Bean
    public ReactiveJwtDecoder jwtDecoder() {
        SecretKey secretKey = new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA256");
        return NimbusReactiveJwtDecoder.withSecretKey(secretKey).build();
    }
}
