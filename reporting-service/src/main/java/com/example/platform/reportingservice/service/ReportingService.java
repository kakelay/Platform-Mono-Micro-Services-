package com.example.platform.reportingservice.service;

import com.example.platform.reportingservice.dto.response.OrderReportResponse;
import com.example.platform.reportingservice.dto.response.PaymentReportResponse;
import com.example.platform.reportingservice.dto.response.TransactionReportResponse;

import java.util.List;

public interface ReportingService {

    List<TransactionReportResponse> getTransactionReports();

    List<PaymentReportResponse> getPaymentReports();

    List<OrderReportResponse> getOrderReports();

    void saveTransactionReport(String transactionId, double amount);

    void savePaymentReport(String paymentId, double amount);

    void saveOrderReport(String orderId, double amount);
}
