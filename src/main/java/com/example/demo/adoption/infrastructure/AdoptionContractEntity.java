package com.example.demo.adoption.infrastructure;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity 

@Table(name = "adoption_contracts")

public class AdoptionContractEntity {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private LocalDate contractDate;
    private boolean feePaid;
    private Long applicationId;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getContractDate() {
        return contractDate;
    }
    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }
    public boolean isFeePaid() {
        return feePaid;
    }
    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }
    public Long getApplicationId() {
        return applicationId;
    }
    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }



}
