package com.example.demo.application;

import com.example.demo.domain.Dog;
import com.example.demo.domain.DogStatusEnum;
import com.example.demo.infrastructure.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DogService {
    private final DogRepository dogRepository;
    private final DogPhotoRepository dogPhotoRepository;
    private final CaptureRecordRepository captureRecordRepository;
    private final SurrenderRecordRepository surrenderRecordRepository;

    public DogService(DogRepository dogRepository, DogPhotoRepository dogPhotoRepository, 
                      CaptureRecordRepository captureRecordRepository, SurrenderRecordRepository surrenderRecordRepository) {
        this.dogRepository = dogRepository;
        this.dogPhotoRepository = dogPhotoRepository;
        this.captureRecordRepository = captureRecordRepository;
        this.surrenderRecordRepository = surrenderRecordRepository;
    }

    // workflow 1: regjistrimi i nje qeni te ri ne strehe nga capture
    @Transactional
    public Long registerDogFromCapture(String name, String breed, int estimatedAge, String healthCondition, Long shelterId, Long captureId) {

        // e gjejme capture record ne db
        CaptureRecordEntity capture = captureRecordRepository.findById(captureId)
                .orElseThrow(() -> new IllegalArgumentException("Capture nuk u gjet."));

        Dog dog = new Dog(null, name, breed, estimatedAge, DogStatusEnum.IN_SHELTER, healthCondition, shelterId);

        DogEntity entity = new DogEntity();
        entity.setName(dog.getName());
        entity.setBreed(dog.getBreed());
        entity.setEstimatedAge(dog.getEstimatedAge());
        entity.setStatus(dog.getStatus());
        entity.setHealthCondition(dog.getHealthCondition());
        entity.setShelterId(dog.getShelterId());
        
        // e lidhim qenin me capture
        entity.setCaptureRecord(capture);

        return dogRepository.save(entity).getId();
    }

    // regjistrimi i nje qeni nga surrenderRecords(owner gives up their dog)
    @Transactional
    public Long registerDogFromSurrender(String name, String breed, int estimatedAge, String healthCondition, Long shelterId, Long surrenderId) {
        
        // e gjejme surrender record ne db
        SurrenderRecordEntity surrender = surrenderRecordRepository.findById(surrenderId)
                .orElseThrow(() -> new IllegalArgumentException("Surrender nuk u gjet."));

        Dog dog = new Dog(null, name, breed, estimatedAge, DogStatusEnum.IN_SHELTER, healthCondition, shelterId);

        DogEntity entity = new DogEntity();
        entity.setName(dog.getName());
        entity.setBreed(dog.getBreed());
        entity.setEstimatedAge(dog.getEstimatedAge());
        entity.setStatus(dog.getStatus());
        entity.setHealthCondition(dog.getHealthCondition());
        entity.setShelterId(dog.getShelterId());

        // e lidhim qenin me surrender
        entity.setSurrenderRecord(surrender);

        return dogRepository.save(entity).getId();
    }

    // workflow 2: shtimi i nje fotoje per nje qen
    @Transactional
    public void addPhoto(Long dogId, String url, boolean primary) {
        
        // e gjejme qenin ne db
        DogEntity dog = dogRepository.findById(dogId)
                .orElseThrow(() -> new IllegalArgumentException("Qeni nuk u gjet."));

        // nese kjo eshte foto kryesore, remove 'primary' nga fotot tjera
        if (primary) {
            List<DogPhotoEntity> existing = dogPhotoRepository.findByDogId(dogId);
            for (DogPhotoEntity p : existing) {
                if (p.isPrimary()) {
                    p.setPrimary(false);
                    dogPhotoRepository.save(p);
                }
            }
        }

        // e ruajme foton e re
        DogPhotoEntity photo = new DogPhotoEntity();
        photo.setDog(dog);
        photo.setImageUrl(url);
        photo.setPrimary(primary);
        dogPhotoRepository.save(photo);
    }
}