package com.example.demo.domain;

import java.time.LocalDate;

public class SurrenderRecord {
    private Long id;
    private String name;
    private String lastName;
    private int citizenId;
    private String reason;
    private int dogId;
    private LocalDate surrenderDate;

    public SurrenderRecord(Long id, String name, String lastName, int citizenId, String reason, int dogId, LocalDate surrenderDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.citizenId = citizenId;
        this.reason = reason;
        this.dogId = dogId;
        this.surrenderDate = surrenderDate != null ? surrenderDate : LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public String getReason() {
        return reason;
    }

    public int getDogId() {
        return dogId;
    }

    public LocalDate getSurrenderDate() {
        return surrenderDate;
    }
}