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
    private int citizenId;
    private String reason;
    private int dogId;
    private LocalDate surrenderDate;

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

    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public LocalDate getSurrenderDate() {
        return surrenderDate;
    }

    public void setSurrenderDate(LocalDate surrenderDate) {
        this.surrenderDate = surrenderDate;
    }
}