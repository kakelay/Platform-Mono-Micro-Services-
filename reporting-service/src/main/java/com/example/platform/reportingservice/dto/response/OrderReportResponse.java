package com.example.platform.reportingservice.dto.response;

public class OrderReportResponse {

    private final String orderId;
    private final double amount;

    public OrderReportResponse(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }
}
