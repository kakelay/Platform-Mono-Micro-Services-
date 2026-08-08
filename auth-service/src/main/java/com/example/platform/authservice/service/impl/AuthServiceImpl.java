package com.example.platform.authservice.service.impl;

import com.example.platform.authservice.dto.request.LoginRequest;
import com.example.platform.authservice.dto.request.RefreshTokenRequest;
import com.example.platform.authservice.dto.request.RegisterRequest;
import com.example.platform.authservice.dto.response.AuthResponse;
import com.example.platform.authservice.entity.RefreshTokenEntity;
import com.example.platform.authservice.entity.RoleEntity;
import com.example.platform.authservice.entity.UserEntity;
import com.example.platform.authservice.repository.RefreshTokenRepository;
import com.example.platform.authservice.repository.RoleRepository;
import com.example.platform.authservice.repository.UserRepository;
import com.example.platform.authservice.security.JwtService;
import com.example.platform.authservice.service.AuthService;
import com.example.platform.common.exception.BusinessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           RefreshTokenRepository refreshTokenRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.refreshTokenRepository = refreshTokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BusinessException("AUTH_USER_NOT_FOUND", "User not found"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BusinessException("AUTH_INVALID_CREDENTIALS", "Invalid username or password");
        }
        var accessToken = jwtService.createAccessToken(user);
        var refreshToken = jwtService.createRefreshToken(user);
        saveRefreshToken(user, refreshToken);
        return new AuthResponse(accessToken, refreshToken);
    }

    @Override
    @Transactional
    public AuthResponse refreshToken(RefreshTokenRequest request) {
        var refreshToken = refreshTokenRepository.findByToken(request.getRefreshToken())
                .orElseThrow(() -> new BusinessException("AUTH_REFRESH_TOKEN_INVALID", "Invalid refresh token"));
        if (refreshToken.getExpiresAt().isBefore(Instant.now())) {
            throw new BusinessException("AUTH_REFRESH_TOKEN_EXPIRED", "Refresh token expired");
        }
        var user = refreshToken.getUser();
        var newAccessToken = jwtService.createAccessToken(user);
        var newRefreshToken = jwtService.createRefreshToken(user);
        refreshTokenRepository.deleteByUser(user);
        saveRefreshToken(user, newRefreshToken);
        return new AuthResponse(newAccessToken, newRefreshToken);
    }

    @Override
    @Transactional
    public void logout(String refreshToken) {
        refreshTokenRepository.findByToken(refreshToken)
                .ifPresent(entity -> refreshTokenRepository.delete(entity));
    }

    @Override
    @Transactional
    public void register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new BusinessException("AUTH_USER_EXISTS", "Username is already in use");
        }
        var user = new UserEntity(UUID.randomUUID(), request.getUsername(), passwordEncoder.encode(request.getPassword()), request.getEmail());
        var defaultRole = roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> roleRepository.save(new RoleEntity("ROLE_USER")));
        user.setRoles(Set.of(defaultRole));
        userRepository.save(user);
    }

    private void saveRefreshToken(UserEntity user, String token) {
        var refreshTokenEntity = new RefreshTokenEntity(UUID.randomUUID(), user, token, Instant.now().plusSeconds(2592000));
        refreshTokenRepository.deleteByUser(user);
        refreshTokenRepository.save(refreshTokenEntity);
    }
}
