package com.example.demo.domain;

public class Staff {

    private Long id;
    private Long userId;
    private JobTitleEnum jobTitle;
    private String licenseNumber;

    public Staff() {
    }

    public Staff(Long id, Long userId, JobTitleEnum jobTitle, String licenseNumber) {
        this.id = id;
        this.userId = userId;
        this.jobTitle = jobTitle;
        this.licenseNumber = licenseNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public JobTitleEnum getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitleEnum jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}