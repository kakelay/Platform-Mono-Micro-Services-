package com.example.platform.paymentservice.repository;

import com.example.platform.paymentservice.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID> {
    List<PaymentEntity> findByOrderId(UUID orderId);
    List<PaymentEntity> findByAccountId(UUID accountId);
}
