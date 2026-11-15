package com.example.demo.infrastructure;

import jakarta.persistence.*;
import java.util.List;

@Entity 
@Table(name = "dogs")
public class DogEntity {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    private int estimatedAge;
    private String healthCondition;
    private String status; //stray, in_shelter, adopted

    @OneToMany (mappedBy = "dog", cascade = CascadeType.ALL)
    private List<DogPhotoEntity> photos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getEstimatedAge() {
        return estimatedAge;
    }

    public void setEstimatedAge(int estimatedAge) {
        this.estimatedAge = estimatedAge;
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(String healthCondition) {
        this.healthCondition = healthCondition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DogPhotoEntity> getPhotos() {
        return photos;
    }

    public void setPhotos(List<DogPhotoEntity> photos) {
        this.photos = photos;
    }

    
}
