package com.example.platform.paymentservice.service.impl;

import com.example.platform.common.exception.BusinessException;
import com.example.platform.paymentservice.dto.request.CreatePaymentRequest;
import com.example.platform.paymentservice.dto.request.UpdatePaymentRequest;
import com.example.platform.paymentservice.dto.response.PaymentResponse;
import com.example.platform.paymentservice.entity.PaymentEntity;
import com.example.platform.paymentservice.repository.PaymentRepository;
import com.example.platform.paymentservice.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public PaymentResponse createPayment(CreatePaymentRequest request) {
        var payment = new PaymentEntity();
        payment.setId(UUID.randomUUID());
        payment.setOrderId(request.getOrderId());
        payment.setAccountId(request.getAccountId());
        payment.setAmount(request.getAmount());
        payment.setCurrency(request.getCurrency());
        payment.setMethod(request.getMethod());
        payment.setStatus(request.getStatus());
        payment.setCreatedAt(LocalDateTime.now());
        return toResponse(repository.save(payment));
    }

    @Override
    public PaymentResponse getPayment(UUID id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new BusinessException("PAYMENT_NOT_FOUND", "Payment not found"));
    }

    @Override
    public List<PaymentResponse> listPayments() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public List<PaymentResponse> listPaymentsByOrder(UUID orderId) {
        return repository.findByOrderId(orderId).stream().map(this::toResponse).toList();
    }

    @Override
    public List<PaymentResponse> listPaymentsByAccount(UUID accountId) {
        return repository.findByAccountId(accountId).stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional
    public PaymentResponse updatePayment(UUID id, UpdatePaymentRequest request) {
        var payment = repository.findById(id)
                .orElseThrow(() -> new BusinessException("PAYMENT_NOT_FOUND", "Payment not found"));
        payment.setStatus(request.getStatus());
        return toResponse(repository.save(payment));
    }

    @Override
    @Transactional
    public void deletePayment(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("PAYMENT_NOT_FOUND", "Payment not found");
        }
        repository.deleteById(id);
    }

    private PaymentResponse toResponse(PaymentEntity entity) {
        return new PaymentResponse(entity.getId(), entity.getOrderId(), entity.getAccountId(), entity.getAmount(), entity.getCurrency(), entity.getMethod(), entity.getStatus(), entity.getCreatedAt());
    }
}
