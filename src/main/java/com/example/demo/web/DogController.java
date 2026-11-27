
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
    public Long registerFromCapture(
            @RequestParam String name,
            @RequestParam String breed,
            @RequestParam int age,
            @RequestParam String health,
            @RequestParam Long shelterId,
            @RequestParam Long captureId) {
        
        return dogService.registerDogFromCapture(name, breed, age, health, shelterId, captureId);
    }

    @PostMapping("/surrender")
    public Long registerFromSurrender(
            @RequestParam String name,
            @RequestParam String breed,
            @RequestParam int age,
            @RequestParam String health,
            @RequestParam Long shelterId,
            @RequestParam Long surrenderId) {
        
        return dogService.registerDogFromSurrender(name, breed, age, health, shelterId, surrenderId);
    }

    @PostMapping("/{dogId}/photo")
    public String addPhoto(
            @PathVariable Long dogId,
            @RequestParam String url,
            @RequestParam boolean isPrimary) {
        

                //i dergojme te dhenat ne DogService.java
        dogService.addPhoto(dogId, url, isPrimary);
        return "Foto u shtua me sukses per qenin me ID: " + dogId;
    }
}