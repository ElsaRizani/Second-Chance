package com.example.demo.infrastructure;
import jakarta.persistence.*;

public class MedicalRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "dogID")
    private DogEntity dogID;

    @OneToOne 
    @JoinColumn (name = "vaccineID")
    private VaccinationsEntity vaccineID;

    @ManyToOne 
    @JoinColumn(name = "vetID")
    private StaffEntity vetID;

    private String diagnosis;

    public Long getID(){
        return id;
    }
    public void setID(Long id){
        this.id = id;
    }

    public DogEntity getDogID(){
        return dogID;
    }
    public void setDogID(DogEntity dogID){
        this.dogID = dogID;
    }

    public VaccinationsEntity getVaccineID(){
        return vaccineID;
    }
    public void setVaccineID(VaccinationsEntity vaccineID){
        this.vaccineID = vaccineID;
    }

    public StaffEntity getVetID(){
        return vetID;
    }
    public void setVetID(StaffEntity vetID){
        this.vetID = vetID;
    }

    public String getDiagnosis(){
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis){
        this.diagnosis = diagnosis;
    }
}
