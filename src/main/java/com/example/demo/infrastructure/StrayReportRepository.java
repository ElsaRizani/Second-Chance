package com.example.demo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrayReportRepository extends JpaRepository<StrayReportEntity, Long> {
}