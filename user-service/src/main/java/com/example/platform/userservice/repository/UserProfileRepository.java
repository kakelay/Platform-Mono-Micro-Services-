package com.example.platform.userservice.repository;

import com.example.platform.userservice.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, UUID> {
    Optional<UserProfileEntity> findByAuthUserId(String authUserId);
}
