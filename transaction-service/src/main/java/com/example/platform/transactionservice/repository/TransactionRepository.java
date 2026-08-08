package com.example.platform.transactionservice.repository;

import com.example.platform.transactionservice.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {
    List<TransactionEntity> findByAccountId(UUID accountId);
}
