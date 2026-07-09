package com.uca.pncparcialfinalhotel.service.impl;


import com.uca.pncparcialfinalhotel.dto.request.LoginRequest;
import com.uca.pncparcialfinalhotel.dto.request.RefreshTokenRequest;
import com.uca.pncparcialfinalhotel.dto.response.AuthResponse;
import com.uca.pncparcialfinalhotel.util.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {

    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        String accessToken = jwtService.generateAccessToken(request.email());
        String refreshToken = jwtService.generateRefreshToken(request.email());
        return new AuthResponse(accessToken, refreshToken);
    }

    public AuthResponse refreshToken(RefreshTokenRequest request) {
        String refreshToken = request.refreshToken();
        if (jwtService.isTokenValid(refreshToken)) {
            String email = jwtService.extractUsername(refreshToken);
            String newAccessToken = jwtService.generateAccessToken(email);
            return new AuthResponse(newAccessToken, refreshToken);
        }
        throw new RuntimeException("Refresh token inválido o expirado");
    }
}