package com.example.demo.domain;

public class StrayReport {
    private Long id;
    private Long reporterId;
    private String location;
    private String description;
    private String status;
    private String color;
    private String photoURL;

    public StrayReport(Long id, Long reporterId, String location, String description, String color, String photoURL) {
        if (reporterId == null) {
            throw new IllegalArgumentException("Reporter ID nuk mund te jete bosh.");
        }
        this.id = id;
        this.reporterId = reporterId;
        this.status = "OPEN";
        updateDetails(location, description, color, photoURL);
    }

    public StrayReport(Long id, Long reporterId, String location, String description, String status, String color, String photoURL) {
        this.id = id;
        this.reporterId = reporterId;
        this.location = location != null ? location.trim() : null;
        this.description = description != null ? description.trim() : null;
        this.status = status != null ? status.trim() : "OPEN";
        this.color = color != null ? color.trim() : null;
        this.photoURL = photoURL != null ? photoURL.trim() : null;
    }

    public void updateDetails(String location, String description, String color, String photoURL) {
        if (location == null || location.trim().isEmpty()) {
            throw new IllegalArgumentException("Lokacioni eshte i detyrueshem.");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Pershkrimi eshte i detyrueshem.");
        }
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Ngjyra eshte e detyrueshme.");
        }
        if (photoURL == null || photoURL.trim().isEmpty()) {
            throw new IllegalArgumentException("Fotoja eshte e detyrueshme.");
        }
        this.location = location.trim();
        this.description = description.trim();
        this.color = color.trim();
        this.photoURL = photoURL.trim();
    }

    public void changeStatus(String newStatus) {
        if (newStatus == null || newStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("Statusi i ri nuk mund te jete bosh.");
        }
        this.status = newStatus.trim().toUpperCase();
    }

    public Long getId() {
        return id;
    }

    public Long getReporterId() {
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