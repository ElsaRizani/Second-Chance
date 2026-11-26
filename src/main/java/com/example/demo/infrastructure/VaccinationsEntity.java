package com.example.demo.infrastructure;
import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

import jakarta.persistence.*;

@Entity
public class VaccinationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dogID")
    private DogEntity dogId;

    private String vaccineName;
    private int dose;
    private LocalDateTime lastDoseDate;
    private LocalDateTime nextDoseDate;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public DogEntity getDogId(){
        return dogId;
    }
    public void setDogId(DogEntity dogId){
        this.dogId = dogId;
    }

    public String getVaccineName(){
        return vaccineName;
    }
    public void setVaccineName(String vaccineName){
        this.vaccineName = vaccineName;
    }

    public int getDose(){
        return dose;
    }
    public void setDose(int dose){
        this.dose = dose;
    }

    public LocalDateTime getLastDoseDate(){
        return lastDoseDate;
    }
    public void setLastDoseDate(LocalDateTime lastDoseDate){
        this.lastDoseDate = lastDoseDate;
    }

    public LocalDateTime getNextDoseDate() {
        return nextDoseDate;
    }
    public void setNextDoseDate(LocalDateTime nextDoseDate){
        this.nextDoseDate = nextDoseDate;
    }
}
