package com.example.demo.domain;

import java.time.LocalDate;

public class SurrenderRecord {
    private Long id;
    private String name;
    private String lastName;
    private Long citizenId;
    private String reason;
    private LocalDate surrenderDate;

    public SurrenderRecord(Long id, String name, String lastName, Long citizenId, String reason, LocalDate surrenderDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.citizenId = citizenId;
        this.reason = reason;
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

    public Long getCitizenId() {
        return citizenId;
    }

    public String getReason() {
        return reason;
    }

    public LocalDate getSurrenderDate() {
        return surrenderDate;
    }
}