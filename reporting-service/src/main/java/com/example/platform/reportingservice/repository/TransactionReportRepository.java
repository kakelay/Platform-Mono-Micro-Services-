package com.example.platform.reportingservice.repository;

import com.example.platform.reportingservice.entity.TransactionReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionReportRepository extends JpaRepository<TransactionReportEntity, Long> {
}
