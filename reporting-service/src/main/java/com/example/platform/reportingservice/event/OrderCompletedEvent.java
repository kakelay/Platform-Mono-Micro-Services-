package com.example.platform.reportingservice.event;

public class OrderCompletedEvent {

    private String orderId;
    private double amount;

    public OrderCompletedEvent() {
    }

    public OrderCompletedEvent(String orderId, double amount) {
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
