package com.example.demo.infrastructure;

import com.example.demo.domain.ContractStatusEnum;
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
    @Enumerated(EnumType.STRING)
    private ContractStatusEnum status;

    @OneToOne
    @JoinColumn(name = "application_id")
    private AdoptionApplicationEntity application;

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

    public ContractStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ContractStatusEnum status) {
        this.status = status;
    }

    public AdoptionApplicationEntity getApplication() {
        return application;
    }

    public void setApplication(AdoptionApplicationEntity application) {
        this.application = application;
    }

}
