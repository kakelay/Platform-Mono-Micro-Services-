package com.example.platform.paymentservice.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentResponse {

    private final UUID id;
    private final UUID orderId;
    private final UUID accountId;
    private final BigDecimal amount;
    private final String currency;
    private final String method;
    private final String status;
    private final LocalDateTime createdAt;

    public PaymentResponse(UUID id, UUID orderId, UUID accountId, BigDecimal amount, String currency, String method, String status, LocalDateTime createdAt) {
        this.id = id;
        this.orderId = orderId;
        this.accountId = accountId;
        this.amount = amount;
        this.currency = currency;
        this.method = method;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
