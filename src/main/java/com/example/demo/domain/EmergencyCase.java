package com.example.demo.domain;

import java.time.LocalDate;

public class EmergencyCase {
    private Long id;
    private int dogId;
    private String description;
    private String status;
    private LocalDate reportedDate;

    public EmergencyCase(Long id, int dogId, String description, String status, LocalDate reportedDate) {
        this.id = id;
        this.dogId = dogId;
        this.description = description;
        this.status = status;
        this.reportedDate = reportedDate != null ? reportedDate : LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public int getDogId() {
        return dogId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getReportedDate() {
        return reportedDate;
    }
}