package com.example.platform.reportingservice.dto.response;

public class TransactionReportResponse {

    private final String transactionId;
    private final double amount;

    public TransactionReportResponse(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }
}
