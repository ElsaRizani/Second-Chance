package com.example.demo.infrastructure;

import com.example.demo.domain.JobTitleEnum;

import jakarta.persistence.*;

@Entity
@Table(name = "staff")
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    // private String employeeId;

    @Enumerated(EnumType.STRING)
    private JobTitleEnum jobTitle;

    private String licenseNumber;

    // private Long shelterId;

    // private Long clinicId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public String getEmployeeId() {
    // return employeeId;
    // }

    // public void setEmployeeId(String employeeId) {
    // this.employeeId = employeeId;
    // }

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

    // public Long getShelterId() {
    // return shelterId;
    // }

    // public void setShelterId(Long shelterId) {
    // this.shelterId = shelterId;
    // }

    // public Long getClinicId() {
    // return clinicId;
    // }

    // public void setClinicId(Long clinicId) {
    // this.clinicId = clinicId;
    // }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}