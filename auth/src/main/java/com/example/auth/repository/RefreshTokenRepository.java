package com.example.auth.repository;

import com.example.auth.entities.RefreshToken;
import com.example.auth.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Integer> {
    Optional<RefreshToken> findByToken(String token);

    UserInfo findByUsernameAndPassword(String username, String password);
}
