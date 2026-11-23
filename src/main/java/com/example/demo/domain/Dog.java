package com.example.demo.domain;

public class Dog {
    private Long id;
    private String name;
    private String breed;
    private int estimatedAge;
    private DogStatusEnum status;
    private String healthCondition;
    private Long shelterId;

    public Dog(Long id, String name, String breed, int estimatedAge, DogStatusEnum status, String healthCondition,
            Long shelterId) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.estimatedAge = estimatedAge;
        this.status = status;
        this.healthCondition = healthCondition;
        this.shelterId = shelterId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getEstimatedAge() {
        return estimatedAge;
    }

    public DogStatusEnum getStatus() {
        return status;
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public Long getShelterId() {
        return shelterId;
    }
}