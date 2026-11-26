package com.example.demo.domain;

import java.time.LocalDateTime;

public class Appointment{
    public enum AppointmentStatusEnum{SCHEDULED, COMPLETED, CANCELLED}
    private Long id;
    private Long dogID;
    private Long staffID;
    private Long clinicID;
    private LocalDateTime dateTime;
    private String reason;
    private AppointmentStatusEnum status;

    public Appointment(Long id, Long dogID, Long staffID, Long clinicID, LocalDateTime dateTime, String reason, AppointmentStatusEnum status){
        this.id = id;
        this.dogID = dogID;
        this.staffID = staffID;
        this.clinicID = clinicID;
        this.dateTime = dateTime;
        this.reason = reason;
        this.status = status;
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

    public AppointmentStatusEnum getStatus(){
        return status;
    }
}