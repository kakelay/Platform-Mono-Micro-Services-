package com.example.platform.documentservice.controller;

import com.example.platform.common.model.ApiResponse;
import com.example.platform.documentservice.dto.request.CreateDocumentRequest;
import com.example.platform.documentservice.dto.request.UpdateDocumentRequest;
import com.example.platform.documentservice.dto.response.DocumentResponse;
import com.example.platform.documentservice.service.DocumentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DocumentResponse>> create(@Valid @RequestBody CreateDocumentRequest request) {
        return ResponseEntity.ok(ApiResponse.success(documentService.createDocument(request), null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DocumentResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success(documentService.getDocument(id), null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DocumentResponse>>> list(@RequestParam(required = false) UUID ownerId,
                                                                     @RequestParam(required = false) String entityType,
                                                                     @RequestParam(required = false) UUID entityId) {
        return ResponseEntity.ok(ApiResponse.success(
                ownerId != null ? documentService.listDocumentsByOwner(ownerId) :
                entityType != null && entityId != null ? documentService.listDocumentsByEntity(entityType, entityId) :
                documentService.listDocuments(), null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<DocumentResponse>> update(@PathVariable UUID id, @Valid @RequestBody UpdateDocumentRequest request) {
        return ResponseEntity.ok(ApiResponse.success(documentService.updateDocument(id, request), null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable UUID id) {
        documentService.deleteDocument(id);
        return ResponseEntity.ok(ApiResponse.success(null, null));
    }
}
