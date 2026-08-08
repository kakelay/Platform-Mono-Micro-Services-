package com.example.platform.notificationservice.repository;

import com.example.platform.notificationservice.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NotificationRepository extends JpaRepository<NotificationEntity, UUID> {
    List<NotificationEntity> findByCustomerId(UUID customerId);
    List<NotificationEntity> findByStatus(String status);
}
