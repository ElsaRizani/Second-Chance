package com.example.demo.adoption.domain;

import java.time.LocalDate;

public class AdoptionApplication {
    private Long id;
    private Long dogId;
    private Long citizenId;
    private String status;
    private LocalDate applicationDate;

    public AdoptionApplication(Long id, Long dogId, Long citizenId) {
        this.id = id;
        this.dogId = dogId;
        this.citizenId = citizenId;
        this.status = "Dorezuar";
        this.applicationDate = LocalDate.now();
    }

    // vetem aplikacionet e dorezuara mund te pranohen
    public void approve() {
        if (!this.status.equals("Dorezuar")) {
            throw new IllegalStateException("Nuk mund te pranohet. Statusi eshte: " + this.status);        
        }
        //statusi ka ndryshuar nese nuk ka pas error
        this.status = "Pranuar";
    }

    // vetem aplikacionet e dorezuara mund te refuzohen
    public void reject() {
        if (!this.status.equals("Dorezuar")) {
            throw new IllegalStateException("Nuk mund te refuzohet. Statusi eshte: " + this.status);    
        }
        //statusi ka ndryshuar nese nuk ka pas error
            this.status = "Refuzuar";
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

    public String getStatus() {
        return status;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

}
