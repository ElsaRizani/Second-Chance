package com.example.demo.adoption.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdoptionContractRepository extends JpaRepository<AdoptionContractEntity, Long> {
    
}