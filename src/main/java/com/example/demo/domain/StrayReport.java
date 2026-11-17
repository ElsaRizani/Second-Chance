package com.example.demo.domain;

public class StrayReport {
    private Long id;
    private int reporterId;
    private String location;
    private String description;
    private String status;
    private String color;
    private String photoURL;

    public StrayReport(Long id, int reporterId, String location, String description, String status, String color, String photoURL) {
        this.id = id;
        this.reporterId = reporterId;
        this.location = location;
        this.description = description;
        this.status = status;
        this.color = color;
        this.photoURL = photoURL;
    }

    public Long getId() {
        return id;
    }

    public int getReporterId() {
        return reporterId;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getColor() {
        return color;
    }

    public String getPhotoURL() {
        return photoURL;
    }
}