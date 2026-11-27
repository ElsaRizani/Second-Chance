package com.example.demo.web;

import com.example.demo.application.AdoptionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adoptions")
public class AdoptionController {

    private final AdoptionService adoptionService;

    public AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @GetMapping("/apply")
    public String submitApplication(
            @RequestParam Long dogId,
            @RequestParam Long citizenId) {
        
        adoptionService.submitApplication(dogId, citizenId);
        return "Aplikimi per adoptim u dergua me sukses per qenin me ID: " + dogId;
    }

    @GetMapping("/approve")
    public String approveApplication(
            @RequestParam Long applicationId,
            @RequestParam boolean feePaid) {
        
        adoptionService.approveApplication(applicationId, feePaid);
        return "Aplikimi me ID " + applicationId + " u aprovua! Kontrata u krijua dhe qeni u adoptua.";
    }
}