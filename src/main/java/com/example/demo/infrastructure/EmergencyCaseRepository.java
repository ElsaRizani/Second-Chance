package com.example.demo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmergencyCaseRepository extends JpaRepository<EmergencyCaseEntity, Long> {
    List<EmergencyCaseEntity> findByDog_Id(Long dogId);
}