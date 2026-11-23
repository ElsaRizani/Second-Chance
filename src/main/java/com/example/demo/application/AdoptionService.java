package com.example.demo.application;

import com.example.demo.domain.AdoptionApplication;
import com.example.demo.infrastructure.*;
import com.example.demo.domain.AdoptionContract;
import com.example.demo.domain.DogStatusEnum;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdoptionService {
    private final AdoptionApplicationRepository applicationRepository;
    private final AdoptionContractRepository contractRepository;
    private final DogRepository dogRepository;
    private final CitizenProfileRepository citizenRepository;

    public AdoptionService(AdoptionApplicationRepository applicationRepository,
            AdoptionContractRepository contractRepository,
            DogRepository dogRepository,
            CitizenProfileRepository citizenRepository) {
        this.applicationRepository = applicationRepository;
        this.contractRepository = contractRepository;
        this.dogRepository = dogRepository;
        this.citizenRepository = citizenRepository;
    }

    // workflow 1: e bejme submit nje aplikacion per adoptim te nje qeni
    @Transactional
    public void submitApplication(Long dogId, Long citizenId) {

        // e gjejme qenin
        DogEntity dog = dogRepository.findById(dogId)
                .orElseThrow(() -> new IllegalArgumentException("Qeni nuk u gjet."));

        // e gjejme qytetarin
        CitizenProfileEntity citizen = citizenRepository.findById(citizenId)
                .orElseThrow(() -> new IllegalArgumentException("Qytetari nuk u gjet."));

        // e krijojme domain me rregullat qe i ka(te biznesit)
        AdoptionApplication app = new AdoptionApplication(null, dogId, citizenId);

        // e krijojme entitetin dhe mapojme te dhenat nga domain
        AdoptionApplicationEntity entity = new AdoptionApplicationEntity();
        entity.setDog(dog);
        entity.setCitizen(citizen);
        entity.setStatus(app.getStatus());
        entity.setApplicationDate(app.getApplicationDate());

        // e ruajme procesin
        applicationRepository.save(entity);
    }

    // workflow 2: e aprovojme aplikacioning, > e krijojme kontraten, > qeni adoptohet
    @Transactional
    public void approveApplication(Long applicationId, boolean feePaid) {

        // e gjejme aplikimin ne databaze
        AdoptionApplicationEntity entity = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new IllegalArgumentException("Aplikimi nuk u gjet."));

        // e krijojme domain-in dhe e aprovojme (rregulli i biznesit)
        AdoptionApplication app = new AdoptionApplication(
                entity.getId(),
                entity.getDog().getId(),
                entity.getCitizen().getId());
        app.approve();

        // e ruajme statusin e ri te aplikimit
        entity.setStatus(app.getStatus());
        applicationRepository.save(entity);

        // krijojme kontraten (rregulli i biznesit prej domain)
        AdoptionContract contract = new AdoptionContract(null, entity.getId(), feePaid);
        contract.finalizeContract();

        // mapojme te dhenat e kontrates dhe e ruajme
        AdoptionContractEntity contractEntity = new AdoptionContractEntity();
        contractEntity.setApplication(entity);
        contractEntity.setContractDate(contract.getContractDate());
        contractEntity.setFeePaid(contract.getFeePaid());
        contractEntity.setStatus(contract.getStatus());
        contractRepository.save(contractEntity);

        // e gjejme qenin, e ndryshojme statusin ne ADOPTED dhe e ruajme
        DogEntity dog = entity.getDog();
        dog.setStatus(DogStatusEnum.ADOPTED);
        dogRepository.save(dog);
    }
}