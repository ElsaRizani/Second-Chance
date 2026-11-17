package com.example.demo.domain;

import java.time.LocalDate;

public class CaptureRecord {
    private Long id;
    private int staffId;
    private int dogId;
    private LocalDate captureDate;

    public CaptureRecord(Long id, int staffId, int dogId, LocalDate captureDate) {
        this.id = id;
        this.staffId = staffId;
        this.dogId = dogId;
        this.captureDate = captureDate != null ? captureDate : LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public int getStaffId() {
        return staffId;
    }

    public int getDogId() {
        return dogId;
    }

    public LocalDate getCaptureDate() {
        return captureDate;
    }
}