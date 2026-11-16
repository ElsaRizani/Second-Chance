package com.example.demo.domain;

public class MedicalRecord {
    private Long id;
    private Long dogID;
    private Long vaccineID;
    private Long vetID;
    private String diagnosis;

    public MedicalRecord(Long id, Long dogID, Long vaccineID, Long vetID, String diagnosis){
        this.id = id;
        this.dogID = dogID;
        this.vaccineID = vaccineID;
        this.vetID = vetID;
        this.diagnosis = diagnosis;
    }

    public Long getID(){
        return id;
    }
    public void setID(Long id){
        this.id = id;
    }

    public Long getDogID(){
        return dogID;
    }
    public void setDogID(Long dogID){
        this.dogID = dogID;
    }

    public Long getVaccineID(){
        return vaccineID;
    }
    public void setVaccineID(Long vaccineID){
        this.vaccineID = vaccineID;
    }

    public Long getVetID(){
        return vetID;
    }
    public void setVetID(Long vetID){
        this.vetID = vetID;
    }

    public String getDiagnosis(){
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis){
        this.diagnosis = diagnosis;
    }
}

