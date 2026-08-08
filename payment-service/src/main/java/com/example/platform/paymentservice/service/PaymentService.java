package com.example.platform.paymentservice.service;

import com.example.platform.paymentservice.dto.request.CreatePaymentRequest;
import com.example.platform.paymentservice.dto.request.UpdatePaymentRequest;
import com.example.platform.paymentservice.dto.response.PaymentResponse;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    PaymentResponse createPayment(CreatePaymentRequest request);
    PaymentResponse getPayment(UUID id);
    List<PaymentResponse> listPayments();
    List<PaymentResponse> listPaymentsByOrder(UUID orderId);
    List<PaymentResponse> listPaymentsByAccount(UUID accountId);
    PaymentResponse updatePayment(UUID id, UpdatePaymentRequest request);
    void deletePayment(UUID id);
}
