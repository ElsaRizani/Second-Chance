package com.example.demo.adoption.infrastructure;

import jakarta.persistence.*; //built-in 'box' that has the @Entity,@Table and @Id that we need to talk to the database
import java.time.LocalDate; //allows us to use dates, for ex. when the application was submitted

import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;

@Entity 

@Table(name = "adoption_applications") //this tells neon to add this specific table

public class AdoptionApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    //it autoincrements the ID
    //GenerationType is the different ways java can generate an ID. 4 main ones:
        //IDENTITY (database's auto-increment feature).
        //AUTO (lets hibernate decide).
        //SEQUENCE (uses sequence object).
        //TABLE (uses separate table to track IDs).

    private Long id;
    private Long citizenId;
    private String status;
    private LocalDate applicationDate;
    private Long dogId;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCitizenId() {
        return citizenId;
    }
    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDate getApplicationDate() {
        return applicationDate;
    }
    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }
    public Long getDogId() {
        return dogId;
    }
    public void setDogId(Long dogId) {
        this.dogId = dogId;
    }

}