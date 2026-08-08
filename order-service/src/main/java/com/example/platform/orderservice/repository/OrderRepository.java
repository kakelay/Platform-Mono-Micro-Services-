package com.example.platform.orderservice.repository;

import com.example.platform.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    List<OrderEntity> findByCustomerId(UUID customerId);
    List<OrderEntity> findByAccountId(UUID accountId);
}
