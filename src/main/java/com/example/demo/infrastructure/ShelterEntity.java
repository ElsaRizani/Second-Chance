package com.example.demo.infrastructure;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "shelters")
public class ShelterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    private String name; 
    private String municipality; 
    private int capacity; 

    @OneToOne
    @JoinColumn(name = "manager_id")
    private StaffEntity manager;

    @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ToolsEntity> tools;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public StaffEntity getManager() {
        return manager;
    }

    public void setManager(StaffEntity manager) {
        this.manager = manager;
    }

    public List<ToolsEntity> getTools() {
        return tools;
    }

    public void setTools(List<ToolsEntity> tools) {
        this.tools = tools;
    }
}