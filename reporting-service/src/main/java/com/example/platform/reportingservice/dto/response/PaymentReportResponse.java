package com.example.platform.reportingservice.dto.response;

public class PaymentReportResponse {

    private final String paymentId;
    private final double amount;

    public PaymentReportResponse(String paymentId, double amount) {
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
