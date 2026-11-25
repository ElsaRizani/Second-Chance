package com.example.demo.domain;

import java.time.LocalDate;

public class CaptureRecord {
    private Long id;
    private Long strayReportId;
    private LocalDate captureDate;

    public CaptureRecord(Long id, Long strayReportId, LocalDate captureDate) {
        if (strayReportId == null) {
            throw new IllegalArgumentException("Stray report ID nuk mund te jete bosh.");
        }
        this.id = id;
        this.strayReportId = strayReportId;
        this.captureDate = captureDate != null ? captureDate : LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public Long getStrayReportId() {
        return strayReportId;
    }

    public LocalDate getCaptureDate() {
        return captureDate;
    }
}