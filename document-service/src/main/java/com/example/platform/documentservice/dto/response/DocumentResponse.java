package com.example.platform.documentservice.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class DocumentResponse {

    private final UUID id;
    private final UUID ownerId;
    private final String entityType;
    private final UUID entityId;
    private final String documentType;
    private final String storageUrl;
    private final String status;
    private final LocalDateTime createdAt;

    public DocumentResponse(UUID id, UUID ownerId, String entityType, UUID entityId, String documentType, String storageUrl, String status, LocalDateTime createdAt) {
        this.id = id;
        this.ownerId = ownerId;
        this.entityType = entityType;
        this.entityId = entityId;
        this.documentType = documentType;
        this.storageUrl = storageUrl;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public String getEntityType() {
        return entityType;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getStorageUrl() {
        return storageUrl;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
