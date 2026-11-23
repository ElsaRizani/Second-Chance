package com.example.demo.infrastructure;

import jakarta.persistence.*;

@Entity
@Table(name = "stray_reports")
public class StrayReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private CitizenProfileEntity reporter;

    @OneToOne(mappedBy = "strayReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private CaptureRecordEntity captureRecord;

    private String location;
    private String description;
    private String status;
    private String color;
    private String photoURL;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CitizenProfileEntity getReporter() {
        return reporter;
    }

    public void setReporter(CitizenProfileEntity reporter) {
        this.reporter = reporter;
    }

    public CaptureRecordEntity getCaptureRecord() {
        return captureRecord;
    }

    public void setCaptureRecord(CaptureRecordEntity captureRecord) {
        this.captureRecord = captureRecord;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}