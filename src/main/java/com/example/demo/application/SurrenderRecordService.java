package com.example.demo.application;

import com.example.demo.domain.SurrenderRecord;
import com.example.demo.infrastructure.CitizenProfileEntity;
import com.example.demo.infrastructure.CitizenProfileRepository;
import com.example.demo.infrastructure.SurrenderRecordEntity;
import com.example.demo.infrastructure.SurrenderRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class SurrenderRecordService {

    private final SurrenderRecordRepository surrenderRecordRepository;
    private final CitizenProfileRepository citizenProfileRepository;

    public SurrenderRecordService(
            SurrenderRecordRepository surrenderRecordRepository,
            CitizenProfileRepository citizenProfileRepository) {
        this.surrenderRecordRepository = surrenderRecordRepository;
        this.citizenProfileRepository = citizenProfileRepository;
    }

    // workflow 1: Qytetari poston dorezimin e qenit
    @Transactional
    public void createSurrenderRecord(
            Long currentUserId,
            String name,
            String lastName,
            String reason,
            LocalDate surrenderDate) {

        
        CitizenProfileEntity citizen = getCitizenProfileByUserId(currentUserId);

        SurrenderRecord domainRecord = new SurrenderRecord(
                null,
                citizen.getId(),
                name,
                lastName,
                reason,
                surrenderDate);

        SurrenderRecordEntity entity = new SurrenderRecordEntity();
        entity.setCitizen(citizen);
        entity.setName(domainRecord.getName());
        entity.setLastName(domainRecord.getLastName());
        entity.setReason(domainRecord.getReason());
        entity.setSurrenderDate(domainRecord.getSurrenderDate());

        surrenderRecordRepository.save(entity);
    }

    // workflow 2: Perditesimi i te dhenave te dorezimit nga qytetari qe e ka postuar
    @Transactional
    public void updateSurrenderRecord(
            Long recordId,
            Long currentUserId,
            String name,
            String lastName,
            String reason,
            LocalDate surrenderDate) {

        CitizenProfileEntity citizen = getCitizenProfileByUserId(currentUserId);

        SurrenderRecordEntity entity = surrenderRecordRepository.findById(recordId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Regjistrimi i dorëzimit me id " + recordId + " nuk u gjet."));

        Long existingCitizenId = entity.getCitizen() != null ? entity.getCitizen().getId() : null;
        if (existingCitizenId == null || !existingCitizenId.equals(citizen.getId())) {
            throw new SecurityException("Nuk keni të drejtë të përditësoni këtë regjistrim dorëzimi.");
        }

        SurrenderRecord domainRecord = new SurrenderRecord(
                entity.getId(),
                existingCitizenId,
                entity.getName(),
                entity.getLastName(),
                entity.getReason(),
                entity.getSurrenderDate());

        domainRecord.updateDetails(name, lastName, reason, surrenderDate);

        entity.setName(domainRecord.getName());
        entity.setLastName(domainRecord.getLastName());
        entity.setReason(domainRecord.getReason());
        entity.setSurrenderDate(domainRecord.getSurrenderDate());

        surrenderRecordRepository.save(entity);
    }

    // workflow 3: Fshirja e regjistrimit te dorezimit nga qytetari pronar
    @Transactional
    public void deleteSurrenderRecord(Long recordId, Long currentUserId) {
        CitizenProfileEntity citizen = getCitizenProfileByUserId(currentUserId);

        SurrenderRecordEntity entity = surrenderRecordRepository.findById(recordId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Regjistrimi i dorëzimit me id " + recordId + " nuk u gjet."));

        if (entity.getCitizen() == null || !entity.getCitizen().getId().equals(citizen.getId())) {
            throw new SecurityException("Nuk keni të drejtë të fshini këtë regjistrim dorëzimi.");
        }

        surrenderRecordRepository.delete(entity);
    }

    // Leximi i te gjitha regjistrimeve te dorezimit
    @Transactional(readOnly = true)
    public List<SurrenderRecordEntity> getAllSurrenderRecords() {
        return surrenderRecordRepository.findAll();
    }

    // Leximi i regjistrimeve te qytetarit aktual
    @Transactional(readOnly = true)
    public List<SurrenderRecordEntity> getSurrenderRecordsByCurrentUser(Long currentUserId) {
        CitizenProfileEntity citizen = getCitizenProfileByUserId(currentUserId);
        return surrenderRecordRepository.findByCitizen_Id(citizen.getId());
    }

    private CitizenProfileEntity getCitizenProfileByUserId(Long currentUserId) {
        return citizenProfileRepository.findByUser_Id(currentUserId)
                .orElseThrow(() -> new IllegalStateException(
                        "Përdoruesi me id " + currentUserId + " nuk ka profil qytetari."));
    }
}