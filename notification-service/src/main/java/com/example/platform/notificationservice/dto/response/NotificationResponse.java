package com.example.platform.notificationservice.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationResponse {

    private final UUID id;
    private final UUID customerId;
    private final String type;
    private final String recipient;
    private final String status;
    private final String message;
    private final LocalDateTime createdAt;

    public NotificationResponse(UUID id, UUID customerId, String type, String recipient, String status, String message, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.recipient = recipient;
        this.status = status;
        this.message = message;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getType() {
        return type;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
