package com.example.demo.infrastructure;

import com.example.demo.domain.DogStatusEnum;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "dogs")
public class DogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    private int estimatedAge;
    private String healthCondition;
    @Enumerated(EnumType.STRING)
    private DogStatusEnum status;
    private Long shelterId;

    public Long getShelterId() {
        return shelterId;
    }

    public void setShelterId(Long shelterId) {
        this.shelterId = shelterId;
    }

    @OneToMany(mappedBy = "dog", cascade = CascadeType.ALL)
    private List<DogPhotoEntity> photos;

    @OneToOne
    @JoinColumn(name = "surrender_record_id")
    private SurrenderRecordEntity surrenderRecord;

    @OneToOne
    @JoinColumn(name = "capture_record_id")
    private CaptureRecordEntity captureRecord;

    @OneToMany(mappedBy = "dog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmergencyCaseEntity> emergencyCases;

    @OneToMany(mappedBy = "dog")
    private List<VaccinationsEntity> vaccinations;

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

    public DogStatusEnum getStatus() {
        return status;
    }

    public void setStatus(DogStatusEnum status) {
        this.status = status;
    }

    public List<DogPhotoEntity> getPhotos() {
        return photos;
    }

    public void setPhotos(List<DogPhotoEntity> photos) {
        this.photos = photos;
    }

    public SurrenderRecordEntity getSurrenderRecord() {
        return surrenderRecord;
    }

    public void setSurrenderRecord(SurrenderRecordEntity surrenderRecord) {
        this.surrenderRecord = surrenderRecord;
    }

    public CaptureRecordEntity getCaptureRecord() {
        return captureRecord;
    }

    public void setCaptureRecord(CaptureRecordEntity captureRecord) {
        this.captureRecord = captureRecord;
    }

    public List<EmergencyCaseEntity> getEmergencyCases() {
        return emergencyCases;
    }

    public void setEmergencyCases(List<EmergencyCaseEntity> emergencyCases) {
        this.emergencyCases = emergencyCases;
    }
}