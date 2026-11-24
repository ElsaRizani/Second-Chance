package com.example.demo.infrastructure;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "vaccinations")
public class VaccinationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dog_id")
    private DogEntity dog;

    private String vaccineName;
    private int dose;
    private LocalDateTime lastDoseDate;
    private LocalDateTime nextDoseDate;

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public DogEntity getDog() {
        return dog;
    }

    public void setDog(DogEntity dog) {
        this.dog = dog;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public LocalDateTime getLastDoseDate() {
        return lastDoseDate;
    }

    public void setLastDoseDate(LocalDateTime lastDoseDate) {
        this.lastDoseDate = lastDoseDate;
    }

    // pas cdo 2 muajve bohet dosa tjeter (nese e dini qysh shkon muni me ndrru)
    public LocalDateTime getNextDoseDate() {
        if (this.lastDoseDate == null) {
            return null;
        }
        nextDoseDate = this.lastDoseDate.plusMonths(2);
        return nextDoseDate;
    }
}
