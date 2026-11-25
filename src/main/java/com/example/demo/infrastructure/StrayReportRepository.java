package com.example.demo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrayReportRepository extends JpaRepository<StrayReportEntity, Long> {
    List<StrayReportEntity> findByReporter_Id(Long reporterId);
}