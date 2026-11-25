package com.example.demo.domain;

import java.time.LocalDate;

public class SurrenderRecord {
    private Long id;
    private Long citizenId;
    private String name;
    private String lastName;
    private String reason;
    private LocalDate surrenderDate;

    public SurrenderRecord(Long id, Long citizenId, String name, String lastName, String reason, LocalDate surrenderDate) {
        if (citizenId == null) {
            throw new IllegalArgumentException("Citizen ID nuk mund te jete bosh.");
        }
        this.id = id;
        this.citizenId = citizenId;
        updateDetails(name, lastName, reason, surrenderDate);
    }

    public void updateDetails(String name, String lastName, String reason, LocalDate surrenderDate) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Emri eshte i detyrueshem.");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Mbiemri eshte i detyrueshem.");
        }
        if (reason == null || reason.trim().isEmpty()) {
            throw new IllegalArgumentException("Arsyeja eshte e detyrueshme.");
        }
        this.name = name.trim();
        this.lastName = lastName.trim();
        this.reason = reason.trim();
        this.surrenderDate = surrenderDate != null ? surrenderDate : LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getReason() {
        return reason;
    }

    public LocalDate getSurrenderDate() {
        return surrenderDate;
    }
}