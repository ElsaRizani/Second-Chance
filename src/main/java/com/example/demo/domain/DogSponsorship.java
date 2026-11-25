package com.example.demo.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DogSponsorship {
    private Long id;
    private Long citizenId;
    private Long dogId;
    private BigDecimal monthlyAmount;
    private String currency;
    private String status;         // Active,Paused,Cancelled
    private LocalDate startDate;

    public DogSponsorship(Long id, Long citizenId, Long dogId, BigDecimal monthlyAmount, String currency) {
        this.id = id;
        this.citizenId = citizenId;
        this.dogId = dogId;
        this.monthlyAmount = monthlyAmount;
        this.currency = currency;
        this.status = "ACTIVE";
        this.startDate = LocalDate.now();
    }

    public void pause() {
        if (!"ACTIVE".equals(this.status)) {
            throw new IllegalStateException("Sponsorizimi mund të pauzohet vetëm kur është ACTIVE. Statusi: " + this.status);
        }
        this.status = "PAUSED";
    }

    public void resume() {
        if (!"PAUSED".equals(this.status)) {
            throw new IllegalStateException("Sponsorizimi mund të rifillojë vetëm kur është PAUSED. Statusi: " + this.status);
        }
        this.status = "ACTIVE";
    }

    public void cancel() {
        if ("CANCELLED".equals(this.status)) {
            throw new IllegalStateException("Sponsorizimi është tashmë i anuluar.");
        }
        this.status = "CANCELLED";
    }

    public Long getId() { return id; }
    public Long getCitizenId() { return citizenId; }
    public Long getDogId() { return dogId; }
    public BigDecimal getMonthlyAmount() { return monthlyAmount; }
    public String getCurrency() { return currency; }
    public String getStatus() { return status; }
    public LocalDate getStartDate() { return startDate; }
}