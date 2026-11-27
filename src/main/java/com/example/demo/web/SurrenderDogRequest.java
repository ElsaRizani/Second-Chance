package com.example.demo.web;

public record SurrenderDogRequest(
        String name,
        String breed,
        int age,
        String health,
        Long shelterId,
        Long surrenderId) {

}
