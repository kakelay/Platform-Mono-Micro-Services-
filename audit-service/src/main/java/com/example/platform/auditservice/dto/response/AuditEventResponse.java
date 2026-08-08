package com.example.platform.auditservice.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class AuditEventResponse {

    private final UUID id;
    private final String action;
    private final String entityType;
    private final UUID entityId;
    private final String performedBy;
    private final LocalDateTime occurredAt;
    private final String details;

    public AuditEventResponse(UUID id, String action, String entityType, UUID entityId, String performedBy, LocalDateTime occurredAt, String details) {
        this.id = id;
        this.action = action;
        this.entityType = entityType;
        this.entityId = entityId;
        this.performedBy = performedBy;
        this.occurredAt = occurredAt;
        this.details = details;
    }

    public UUID getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public String getEntityType() {
        return entityType;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }

    public String getDetails() {
        return details;
    }
}
