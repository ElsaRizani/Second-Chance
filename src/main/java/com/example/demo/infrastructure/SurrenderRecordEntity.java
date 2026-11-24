package com.example.demo.infrastructure;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "surrender_records")
public class SurrenderRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String reason;
    private LocalDate surrenderDate;

    @ManyToOne
    @JoinColumn(name = "citizen_id")
    private CitizenProfileEntity citizen;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getSurrenderDate() {
        return surrenderDate;
    }

    public void setSurrenderDate(LocalDate surrenderDate) {
        this.surrenderDate = surrenderDate != null ? surrenderDate : LocalDate.now();
    }

    public CitizenProfileEntity getCitizen() {
        return citizen;
    }

    public void setCitizen(CitizenProfileEntity citizen) {
        this.citizen = citizen;
    }

}