package com.example.demo.application;

import com.example.demo.domain.Tools;
import com.example.demo.infrastructure.ShelterEntity;
import com.example.demo.infrastructure.ShelterRepository;
import com.example.demo.infrastructure.ShelterToolsEntity;
import com.example.demo.infrastructure.ShelterToolsRepository;
import com.example.demo.infrastructure.StaffEntity;
import com.example.demo.infrastructure.ToolsEntity;
import com.example.demo.infrastructure.ToolsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShelterToolService{

    private final ShelterRepository shelterRepository;
    private final ToolsRepository toolsRepository;
    private final ShelterToolsRepository shelterToolsRepository;

    public ShelterToolService(
            ShelterRepository shelterRepository,
            ToolsRepository toolsRepository,
            ShelterToolsRepository shelterToolsRepository) {
        this.shelterRepository = shelterRepository;
        this.toolsRepository = toolsRepository;
        this.shelterToolsRepository = shelterToolsRepository;
    }

    // workflow 1: Shtimi/alokimi i nje mjeti ne strehimore
    @Transactional
    public void addToolToShelter(
            Long shelterId,
            Long toolId,
            int requestedQuantity,
            Long currentManagerId) {

       
        ShelterEntity shelterEntity = shelterRepository.findById(shelterId)
                .orElseThrow(() -> new IllegalArgumentException("Strehimorja me id " + shelterId + " nuk u gjet."));

      
StaffEntity assignedManager = shelterEntity.getManager();
Long assignedManagerId = (assignedManager != null) ? assignedManager.getId() : null;

if (assignedManagerId == null || !assignedManagerId.equals(currentManagerId)) {
    throw new SecurityException(
            "Menaxheri me id " + currentManagerId + " nuk është i caktuar për këtë strehimore.");
}
        
        ToolsEntity toolEntity = toolsRepository.findById(toolId)
                .orElseThrow(() -> new IllegalArgumentException("Mjeti me id " + toolId + " nuk u gjet."));

        
        Tools toolDomain = new Tools(
                toolEntity.getId(),
                toolEntity.getType(),
                toolEntity.getQuantity(),
                shelterId);

      
        if (requestedQuantity <= 0) {
            throw new IllegalArgumentException("Sasia e kërkuar duhet të jetë më e madhe se 0.");
        }

        if (requestedQuantity > toolDomain.getQuantity()) {
            throw new IllegalStateException(
                    "Nuk ka mjaftueshëm sasi në stok. Në dispozicion: " + toolDomain.getQuantity());
        }

        int newStockQuantity = toolDomain.getQuantity() - requestedQuantity;

        
        toolEntity.setQuantity(newStockQuantity);
        toolsRepository.save(toolEntity);

  
        ShelterToolsEntity allocation = shelterToolsRepository
                .findByShelterIdAndToolId(shelterId, toolId)
                .map(existing -> {
                    existing.setQuantity(existing.getQuantity() + requestedQuantity);
                    return existing;
                })
                .orElseGet(() -> new ShelterToolsEntity(shelterEntity, toolEntity, requestedQuantity));

        shelterToolsRepository.save(allocation);
    }

    // Leximi i mjeteve per nje strehimore
    @Transactional(readOnly = true)
    public List<ShelterToolsEntity> getToolsByShelter(Long shelterId) {
        if (!shelterRepository.existsById(shelterId)) {
            throw new IllegalArgumentException("Strehimorja me id " + shelterId + " nuk u gjet.");
        }
        return shelterToolsRepository.findByShelterId(shelterId);
    }
}
