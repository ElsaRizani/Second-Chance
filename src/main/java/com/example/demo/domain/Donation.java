package com.example.demo.domain;

import java.time.LocalDate;

public class Donation {
    private Long id;
    private Long citizenId; 
    private Double amount; 
    private String currency;
    private String status;   
    private LocalDate donationDate;

    
    public Donation(Long id, Long citizenId, Double amount, String currency) {
        this.id = id;
        this.citizenId = citizenId;
        this.amount = amount;
        this.currency = currency;
        this.status = "Pending"; 
        this.donationDate = LocalDate.now();
    }

    //Konfirmimi i donacionit
    public void complete() {
        if (!this.status.equals("Pending")) {
            throw new IllegalStateException("Donacioni nuk mund të konfirmohet. Statusi është: " + this.status);
        }
        this.status = "Completed";
    }

    //Anulimi i donacionit
    public void cancel() {
        if (this.status.equals("Completed")) {
            throw new IllegalStateException("Nuk mund të anulohet një donacion që është përfunduar.");
        }
        this.status = "Cancelled";
    }

    public Long getId() {
        return id;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }
}