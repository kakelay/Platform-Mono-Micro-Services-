package com.example.platform.reportingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "report_transaction_summary")
public class TransactionReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionId;
    private double amount;

    public TransactionReportEntity() {
    }

    public TransactionReportEntity(Long id, String transactionId, double amount) {
        this.id = id;
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }
}
