package com.example.platform.reportingservice.repository;

import com.example.platform.reportingservice.entity.OrderReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReportRepository extends JpaRepository<OrderReportEntity, Long> {
}
