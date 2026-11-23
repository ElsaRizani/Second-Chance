package com.example.demo.application;

import com.example.demo.domain.Dog;
import com.example.demo.domain.DogStatusEnum;
import com.example.demo.infrastructure.DogEntity;
import com.example.demo.infrastructure.DogPhotoEntity;
import com.example.demo.infrastructure.DogPhotoRepository;
import com.example.demo.infrastructure.DogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DogService {
    private final DogRepository dogRepository;
    private final DogPhotoRepository dogPhotoRepository;

    public DogService(DogRepository dogRepository, DogPhotoRepository dogPhotoRepository) {
        this.dogRepository = dogRepository;
        this.dogPhotoRepository = dogPhotoRepository;
    }

    // workflow 1: regjistrimi i nje qeni te ri ne strehe
    @Transactional
    public Long registerDog(String name, String breed, int estimatedAge, String healthCondition, Long shelterId) {
        // e krijojme domain (rregulli: fillon automatikisht si IN_SHELTER sepse nuk mundemi me marr foto nga qen qe nuk jane ne shelter)
        Dog dog = new Dog(null, name, breed, estimatedAge, DogStatusEnum.IN_SHELTER, healthCondition, shelterId);

        // mapojme te dhenat ne entity
        DogEntity entity = new DogEntity();
        entity.setName(dog.getName());
        entity.setBreed(dog.getBreed());
        entity.setEstimatedAge(dog.getEstimatedAge());
        entity.setStatus(dog.getStatus());
        entity.setHealthCondition(dog.getHealthCondition());
        entity.setShelterId(dog.getShelterId());

        // e ruajme ne db
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