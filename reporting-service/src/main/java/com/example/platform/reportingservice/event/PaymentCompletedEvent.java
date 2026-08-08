package com.example.platform.reportingservice.event;

public class PaymentCompletedEvent {

    private String paymentId;
    private double amount;

    public PaymentCompletedEvent() {
    }

    public PaymentCompletedEvent(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }
}
