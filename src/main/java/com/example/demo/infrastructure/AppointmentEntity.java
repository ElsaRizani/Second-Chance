package com.example.demo.infrastructure;

import java.time.LocalDateTime;
import jakarta.persistence.*;

public class AppointmentEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn(name = "dogID")
    private DogEntity dogID;

    @ManyToOne 
    @JoinColumn(name = "staffID")
    private StaffEntity staffID;

    @ManyToOne 
    @JoinColumn(name = "clinicID")
    private ClinicEntity clinicID;

    private LocalDateTime dateTime;
    private String reason;

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

    public StaffEntity getStaffID(){
        return staffID;
    }
    public void setStaffID(StaffEntity staffID){
        this.staffID = staffID;
    }

    public ClinicEntity getClinicID(){
        return clinicID;
    }
    public void setClinicID(ClinicEntity clinicID){
        this.clinicID = clinicID;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    public String getReason(){
        return reason;
    }
    public void setReason(String reason){
        this.reason = reason;
    }
}
