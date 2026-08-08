package com.example.platform.orderservice.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class OrderResponse {

    private final UUID id;
    private final UUID customerId;
    private final UUID accountId;
    private final BigDecimal totalAmount;
    private final String currency;
    private final String status;
    private final LocalDateTime createdAt;
    private final String description;

    public OrderResponse(UUID id, UUID customerId, UUID accountId, BigDecimal totalAmount, String currency, String status, LocalDateTime createdAt, String description) {
        this.id = id;
        this.customerId = customerId;
        this.accountId = accountId;
        this.totalAmount = totalAmount;
        this.currency = currency;
        this.status = status;
        this.createdAt = createdAt;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }
}
