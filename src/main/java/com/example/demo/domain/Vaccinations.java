package com.example.demo.domain;
import java.time.LocalDateTime;

public class Vaccinations{
    private Long id;
    private Long dogID;
    private String vaccineName;
    private int dose;
    private LocalDateTime lastDoseDate;
    private LocalDateTime nextDoseDate;

    public Vaccinations(Long id, Long dogID, String vaccineName, int dose, LocalDateTime lastDoseDate){
        this.id = id;
        this.dogID = dogID;
        this.vaccineName = vaccineName;
        this.dose = dose;
        this.lastDoseDate = lastDoseDate;
        this.nextDoseDate = lastDoseDate.plusMonths(2);
    }

    public Long getID(){
        return id;
    }

    public Long getDogID(){
        return dogID;
    }

    public String getVaccineName(){
        return vaccineName;
    }

    public int getDose(){
        return dose;
    }

    public LocalDateTime getLastDoseDate(){
        return lastDoseDate;
    }

    //pas cdo 2 muajve bohet dosa tjeter (nese e dini qysh shkon muni me ndrru)
    public LocalDateTime getNextDoseDate(){
        return nextDoseDate;
    }
}
