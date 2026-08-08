package com.example.platform.auditservice.service;

import com.example.platform.auditservice.dto.request.CreateAuditEventRequest;
import com.example.platform.auditservice.dto.response.AuditEventResponse;

import java.util.List;
import java.util.UUID;

public interface AuditService {
    AuditEventResponse createAuditEvent(CreateAuditEventRequest request);
    AuditEventResponse getAuditEvent(UUID id);
    List<AuditEventResponse> listAuditEvents();
    List<AuditEventResponse> listAuditEventsByEntityType(String entityType);
    List<AuditEventResponse> listAuditEventsByPerformedBy(String performedBy);
}
