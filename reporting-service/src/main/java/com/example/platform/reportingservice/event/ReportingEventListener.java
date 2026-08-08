package com.example.platform.reportingservice.event;

import com.example.platform.reportingservice.service.ReportingService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReportingEventListener {

    private final ReportingService reportingService;

    public ReportingEventListener(ReportingService reportingService) {
        this.reportingService = reportingService;
    }

    @KafkaListener(topics = "transaction.events", groupId = "reporting-service-group")
    public void onTransactionCompleted(TransactionCompletedEvent event) {
        reportingService.saveTransactionReport(event.getTransactionId(), event.getAmount());
    }

    @KafkaListener(topics = "payment.events", groupId = "reporting-service-group")
    public void onPaymentCompleted(PaymentCompletedEvent event) {
        reportingService.savePaymentReport(event.getPaymentId(), event.getAmount());
    }

    @KafkaListener(topics = "order.events", groupId = "reporting-service-group")
    public void onOrderCompleted(OrderCompletedEvent event) {
        reportingService.saveOrderReport(event.getOrderId(), event.getAmount());
    }
}
