package com.example.platform.paymentservice.controller;

import com.example.platform.common.model.ApiResponse;
import com.example.platform.paymentservice.dto.request.CreatePaymentRequest;
import com.example.platform.paymentservice.dto.request.UpdatePaymentRequest;
import com.example.platform.paymentservice.dto.response.PaymentResponse;
import com.example.platform.paymentservice.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PaymentResponse>> create(@Valid @RequestBody CreatePaymentRequest request) {
        return ResponseEntity.ok(ApiResponse.success(paymentService.createPayment(request), null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PaymentResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success(paymentService.getPayment(id), null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PaymentResponse>>> list(@RequestParam(required = false) UUID orderId,
                                                                   @RequestParam(required = false) UUID accountId) {
        return ResponseEntity.ok(ApiResponse.success(
                orderId != null ? paymentService.listPaymentsByOrder(orderId) :
                accountId != null ? paymentService.listPaymentsByAccount(accountId) :
                paymentService.listPayments(), null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PaymentResponse>> update(@PathVariable UUID id, @Valid @RequestBody UpdatePaymentRequest request) {
        return ResponseEntity.ok(ApiResponse.success(paymentService.updatePayment(id, request), null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable UUID id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok(ApiResponse.success(null, null));
    }
}
