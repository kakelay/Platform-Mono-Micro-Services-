package com.example.platform.auditservice.repository;

import com.example.platform.auditservice.entity.AuditEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AuditEventRepository extends JpaRepository<AuditEventEntity, UUID> {
    List<AuditEventEntity> findByEntityType(String entityType);
    List<AuditEventEntity> findByPerformedBy(String performedBy);
}
