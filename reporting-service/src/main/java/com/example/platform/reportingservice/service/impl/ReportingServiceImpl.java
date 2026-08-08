package com.example.platform.reportingservice.service.impl;

import com.example.platform.reportingservice.dto.response.OrderReportResponse;
import com.example.platform.reportingservice.dto.response.PaymentReportResponse;
import com.example.platform.reportingservice.dto.response.TransactionReportResponse;
import com.example.platform.reportingservice.entity.OrderReportEntity;
import com.example.platform.reportingservice.entity.PaymentReportEntity;
import com.example.platform.reportingservice.entity.TransactionReportEntity;
import com.example.platform.reportingservice.repository.OrderReportRepository;
import com.example.platform.reportingservice.repository.PaymentReportRepository;
import com.example.platform.reportingservice.repository.TransactionReportRepository;
import com.example.platform.reportingservice.service.ReportingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportingServiceImpl implements ReportingService {

    private final TransactionReportRepository transactionReportRepository;
    private final PaymentReportRepository paymentReportRepository;
    private final OrderReportRepository orderReportRepository;

    public ReportingServiceImpl(TransactionReportRepository transactionReportRepository,
            PaymentReportRepository paymentReportRepository,
            OrderReportRepository orderReportRepository) {
        this.transactionReportRepository = transactionReportRepository;
        this.paymentReportRepository = paymentReportRepository;
        this.orderReportRepository = orderReportRepository;
    }

    @Override
    public List<TransactionReportResponse> getTransactionReports() {
        return transactionReportRepository.findAll().stream()
                .map(entity -> new TransactionReportResponse(entity.getTransactionId(), entity.getAmount()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentReportResponse> getPaymentReports() {
        return paymentReportRepository.findAll().stream()
                .map(entity -> new PaymentReportResponse(entity.getPaymentId(), entity.getAmount()))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderReportResponse> getOrderReports() {
        return orderReportRepository.findAll().stream()
                .map(entity -> new OrderReportResponse(entity.getOrderId(), entity.getAmount()))
                .collect(Collectors.toList());
    }

    @Override
    public void saveTransactionReport(String transactionId, double amount) {
        transactionReportRepository.save(new TransactionReportEntity(null, transactionId, amount));
    }

    @Override
    public void savePaymentReport(String paymentId, double amount) {
        paymentReportRepository.save(new PaymentReportEntity(null, paymentId, amount));
    }

    @Override
    public void saveOrderReport(String orderId, double amount) {
        orderReportRepository.save(new OrderReportEntity(null, orderId, amount));
    }
}
