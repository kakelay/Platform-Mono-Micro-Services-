package com.example.platform.authservice.config;

import com.example.platform.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Value("${security.jwt.secret:default-jwt-secret-key-default-jwt-secret-key}")
    private String jwtSecret;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/v1/auth/login", "/api/v1/auth/register", "/api/v1/auth/refresh").permitAll()
                        .requestMatchers("/actuator/**").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt())
                .httpBasic(httpBasic -> httpBasic.disable());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKey secretKey = new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(secretKey).build();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return authentication -> {
            String username = authentication.getName();
            String password = authentication.getCredentials().toString();
            var user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new RuntimeException("Invalid credentials");
            }
            return new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                    user.getUsername(), null, java.util.List.of());
        };
    }
}
