package com.example.demo.domain;

import java.time.LocalDate;

public class InKindDonation {
    private Long id;
    private Long citizenId;
    private String itemName;       // Ushqimi per qen,mbuloje,shampon,etj
    private Integer quantity;      
    private String unit;           //Thase,cope,kg
    private String status;         // Pending,Received,Cancelled
    private LocalDate donatedDate;

    public InKindDonation(Long id, Long citizenId, String itemName, Integer quantity, String unit) {
        this.id = id;
        this.citizenId = citizenId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.unit = unit;
        this.status = "Pending";
        this.donatedDate = LocalDate.now();
    }

    public void markAsReceived() {
        if (!"Pending".equals(this.status)) {
            throw new IllegalStateException("Donacioni material nuk mund të shënohet si i pranuar. Statusi: " + this.status);
        }
        this.status = "Received";
    }

    public void cancel() {
        if ("Received".equals(this.status)) {
            throw new IllegalStateException("Nuk mund të anulohet një donacion që tashmë është pranuar.");
        }
        this.status = "Cancelled";
    }

    public Long getId() { return id; }
    public Long getCitizenId() { return citizenId; }
    public String getItemName() { return itemName; }
    public Integer getQuantity() { return quantity; }
    public String getUnit() { return unit; }
    public String getStatus() { return status; }
    public LocalDate getDonatedDate() { return donatedDate; }
}