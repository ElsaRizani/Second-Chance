package com.example.demo.domain;

import java.time.LocalDate;

public class AdoptionApplication {
    private Long id;
    private Long dogId;
    private Long citizenId;
    private ApplicationStatusEnum status;
    private LocalDate applicationDate;

    public AdoptionApplication(Long id, Long dogId, Long citizenId) {
        this.id = id;
        this.dogId = dogId;
        this.citizenId = citizenId;
        this.status = ApplicationStatusEnum.DOREZUAR;
        this.applicationDate = LocalDate.now();
    }

    // vetem aplikacionet e dorezuara mund te pranohen
    public void approve() {
        if (this.status != ApplicationStatusEnum.DOREZUAR) {
            throw new IllegalStateException("Nuk mund te pranohet. Statusi eshte: " + this.status);
        }
        // statusi ka ndryshuar nese nuk ka pas error
        this.status = ApplicationStatusEnum.PRANUAR;
    }

    // vetem aplikacionet e dorezuara mund te refuzohen
    public void reject() {
        if (this.status != ApplicationStatusEnum.DOREZUAR) {
            throw new IllegalStateException("Nuk mund te refuzohet. Statusi eshte: " + this.status);
        }
        // statusi ka ndryshuar nese nuk ka pas error
        this.status = ApplicationStatusEnum.REFUZUAR;
    }

    public void setStatus(ApplicationStatusEnum status) {
        this.status = status;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Long getId() {
        return id;
    }

    public Long getDogId() {
        return dogId;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public ApplicationStatusEnum getStatus() {
        return status;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

}
