package com.example.demo.infrastructure;

import java.util.List;

import com.example.demo.domain.RoleEnum;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String passwordHash;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    private String fullName;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private CitizenProfileEntity citizenProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private StaffEntity staffProfile;

    @OneToMany(mappedBy = "user")
    private List<AuditLogEntity> auditLogs;

    

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public CitizenProfileEntity getCitizenProfile() {
        return citizenProfile;
    }

    public void setCitizenProfile(CitizenProfileEntity citizenProfile) {
        this.citizenProfile = citizenProfile;
    }

    public StaffEntity getStaffProfile() {
        return staffProfile;
    }

    public void setStaffProfile(StaffEntity staffProfile) {
        this.staffProfile = staffProfile;
    }

    public List<AuditLogEntity> getAuditLogs() {
        return auditLogs;
    }

    public void setAuditLogs(List<AuditLogEntity> auditLogs) {
        this.auditLogs = auditLogs;
    }

}