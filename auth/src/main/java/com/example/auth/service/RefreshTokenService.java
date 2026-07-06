package com.example.auth.service;

import com.example.auth.entities.RefreshToken;
import com.example.auth.entities.UserInfo;
import com.example.auth.repository.RefreshTokenRepository;
import com.example.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.AutowiredWebSecurityConfigurersIgnoreParents;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {


    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    UserRepository userRepository;

    public RefreshToken createRefreshToken(String username){
        UserInfo userInfoextracted = userRepository.findByUsername(username);
        RefreshToken refreshToken = RefreshToken.builder()
                .userInfo(userInfoextracted)
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(600000))
                .build();
        return refreshTokenRepository.save(refreshToken);

    }

    public RefreshToken verifyExpiration(RefreshToken refreshToken){
        if(refreshToken.getExpiryDate().compareTo(Instant.now()) <  0){
            refreshTokenRepository.delete(refreshToken);
            throw new RuntimeException("Refresh token expired");
        }
        return refreshToken;
    }

    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
    }

}
