package com.example.platform.accountservice.repository;

import com.example.platform.accountservice.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {
    List<AccountEntity> findByCustomerId(UUID customerId);
}
