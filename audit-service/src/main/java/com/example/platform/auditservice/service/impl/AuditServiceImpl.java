package com.example.platform.auditservice.service.impl;

import com.example.platform.auditservice.dto.request.CreateAuditEventRequest;
import com.example.platform.auditservice.dto.response.AuditEventResponse;
import com.example.platform.auditservice.entity.AuditEventEntity;
import com.example.platform.auditservice.repository.AuditEventRepository;
import com.example.platform.auditservice.service.AuditService;
import com.example.platform.common.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AuditServiceImpl implements AuditService {

    private final AuditEventRepository repository;

    public AuditServiceImpl(AuditEventRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public AuditEventResponse createAuditEvent(CreateAuditEventRequest request) {
        var entity = new AuditEventEntity();
        entity.setId(UUID.randomUUID());
        entity.setAction(request.getAction());
        entity.setEntityType(request.getEntityType());
        entity.setEntityId(request.getEntityId());
        entity.setPerformedBy(request.getPerformedBy());
        entity.setDetails(request.getDetails());
        entity.setOccurredAt(LocalDateTime.now());
        return toResponse(repository.save(entity));
    }

    @Override
    public AuditEventResponse getAuditEvent(UUID id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new BusinessException("AUDIT_EVENT_NOT_FOUND", "Audit event not found"));
    }

    @Override
    public List<AuditEventResponse> listAuditEvents() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public List<AuditEventResponse> listAuditEventsByEntityType(String entityType) {
        return repository.findByEntityType(entityType).stream().map(this::toResponse).toList();
    }

    @Override
    public List<AuditEventResponse> listAuditEventsByPerformedBy(String performedBy) {
        return repository.findByPerformedBy(performedBy).stream().map(this::toResponse).toList();
    }

    private AuditEventResponse toResponse(AuditEventEntity entity) {
        return new AuditEventResponse(entity.getId(), entity.getAction(), entity.getEntityType(), entity.getEntityId(), entity.getPerformedBy(), entity.getOccurredAt(), entity.getDetails());
    }
}
