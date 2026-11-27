package com.example.demo.web;

public record CaptureRequest(
        String name,
        String breed,
        int age,
        String health,
        Long shelterId,
        Long captureId) {
}
