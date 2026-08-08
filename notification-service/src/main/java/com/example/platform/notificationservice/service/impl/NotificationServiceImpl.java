package com.example.platform.notificationservice.service.impl;

import com.example.platform.common.exception.BusinessException;
import com.example.platform.notificationservice.dto.request.CreateNotificationRequest;
import com.example.platform.notificationservice.dto.request.UpdateNotificationRequest;
import com.example.platform.notificationservice.dto.response.NotificationResponse;
import com.example.platform.notificationservice.entity.NotificationEntity;
import com.example.platform.notificationservice.repository.NotificationRepository;
import com.example.platform.notificationservice.service.NotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;

    public NotificationServiceImpl(NotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public NotificationResponse createNotification(CreateNotificationRequest request) {
        var entity = new NotificationEntity();
        entity.setId(UUID.randomUUID());
        entity.setCustomerId(request.getCustomerId());
        entity.setType(request.getType());
        entity.setRecipient(request.getRecipient());
        entity.setMessage(request.getMessage());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(LocalDateTime.now());
        return toResponse(repository.save(entity));
    }

    @Override
    public NotificationResponse getNotification(UUID id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new BusinessException("NOTIFICATION_NOT_FOUND", "Notification not found"));
    }

    @Override
    public List<NotificationResponse> listNotifications() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public List<NotificationResponse> listNotificationsByCustomer(UUID customerId) {
        return repository.findByCustomerId(customerId).stream().map(this::toResponse).toList();
    }

    @Override
    public List<NotificationResponse> listNotificationsByStatus(String status) {
        return repository.findByStatus(status).stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional
    public NotificationResponse updateNotification(UUID id, UpdateNotificationRequest request) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new BusinessException("NOTIFICATION_NOT_FOUND", "Notification not found"));
        entity.setStatus(request.getStatus());
        return toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void deleteNotification(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("NOTIFICATION_NOT_FOUND", "Notification not found");
        }
        repository.deleteById(id);
    }

    private NotificationResponse toResponse(NotificationEntity entity) {
        return new NotificationResponse(entity.getId(), entity.getCustomerId(), entity.getType(), entity.getRecipient(), entity.getStatus(), entity.getMessage(), entity.getCreatedAt());
    }
}
