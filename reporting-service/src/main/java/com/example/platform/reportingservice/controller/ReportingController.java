package com.example.platform.reportingservice.controller;

import com.example.platform.reportingservice.dto.response.OrderReportResponse;
import com.example.platform.reportingservice.dto.response.PaymentReportResponse;
import com.example.platform.reportingservice.dto.response.TransactionReportResponse;
import com.example.platform.reportingservice.service.ReportingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportingController {

    private final ReportingService reportingService;

    public ReportingController(ReportingService reportingService) {
        this.reportingService = reportingService;
    }

    @GetMapping("/transactions")
    public List<TransactionReportResponse> getTransactionReports() {
        return reportingService.getTransactionReports();
    }

    @GetMapping("/payments")
    public List<PaymentReportResponse> getPaymentReports() {
        return reportingService.getPaymentReports();
    }

    @GetMapping("/orders")
    public List<OrderReportResponse> getOrderReports() {
        return reportingService.getOrderReports();
    }
}
