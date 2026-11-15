package com.example.demo.infrastructure;
import jakarta.persistence.*;

@Entity 
@Table(name = "dog_photos")
public class DogPhotoEntity {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
    private boolean isPrimary;

    @ManyToOne 
    @JoinColumn (name = "dog_id")
    private DogEntity dog;
    
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public DogEntity getDog() {
        return dog;
    }

    public void setDog(DogEntity dog) {
        this.dog = dog;
    }

}
