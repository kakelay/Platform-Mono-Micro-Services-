package com.example.platform.authservice.repository;

import com.example.platform.authservice.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, String> {
    Optional<RoleEntity> findByName(String name);
}
