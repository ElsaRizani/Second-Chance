package com.example.demo.infrastructure;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "dog_sponsorships")
public class DogSponsorshipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "citizen_id")
    private CitizenProfileEntity citizen;

    @ManyToOne
    @JoinColumn(name = "dog_id")
    private DogEntity dog;

    private BigDecimal monthlyAmount;
    private String currency;
    private String status;
    private LocalDate startDate;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public CitizenProfileEntity getCitizen() { return citizen; }
    public void setCitizen(CitizenProfileEntity citizen) { this.citizen = citizen; }

    public DogEntity getDog() { return dog; }
    public void setDog(DogEntity dog) { this.dog = dog; }

    public BigDecimal getMonthlyAmount() { return monthlyAmount; }
    public void setMonthlyAmount(BigDecimal monthlyAmount) { this.monthlyAmount = monthlyAmount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
}