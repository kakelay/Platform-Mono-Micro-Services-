package com.example.platform.authservice.repository;

import com.example.platform.authservice.entity.RefreshTokenEntity;
import com.example.platform.authservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, UUID> {
    Optional<RefreshTokenEntity> findByToken(String token);
    void deleteByUser(UserEntity user);
}
