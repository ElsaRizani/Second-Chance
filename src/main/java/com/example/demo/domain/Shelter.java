package com.example.demo.domain;

public class Shelter {
    private Long id;
    private String name;
    private String municipality;
    private int capacity;
    private int managerId;

    public Shelter(Long id, String name, String municipality, int capacity, int managerId) {
        this.id = id;
        this.name = name;
        this.municipality = municipality;
        this.capacity = capacity;
        this.managerId = managerId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMunicipality() {
        return municipality;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getManagerId() {
        return managerId;
    }
}