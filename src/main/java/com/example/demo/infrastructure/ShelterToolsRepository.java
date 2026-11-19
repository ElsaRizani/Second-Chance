package com.example.demo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ShelterToolsRepository extends JpaRepository<ShelterToolsEntity, Long> {

    Optional<ShelterToolsEntity> findByShelterIdAndToolId(Long shelterId, Long toolId);

    List<ShelterToolsEntity> findByShelterId(Long shelterId);

    List<ShelterToolsEntity> findByToolId(Long toolId);
}