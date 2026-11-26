package com.example.demo.infrastructure;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import com.example.demo.domain.Appointment.AppointmentStatusEnum;

@Entity
@Table(name = "appointments")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dog_id")
    private DogEntity dog;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private ClinicEntity clinic;

    private LocalDateTime dateTime;
    private String reason;

    @Enumerated(EnumType.STRING)
    private AppointmentStatusEnum status;

    public Long getId(){
        return id;
    }
    public void setID(Long id){
        this.id = id;
    }

    public DogEntity getDog(){
        return dog;
    }
    public void setDog(DogEntity dog){
        this.dog = dog;
    }

    public StaffEntity getStaff(){
        return staff;
    }
    public void setStaff(StaffEntity staff){
        this.staff = staff;
    }

    public ClinicEntity getClinic(){
        return clinic;
    }
    public void setClinic(ClinicEntity clinic){
        this.clinic = clinic;
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

    public AppointmentStatusEnum getStatus(){
        return status;
    }
    public void setStatus(AppointmentStatusEnum status){
        this.status = status;
    }
}
