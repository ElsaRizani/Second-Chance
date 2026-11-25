package com.example.demo.application;

import com.example.demo.domain.StrayReport;
import com.example.demo.infrastructure.CitizenProfileEntity;
import com.example.demo.infrastructure.CitizenProfileRepository;
import com.example.demo.infrastructure.StrayReportEntity;
import com.example.demo.infrastructure.StrayReportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StrayReportService{

    private final CitizenProfileRepository citizenProfileRepository;
    private final StrayReportRepository strayReportRepository;

    public StrayReportService(
            CitizenProfileRepository citizenProfileRepository,
            StrayReportRepository strayReportRepository) {
        this.citizenProfileRepository = citizenProfileRepository;
        this.strayReportRepository = strayReportRepository;
    }

    // workflow 1: Krijimi i nje raportimi per qen endacak
    @Transactional
    public void createStrayReport(
            Long currentUserId,
            String location,
            String description,
            String color,
            String photoURL) {

        CitizenProfileEntity reporter = getCitizenProfileByUserId(currentUserId);

        
        StrayReport reportDomain = new StrayReport(
                null,
                reporter.getId(),
                location,
                description,
                color,
                photoURL);

        
        StrayReportEntity entity = new StrayReportEntity();
        entity.setReporter(reporter);
        entity.setLocation(reportDomain.getLocation());
        entity.setDescription(reportDomain.getDescription());
        entity.setColor(reportDomain.getColor());
        entity.setPhotoURL(reportDomain.getPhotoURL());
        entity.setStatus(reportDomain.getStatus());

        
        strayReportRepository.save(entity);
    }

    // workflow 2: Perditesimi i te dhenave te raportimit nga pronari/raportuesi
    @Transactional
    public void updateStrayReport(
            Long reportId,
            Long currentUserId,
            String location,
            String description,
            String color,
            String photoURL) {

        CitizenProfileEntity reporter = getCitizenProfileByUserId(currentUserId);
        StrayReportEntity entity = strayReportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Raportimi me id " + reportId + " nuk u gjet."));

     
        Long existingReporterId = entity.getReporter() != null ? entity.getReporter().getId() : null;
        if (existingReporterId == null || !existingReporterId.equals(reporter.getId())) {
            throw new SecurityException("Nuk keni të drejtë të përditësoni këtë raportim.");
        }

        StrayReport reportDomain = new StrayReport(
                entity.getId(),
                existingReporterId,
                entity.getLocation(),
                entity.getDescription(),
                entity.getColor(),
                entity.getPhotoURL(),
                entity.getStatus());

        reportDomain.updateDetails(location, description, color, photoURL);

   
        entity.setLocation(reportDomain.getLocation());
        entity.setDescription(reportDomain.getDescription());
        entity.setColor(reportDomain.getColor());
        entity.setPhotoURL(reportDomain.getPhotoURL());

        strayReportRepository.save(entity);
    }

    // workflow 3: Ndryshimi i statusit te raportimit permes domain-it
    @Transactional
    public void updateReportStatus(Long reportId, String newStatus) {

      
        StrayReportEntity entity = strayReportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Raportimi me id " + reportId + " nuk u gjet."));

     
        Long reporterId = entity.getReporter() != null ? entity.getReporter().getId() : null;
        StrayReport reportDomain = new StrayReport(
                entity.getId(),
                reporterId,
                entity.getLocation(),
                entity.getDescription(),
                entity.getColor(),
                entity.getPhotoURL(),
                entity.getStatus());

        reportDomain.changeStatus(newStatus);

        
        entity.setStatus(reportDomain.getStatus());
        strayReportRepository.save(entity);
    }

    // workflow 4: Fshirja e raportimit nga raportuesi
    @Transactional
    public void deleteStrayReport(Long reportId, Long currentUserId) {
        CitizenProfileEntity reporter = getCitizenProfileByUserId(currentUserId);

        StrayReportEntity entity = strayReportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Raportimi me id " + reportId + " nuk u gjet."));

        if (entity.getReporter() == null || !entity.getReporter().getId().equals(reporter.getId())) {
            throw new SecurityException("Nuk keni të drejtë të fshini këtë raportim.");
        }

        strayReportRepository.delete(entity);
    }

    // Leximi i raportimeve te perdoruesit aktual
    @Transactional(readOnly = true)
    public List<StrayReportEntity> getReportsByCurrentUser(Long currentUserId) {
        CitizenProfileEntity reporter = getCitizenProfileByUserId(currentUserId);
        return strayReportRepository.findByReporter_Id(reporter.getId());
    }

    // Leximi i te gjitha raportimeve
    @Transactional(readOnly = true)
    public List<StrayReportEntity> getAllStrayReports() {
        return strayReportRepository.findAll();
    }

    private CitizenProfileEntity getCitizenProfileByUserId(Long currentUserId) {
        return citizenProfileRepository.findByUser_Id(currentUserId)
                .orElseThrow(() -> new IllegalStateException(
                        "Përdoruesi me id " + currentUserId + " nuk ka profil qytetari."));
    }
}