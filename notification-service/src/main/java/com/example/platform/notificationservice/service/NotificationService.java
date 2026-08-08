package com.example.platform.notificationservice.service;

import com.example.platform.notificationservice.dto.request.CreateNotificationRequest;
import com.example.platform.notificationservice.dto.request.UpdateNotificationRequest;
import com.example.platform.notificationservice.dto.response.NotificationResponse;

import java.util.List;
import java.util.UUID;

public interface NotificationService {
    NotificationResponse createNotification(CreateNotificationRequest request);
    NotificationResponse getNotification(UUID id);
    List<NotificationResponse> listNotifications();
    List<NotificationResponse> listNotificationsByCustomer(UUID customerId);
    List<NotificationResponse> listNotificationsByStatus(String status);
    NotificationResponse updateNotification(UUID id, UpdateNotificationRequest request);
    void deleteNotification(UUID id);
}
