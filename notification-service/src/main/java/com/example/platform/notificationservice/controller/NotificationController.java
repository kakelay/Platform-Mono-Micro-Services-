package com.example.platform.notificationservice.controller;

import com.example.platform.common.model.ApiResponse;
import com.example.platform.notificationservice.dto.request.CreateNotificationRequest;
import com.example.platform.notificationservice.dto.request.UpdateNotificationRequest;
import com.example.platform.notificationservice.dto.response.NotificationResponse;
import com.example.platform.notificationservice.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<NotificationResponse>> create(@Valid @RequestBody CreateNotificationRequest request) {
        return ResponseEntity.ok(ApiResponse.success(notificationService.createNotification(request), null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<NotificationResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success(notificationService.getNotification(id), null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<NotificationResponse>>> list(@RequestParam(required = false) UUID customerId,
                                                                        @RequestParam(required = false) String status) {
        return ResponseEntity.ok(ApiResponse.success(
                customerId != null ? notificationService.listNotificationsByCustomer(customerId) :
                status != null ? notificationService.listNotificationsByStatus(status) :
                notificationService.listNotifications(), null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<NotificationResponse>> update(@PathVariable UUID id, @Valid @RequestBody UpdateNotificationRequest request) {
        return ResponseEntity.ok(ApiResponse.success(notificationService.updateNotification(id, request), null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable UUID id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.ok(ApiResponse.success(null, null));
    }
}
