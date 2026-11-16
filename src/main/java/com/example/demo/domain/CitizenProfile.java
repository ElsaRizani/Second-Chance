package com.example.demo.domain;

public class CitizenProfile {

    private Long id;
    private Long userId;
    private String address;
    private String phone;

    public CitizenProfile() {
    }

    public CitizenProfile(Long id, Long userId, String address, String phone) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}