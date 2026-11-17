package com.example.demo.domain;

public class Tools {
    private Long id;
    private String type;
    private int quantity;
    private Long shelterId;

    public Tools(Long id, String type, int quantity, Long shelterId) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.shelterId = shelterId;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getShelterId() {
        return shelterId;
    }
}