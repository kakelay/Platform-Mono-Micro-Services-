package com.example.platform.documentservice.repository;

import com.example.platform.documentservice.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DocumentRepository extends JpaRepository<DocumentEntity, UUID> {
    List<DocumentEntity> findByOwnerId(UUID ownerId);
    List<DocumentEntity> findByEntityTypeAndEntityId(String entityType, UUID entityId);
}
