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

    public Long getDogID(){
        return dogID;
    }

    public Long getVaccineID(){
        return vaccineID;
    }

    public Long getVetID(){
        return vetID;
    }

    public String getDiagnosis(){
        return diagnosis;
    }
}