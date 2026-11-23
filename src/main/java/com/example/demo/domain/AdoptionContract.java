package com.example.demo.domain;

import java.time.LocalDate;

public class AdoptionContract {
    private Long id;
    private LocalDate contractDate;
    private boolean feePaid;
    private Long applicationId;
    private ContractStatusEnum status;

    public AdoptionContract(Long id, Long applicationId, boolean feePaid) {
        this.id = id;
        this.applicationId = applicationId;
        this.feePaid = feePaid;
        this.contractDate = LocalDate.now();
        this.status = ContractStatusEnum.DRAFT;
    }

    public void finalizeContract() {
        if (!this.feePaid) {
            throw new IllegalStateException("Nuk mund te finalizohet kontrata. Pagesa nuk eshte kryer.");
        }
        this.status = ContractStatusEnum.DRAFT;
    }

    public Long getId() {
        return id;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public boolean getFeePaid() {
        return feePaid;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public ContractStatusEnum getStatus() {
        return status;
    }

}
