package com.example.platform.reportingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "report_payment_summary")
public class PaymentReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentId;
    private double amount;

    public PaymentReportEntity() {
    }

    public PaymentReportEntity(Long id, String paymentId, double amount) {
        this.id = id;
        this.paymentId = paymentId;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }
}
