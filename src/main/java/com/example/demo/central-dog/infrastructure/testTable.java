package com.example.demo.adoption.infrastructure;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class testTable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
