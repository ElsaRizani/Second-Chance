package com.example.demo.infrastructure;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tools")
public class ToolsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private int quantity;

    @OneToMany(mappedBy = "tool")
    private List<ShelterToolsEntity> shelterTools;

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

    public List<ShelterToolsEntity> getShelterTools() {
        return shelterTools;
    }

    public void setShelterTools(List<ShelterToolsEntity> shelterTools) {
        this.shelterTools = shelterTools;
    }
}