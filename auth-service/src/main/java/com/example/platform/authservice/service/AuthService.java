package com.example.platform.authservice.service;

import com.example.platform.authservice.dto.request.LoginRequest;
import com.example.platform.authservice.dto.request.RefreshTokenRequest;
import com.example.platform.authservice.dto.request.RegisterRequest;
import com.example.platform.authservice.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse login(LoginRequest request);

    AuthResponse refreshToken(RefreshTokenRequest request);

    void logout(String refreshToken);

    void register(RegisterRequest request);
}
