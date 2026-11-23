package com.example.demo.domain;

import java.time.LocalDateTime;

public class Appointment{
    private Long id;
    private Long dogID;
    private Long staffID;
    private Long clinicID;
    private LocalDateTime dateTime;
    private String reason;

    public Appointment(Long id, Long dogID, Long staffID, Long clinicID, LocalDateTime dateTime, String reason){
        this.id = id;
        this.dogID = dogID;
        this.staffID = staffID;
        this.clinicID = clinicID;
        this.dateTime = dateTime;
        this.reason = reason;
    }

    public Long getID(){
        return id;
    }

    public Long getDogID(){
        return dogID;
    }

    public Long getStaffID(){
        return staffID;
    }

    public Long getClinicID(){
        return clinicID;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public String getReason(){
        return reason;
    }
}
