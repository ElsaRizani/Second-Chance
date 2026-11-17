package com.example.demo.infrastructure;

import jakarta.persistence.*;

@Entity
@Table(name = "tools")
public class ToolsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private ShelterEntity shelter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ShelterEntity getShelter() {
        return shelter;
    }

    public void setShelter(ShelterEntity shelter) {
        this.shelter = shelter;
    }
}