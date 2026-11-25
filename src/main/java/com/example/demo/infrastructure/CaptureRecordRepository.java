package com.example.demo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptureRecordRepository extends JpaRepository<CaptureRecordEntity, Long> {
    boolean existsByStrayReport_Id(Long strayReportId);
}