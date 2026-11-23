package com.example.demo.domain;

public class Clinic {
    private Long id;
    private Long staffID;
    private String name;
    private int capacity;
    private String address;
    private String contact;
    private int numberOfDogs;

    public Clinic(Long id, Long staffID, String name, int capacity, String address, String contact, int numberOfDogs){
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

    public Long getStaffID(){
        return staffID;
    }

    public String getName(){
        return name;
    }

    public int getCapacity(){
        return  capacity;
    }

    public String getAddress(){
        return address;
    }

    public String getContact(){
        return contact;
    }

    public int getNumberOfDogs(){
        return numberOfDogs;
    }

    public boolean fullCapacity(){
        if(numberOfDogs == this.capacity){
            return true;
        }
        return false;
    }
} 
