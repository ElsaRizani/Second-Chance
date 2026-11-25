package com.example.demo.application;

import com.example.demo.domain.EmergencyCase;
import com.example.demo.infrastructure.DogEntity;
import com.example.demo.infrastructure.DogRepository;
import com.example.demo.infrastructure.EmergencyCaseEntity;
import com.example.demo.infrastructure.EmergencyCaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmergencyCaseService {

    private static final String CRITICAL_HEALTH_CONDITION = "CRITICAL";
    private static final String DEFAULT_OPEN_STATUS = "OPEN";

    private final DogRepository dogRepository;
    private final EmergencyCaseRepository emergencyCaseRepository;

    public EmergencyCaseService(
            DogRepository dogRepository,
            EmergencyCaseRepository emergencyCaseRepository) {
        this.dogRepository = dogRepository;
        this.emergencyCaseRepository = emergencyCaseRepository;
    }

    // workflow 1: Raportimi i nje rasti emergjent per nje qen
    @Transactional
    public void reportEmergencyCase(Long dogId, String description, LocalDate reportedDate) {

        // 1. e gjejme qenin ne databaze
        DogEntity dog = dogRepository.findById(dogId)
                .orElseThrow(() -> new IllegalArgumentException("Qeni nuk u gjet."));

        int dogIdInt = dogId.intValue();

        // 2. e krijojme objektin e domain-it (rregullat e biznesit i ka brenda)
        EmergencyCase emergencyCase = new EmergencyCase(
                null,
                dogIdInt,
                description,
                DEFAULT_OPEN_STATUS,
                reportedDate);

        // 3. krijojme entitetin dhe mapojme te dhenat nga domain-i
        EmergencyCaseEntity entity = new EmergencyCaseEntity();
        entity.setDog(dog);
        entity.setDescription(emergencyCase.getDescription());
        entity.setStatus(emergencyCase.getStatus());
        entity.setReportedDate(emergencyCase.getReportedDate());

        // 4. e ruajme rastin emergjent
        emergencyCaseRepository.save(entity);

        // 5. e perditesojme gjendjen shendetesore te qenit ne CRITICAL dhe e ruajme
        dog.setHealthCondition(CRITICAL_HEALTH_CONDITION);
        dogRepository.save(dog);
    }

    // workflow 2: Ndryshimi i statusit te rastit emergjent permes domain-it
    @Transactional
    public void updateEmergencyCaseStatus(Long caseId, String newStatus) {

        // 1. e gjejme rastin ne databaze
        EmergencyCaseEntity entity = emergencyCaseRepository.findById(caseId)
                .orElseThrow(() -> new IllegalArgumentException("Rasti i emergjencës nuk u gjet."));

        int dogIdInt = (entity.getDog() != null && entity.getDog().getId() != null)
                ? entity.getDog().getId().intValue()
                : 0;

        // 2. e rindertojme domain-in dhe e aplikojme ndryshimin e statusit (rregulli i biznesit)
        EmergencyCase emergencyCase = new EmergencyCase(
                entity.getId(),
                dogIdInt,
                entity.getDescription(),
                entity.getStatus(),
                entity.getReportedDate());

        emergencyCase.updateStatus(newStatus);

        // 3. e perditesojme statusin te entiteti dhe e ruajme
        entity.setStatus(emergencyCase.getStatus());
        emergencyCaseRepository.save(entity);
    }

    // workflow 3: Fshirja e rastit emergjent
    @Transactional
    public void deleteEmergencyCase(Long caseId) {
        EmergencyCaseEntity entity = emergencyCaseRepository.findById(caseId)
                .orElseThrow(() -> new IllegalArgumentException("Rasti i emergjencës nuk u gjet."));

        emergencyCaseRepository.delete(entity);
    }

    // Leximi i rasteve sipas qenit
    @Transactional(readOnly = true)
    public List<EmergencyCaseEntity> getEmergencyCasesByDog(Long dogId) {
        if (!dogRepository.existsById(dogId)) {
            throw new IllegalArgumentException("Qeni nuk u gjet.");
        }
        return emergencyCaseRepository.findByDog_Id(dogId);
    }

    // Leximi i te gjitha rasteve
    @Transactional(readOnly = true)
    public List<EmergencyCaseEntity> getAllEmergencyCases() {
        return emergencyCaseRepository.findAll();
    }
}
