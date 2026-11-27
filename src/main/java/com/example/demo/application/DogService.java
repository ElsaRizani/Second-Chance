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

    // regjistrimi i nje qeni te ri ne strehe nga capture
    @Transactional
    public Long registerDogFromCapture(String name, String breed, int estimatedAge, String healthCondition,
            Long shelterId, Long captureId) {
        CaptureRecordEntity capture = captureRecordRepository.findById(captureId)
                .orElseThrow(() -> new IllegalArgumentException("Capture nuk u gjet."));

        if (dogRepository.existsByNameAndBreed(name, breed)) {
            throw new IllegalArgumentException("Ky qen ekziston tashme ne databaze!");
        }

        Dog dog = new Dog(null, name, breed, estimatedAge, DogStatusEnum.IN_SHELTER, healthCondition, shelterId);

        DogEntity entity = new DogEntity();
        entity.setName(dog.getName());
        entity.setBreed(dog.getBreed());
        entity.setEstimatedAge(dog.getEstimatedAge());
        entity.setStatus(dog.getStatus());
        entity.setHealthCondition(dog.getHealthCondition());
        entity.setShelterId(dog.getShelterId());
        entity.setCaptureRecord(capture);

        return dogRepository.save(entity).getId();

    }

    // regjistrimi i nje qeni nga surrenderRecords
    @Transactional
    public Long registerDogFromSurrender(String name, String breed, int estimatedAge, String healthCondition,
            Long shelterId, Long surrenderId) {
        SurrenderRecordEntity surrender = surrenderRecordRepository.findById(surrenderId)
                .orElseThrow(() -> new IllegalArgumentException("Surrender nuk u gjet."));

        if (dogRepository.existsByNameAndBreed(name, breed)) {
            throw new IllegalArgumentException("Ky qen ekziston tashme ne databaze!");
        }

        Dog dog = new Dog(null, name, breed, estimatedAge, DogStatusEnum.IN_SHELTER, healthCondition, shelterId);

        DogEntity entity = new DogEntity();
        entity.setName(dog.getName());
        entity.setBreed(dog.getBreed());
        entity.setEstimatedAge(dog.getEstimatedAge());
        entity.setStatus(dog.getStatus());
        entity.setHealthCondition(dog.getHealthCondition());
        entity.setShelterId(dog.getShelterId());
        entity.setSurrenderRecord(surrender);

        return dogRepository.save(entity).getId();
    }

    //shtimi i nje fotoje per nje qen
    @Transactional
    public void addPhoto(Long dogId, String url, boolean primary) {
        DogEntity dog = dogRepository.findById(dogId)
                .orElseThrow(() -> new IllegalArgumentException("Qeni nuk u gjet."));

        if (primary) {
            List<DogPhotoEntity> existing = dogPhotoRepository.findByDogId(dogId);
            for (DogPhotoEntity p : existing) {
                if (p.isPrimary()) {
                    p.setPrimary(false);
                    dogPhotoRepository.save(p);
                }
            }
        }

        DogPhotoEntity photo = new DogPhotoEntity();
        photo.setDog(dog);
        photo.setImageUrl(url);
        photo.setPrimary(primary);
        dogPhotoRepository.save(photo);
    }
}