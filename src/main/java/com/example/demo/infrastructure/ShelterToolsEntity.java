package com.example.demo.infrastructure;

import jakarta.persistence.*;

@Entity
@Table(name = "shelter_tools")
public class ShelterToolsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shelter_id", nullable = false)
    private ShelterEntity shelter;

    @ManyToOne
    @JoinColumn(name = "tool_id", nullable = false)
    private ToolsEntity tool;

    private int quantity;

    public ShelterToolsEntity() {
    }

    public ShelterToolsEntity(ShelterEntity shelter, ToolsEntity tool, int quantity) {
        this.shelter = shelter;
        this.tool = tool;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShelterEntity getShelter() {
        return shelter;
    }

    public void setShelter(ShelterEntity shelter) {
        this.shelter = shelter;
    }

    public ToolsEntity getTool() {
        return tool;
    }

    public void setTool(ToolsEntity tool) {
        this.tool = tool;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}