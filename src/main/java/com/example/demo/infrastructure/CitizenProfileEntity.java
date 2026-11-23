package com.example.demo.infrastructure;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "citizenProfile")
public class CitizenProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String address;
    private String phone;

    @OneToMany(mappedBy = "reporter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StrayReportEntity> strayReports;

    @OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SurrenderRecordEntity> surrenderRecords;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserEntity getUserid() {
        return user;
    }

    public void setUserid(UserEntity userid) {
        this.user = userid;
    }

    public List<StrayReportEntity> getStrayReports() {
        return strayReports;
    }

    public void setStrayReports(List<StrayReportEntity> strayReports) {
        this.strayReports = strayReports;
    }

    public List<SurrenderRecordEntity> getSurrenderRecords() {
        return surrenderRecords;
    }

    public void setSurrenderRecords(List<SurrenderRecordEntity> surrenderRecords) {
        this.surrenderRecords = surrenderRecords;
    }
}