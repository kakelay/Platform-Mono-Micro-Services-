package com.example.platform.reportingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "report_order_summary")
public class OrderReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private double amount;

    public OrderReportEntity() {
    }

    public OrderReportEntity(Long id, String orderId, double amount) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }
}
