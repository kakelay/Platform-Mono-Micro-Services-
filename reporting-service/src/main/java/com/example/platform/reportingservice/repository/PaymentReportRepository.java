package com.example.platform.reportingservice.repository;

import com.example.platform.reportingservice.entity.PaymentReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentReportRepository extends JpaRepository<PaymentReportEntity, Long> {
}
