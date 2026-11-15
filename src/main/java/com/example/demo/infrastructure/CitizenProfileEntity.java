package com.example.demo.infrastructure;

import jakarta.persistence.*;

@Entity
@Table(name = "citizenProfile")
public class CitizenProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    private String address;
    private String phone;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserEntity getUserid() {
        return user;
    }

    public void setUserid(UserEntity userid) {
        this.user = userid;
    }

}