package com.example.demo.web;

public class ShelterToolResponse {
    private Long allocationId;
    private Long shelterId;
    private Long toolId;
    private String toolType;
    private int allocatedQuantity;

    public ShelterToolResponse(Long allocationId, Long shelterId, Long toolId, String toolType, int allocatedQuantity) {
        this.allocationId = allocationId;
        this.shelterId = shelterId;
        this.toolId = toolId;
        this.toolType = toolType;
        this.allocatedQuantity = allocatedQuantity;
    }

    public Long getAllocationId() {
        return allocationId;
    }

    public Long getShelterId() {
        return shelterId;
    }

    public Long getToolId() {
        return toolId;
    }

    public String getToolType() {
        return toolType;
    }

    public int getAllocatedQuantity() {
        return allocatedQuantity;
    }
}