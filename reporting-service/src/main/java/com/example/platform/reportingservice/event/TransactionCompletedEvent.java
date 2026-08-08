package com.example.platform.reportingservice.event;

public class TransactionCompletedEvent {

    private String transactionId;
    private double amount;

    public TransactionCompletedEvent() {
    }

    public TransactionCompletedEvent(String transactionId, double amount) {
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
