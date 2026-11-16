package com.example.demo.domain;
import com.example.demo.infrastructure.StaffEntity;

public class Clinic {
    private Long id;
    private StaffEntity staffID;
    private String name;
    private int capacity;
    private String address;
    private String contact;
    private int numberOfDogs;

    public Clinic(Long id, StaffEntity staffID, String name, int capacity, String address, String contact, int numberOfDogs){
        this.id = id;
        this.staffID = staffID;
        this.name = name;
        this.capacity = capacity;
        this.address = address;
        this.contact = contact;
        this.numberOfDogs = numberOfDogs;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public StaffEntity getStaffID(){
        return staffID;
    }
    public void setStaffID(StaffEntity staffID){
        this.staffID = staffID;
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
