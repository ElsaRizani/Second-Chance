package com.example.demo.infrastructure;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_records")
public class MedicalRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dog_id")
    private DogEntity dog;

    @OneToOne
    @JoinColumn(name = "vaccine_id")
    private VaccinationsEntity vaccine;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private StaffEntity vet;

    private String diagnosis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DogEntity getDog() {
        return dog;
    }

    public void setDog(DogEntity dog) {
        this.dog = dog;
    }

    public VaccinationsEntity getVaccine() {
        return vaccine;
    }

    public void setVaccine(VaccinationsEntity vaccine) {
        this.vaccine = vaccine;
    }

    public StaffEntity getVet() {
        return vet;
    }

    public void setVet(StaffEntity vet) {
        this.vet = vet;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
