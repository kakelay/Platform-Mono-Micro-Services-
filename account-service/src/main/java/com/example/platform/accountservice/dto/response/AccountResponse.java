package com.example.platform.accountservice.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class AccountResponse {

    private final UUID id;
    private final UUID customerId;
    private final String accountNumber;
    private final String accountType;
    private final String currency;
    private final BigDecimal balance;
    private final String status;
    private final LocalDateTime createdAt;

    public AccountResponse(UUID id, UUID customerId, String accountNumber, String accountType, String currency, BigDecimal balance, String status, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.currency = currency;
        this.balance = balance;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
