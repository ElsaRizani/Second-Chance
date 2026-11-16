package com.example.demo.infrastructure;
import java.util.*;

import jakarta.persistence.*;
@Entity 
public class ClinicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "clinic")
    private List<StaffEntity> staff = new ArrayList<>(); 

    private String name;
    private int capacity;
    private String address;
    private String contact;
    private int numberOfDogs;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public List<StaffEntity> getStaff(){
        return staff;
    }
    public void setStaff(List<StaffEntity> staff){
        this.staff = staff;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getCapacity(){
        return  capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getContact(){
        return contact;
    }
    public void setContact(String contact){
        this.contact = contact;
    }

    public int getNumberOfDogs(){
        return numberOfDogs;
    }
    public void setNumberOfDogs(int numberOfDogs){
        this.numberOfDogs = numberOfDogs;
    }

    public boolean fullCapacity(){
        if(numberOfDogs == this.capacity){
            return true;
        }
        return false;
    }
} 