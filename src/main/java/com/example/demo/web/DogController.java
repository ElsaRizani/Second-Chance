package com.example.demo.web;

import com.example.demo.application.DogService;
import org.springframework.web.bind.annotation.*;

@RestController// i tregon spring boot se kjo klase merret me web requests dhe kthen text ose
                // JSON files
@RequestMapping("/dogs")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping("/capture")
    public Long registerFromCapture(@RequestBody CaptureRequest request) {
        return dogService.registerDogFromCapture(
                request.name(),
                request.breed(),
                request.age(),
                request.health(),
                request.shelterId(),
                request.captureId()
        );
    }

    @PostMapping("/surrender")
    public Long registerFromSurrender(@RequestBody SurrenderDogRequest request) {
        return dogService.registerDogFromSurrender(
                request.name(),
                request.breed(),
                request.age(),
                request.health(),
                request.shelterId(),
                request.surrenderId()
        );
    }

    @PostMapping("/{dogId}/photo")
    public String addPhoto(
            @PathVariable Long dogId,
            @RequestBody DogPhotoRequest request) {
        dogService.addPhoto(dogId, request.url(), request.isPrimary());
        return "Foto u shtua me sukses per qenin me ID: " + dogId;
    }
}