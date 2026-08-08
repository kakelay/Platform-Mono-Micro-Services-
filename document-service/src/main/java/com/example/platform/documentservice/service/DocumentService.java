package com.example.platform.documentservice.service;

import com.example.platform.documentservice.dto.request.CreateDocumentRequest;
import com.example.platform.documentservice.dto.request.UpdateDocumentRequest;
import com.example.platform.documentservice.dto.response.DocumentResponse;

import java.util.List;
import java.util.UUID;

public interface DocumentService {
    DocumentResponse createDocument(CreateDocumentRequest request);
    DocumentResponse getDocument(UUID id);
    List<DocumentResponse> listDocuments();
    List<DocumentResponse> listDocumentsByOwner(UUID ownerId);
    List<DocumentResponse> listDocumentsByEntity(String entityType, UUID entityId);
    DocumentResponse updateDocument(UUID id, UpdateDocumentRequest request);
    void deleteDocument(UUID id);
}
