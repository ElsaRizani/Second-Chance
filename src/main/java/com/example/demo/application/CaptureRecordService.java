package com.example.demo.application;

import com.example.demo.domain.CaptureRecord;
import com.example.demo.infrastructure.CaptureRecordEntity;
import com.example.demo.infrastructure.CaptureRecordRepository;
import com.example.demo.infrastructure.StrayReportEntity;
import com.example.demo.infrastructure.StrayReportRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CaptureRecordService{

    private final CaptureRecordRepository captureRecordRepository;
    private final StrayReportRepository strayReportRepository;

    public CaptureRecordService(
            CaptureRecordRepository captureRecordRepository,
            StrayReportRepository strayReportRepository) {
        this.captureRecordRepository = captureRecordRepository;
        this.strayReportRepository = strayReportRepository;
    }

    // workflow 1: Admini shton nje capture record nese ekziston strayReportId
    @Transactional
    public void createCaptureRecord(Long strayReportId, LocalDate captureDate) {

        
        StrayReportEntity strayReport = strayReportRepository.findById(strayReportId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Raportimi me id " + strayReportId + " nuk u gjet."));

        if (captureRecordRepository.existsByStrayReport_Id(strayReportId)) {
            throw new IllegalStateException(
                    "Ky raportim tashmë ka një capture record.");
        }

        CaptureRecord domainRecord = new CaptureRecord(null, strayReportId, captureDate);

        CaptureRecordEntity entity = new CaptureRecordEntity();
        entity.setStrayReport(strayReport);
        entity.setCaptureDate(domainRecord.getCaptureDate());

        captureRecordRepository.save(entity);
    }

    // workflow 2: Perditesimi i nje capture record (p.sh. daten e kapjes ose raportimin e lidhur)
    @Transactional
    public void updateCaptureRecord(Long id, Long strayReportId, LocalDate captureDate) {

        CaptureRecordEntity entity = captureRecordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Capture record me id " + id + " nuk u gjet."));

        StrayReportEntity strayReport = strayReportRepository.findById(strayReportId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Raportimi me id " + strayReportId + " nuk u gjet."));

        Long currentStrayReportId = entity.getStrayReport() != null ? entity.getStrayReport().getId() : null;
        if (currentStrayReportId == null || !currentStrayReportId.equals(strayReportId)) {
            if (captureRecordRepository.existsByStrayReport_Id(strayReportId)) {
                throw new IllegalStateException(
                        "Ky raportim tashmë ka një capture record.");
            }
        }

        CaptureRecord domainRecord = new CaptureRecord(
                entity.getId(),
                strayReportId,
                captureDate);

        entity.setStrayReport(strayReport);
        entity.setCaptureDate(domainRecord.getCaptureDate());

        captureRecordRepository.save(entity);
    }

    @Transactional
    public void deleteCaptureRecord(Long id) {
        CaptureRecordEntity entity = captureRecordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Capture record me id " + id + " nuk u gjet."));

        captureRecordRepository.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<CaptureRecordEntity> getAllCaptureRecords() {
        return captureRecordRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CaptureRecordEntity getCaptureRecordById(Long id) {
        return captureRecordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Capture record me id " + id + " nuk u gjet."));
    }
}