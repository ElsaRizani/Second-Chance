package com.example.demo.infrastructure;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "in_kind_donations")
public class InKindDonationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "citizen_id")
    private CitizenProfileEntity citizen;

    private String itemName;
    private Integer quantity;
    private String unit;
    private String status;
    private LocalDate donatedDate;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public CitizenProfileEntity getCitizen() { return citizen; }
    public void setCitizen(CitizenProfileEntity citizen) { this.citizen = citizen; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDonatedDate() { return donatedDate; }
    public void setDonatedDate(LocalDate donatedDate) { this.donatedDate = donatedDate; }
}