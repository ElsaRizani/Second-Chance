package com.example.demo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurrenderRecordRepository extends JpaRepository<SurrenderRecordEntity, Long> {
    List<SurrenderRecordEntity> findByCitizen_Id(Long citizenId);
}