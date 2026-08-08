package com.example.platform.documentservice.service.impl;

import com.example.platform.common.exception.BusinessException;
import com.example.platform.documentservice.dto.request.CreateDocumentRequest;
import com.example.platform.documentservice.dto.request.UpdateDocumentRequest;
import com.example.platform.documentservice.dto.response.DocumentResponse;
import com.example.platform.documentservice.entity.DocumentEntity;
import com.example.platform.documentservice.repository.DocumentRepository;
import com.example.platform.documentservice.service.DocumentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository repository;

    public DocumentServiceImpl(DocumentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public DocumentResponse createDocument(CreateDocumentRequest request) {
        var entity = new DocumentEntity();
        entity.setId(UUID.randomUUID());
        entity.setOwnerId(request.getOwnerId());
        entity.setEntityType(request.getEntityType());
        entity.setEntityId(request.getEntityId());
        entity.setDocumentType(request.getDocumentType());
        entity.setStorageUrl(request.getStorageUrl());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(LocalDateTime.now());
        return toResponse(repository.save(entity));
    }

    @Override
    public DocumentResponse getDocument(UUID id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new BusinessException("DOCUMENT_NOT_FOUND", "Document not found"));
    }

    @Override
    public List<DocumentResponse> listDocuments() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public List<DocumentResponse> listDocumentsByOwner(UUID ownerId) {
        return repository.findByOwnerId(ownerId).stream().map(this::toResponse).toList();
    }

    @Override
    public List<DocumentResponse> listDocumentsByEntity(String entityType, UUID entityId) {
        return repository.findByEntityTypeAndEntityId(entityType, entityId).stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional
    public DocumentResponse updateDocument(UUID id, UpdateDocumentRequest request) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new BusinessException("DOCUMENT_NOT_FOUND", "Document not found"));
        entity.setStatus(request.getStatus());
        return toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void deleteDocument(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("DOCUMENT_NOT_FOUND", "Document not found");
        }
        repository.deleteById(id);
    }

    private DocumentResponse toResponse(DocumentEntity entity) {
        return new DocumentResponse(entity.getId(), entity.getOwnerId(), entity.getEntityType(), entity.getEntityId(), entity.getDocumentType(), entity.getStorageUrl(), entity.getStatus(), entity.getCreatedAt());
    }
}
