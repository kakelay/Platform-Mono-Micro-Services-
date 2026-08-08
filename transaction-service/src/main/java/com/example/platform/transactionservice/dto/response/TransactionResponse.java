package com.example.platform.transactionservice.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionResponse {

    private final UUID id;
    private final UUID accountId;
    private final BigDecimal amount;
    private final String currency;
    private final String type;
    private final String status;
    private final String description;
    private final LocalDateTime createdAt;

    public TransactionResponse(UUID id, UUID accountId, BigDecimal amount, String currency, String type, String status, String description, LocalDateTime createdAt) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.currency = currency;
        this.type = type;
        this.status = status;
        this.description = description;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
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

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
