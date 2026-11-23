package com.example.demo.infrastructure;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "capture_records")
public class CaptureRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate captureDate;

    @OneToOne
    @JoinColumn(name = "stray_report_id", unique = true)
    private StrayReportEntity strayReport;

    @OneToOne
    @JoinColumn(name = "dog_id")
    private DogEntity dog;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(LocalDate captureDate) {
        this.captureDate = captureDate != null ? captureDate : LocalDate.now();
    }

    public StrayReportEntity getStrayReport() {
        return strayReport;
    }

    public void setStrayReport(StrayReportEntity strayReport) {
        this.strayReport = strayReport;
    }

    public DogEntity getDog() {
        return dog;
    }

    public void setDog(DogEntity dog) {
        this.dog = dog;
    }
}