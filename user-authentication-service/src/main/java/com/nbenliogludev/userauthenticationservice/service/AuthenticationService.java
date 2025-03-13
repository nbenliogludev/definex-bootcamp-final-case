package com.nbenliogludev.userauthenticationservice.service;

import com.nbenliogludev.userauthenticationservice.dto.request.UserCreateRequestDTO;
import com.nbenliogludev.userauthenticationservice.dto.response.AuthenticationResponseDTO;
import com.nbenliogludev.userauthenticationservice.entity.Role;
import com.nbenliogludev.userauthenticationservice.entity.Token;
import com.nbenliogludev.userauthenticationservice.entity.TokenType;
import com.nbenliogludev.userauthenticationservice.entity.User;
import com.nbenliogludev.userauthenticationservice.repository.TokenRepository;
import com.nbenliogludev.userauthenticationservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationResponseDTO register(UserCreateRequestDTO request) {
        User user = User.builder()
                .firstname(request.name())
                .lastname(request.surname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();

        User savedUser = repository.save(user);

        var jwtToken = jwtService.generateTokenWithUserId(user, savedUser.getId());
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponseDTO.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .id(savedUser.getId()) // Include userId in response
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }
}
