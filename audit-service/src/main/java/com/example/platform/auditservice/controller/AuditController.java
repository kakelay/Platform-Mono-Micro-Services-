package com.example.platform.auditservice.controller;

import com.example.platform.auditservice.dto.request.CreateAuditEventRequest;
import com.example.platform.auditservice.dto.response.AuditEventResponse;
import com.example.platform.auditservice.service.AuditService;
import com.example.platform.common.model.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/audits")
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AuditEventResponse>> create(@Valid @RequestBody CreateAuditEventRequest request) {
        return ResponseEntity.ok(ApiResponse.success(auditService.createAuditEvent(request), null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AuditEventResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success(auditService.getAuditEvent(id), null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AuditEventResponse>>> list(@RequestParam(required = false) String entityType,
                                                                      @RequestParam(required = false) String performedBy) {
        return ResponseEntity.ok(ApiResponse.success(
                entityType != null ? auditService.listAuditEventsByEntityType(entityType) :
                performedBy != null ? auditService.listAuditEventsByPerformedBy(performedBy) :
                auditService.listAuditEvents(), null));
    }
}
