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

    @PostMapping("/apply")
    public String submitApplication(@RequestBody AdoptionApplicationRequest request) {
        adoptionService.submitApplication(request.dogId(), request.citizenId());
        return "Aplikimi per adoptim u dergua me sukses per qenin me ID: " + request.dogId();
    }

    @PostMapping("/approve")
    public String approveApplication(@RequestBody AdoptionApproveRequest request) {
        adoptionService.approveApplication(request.applicationId(), request.feePaid());
        return "Aplikimi me ID " + request.applicationId() + " u aprovua! Kontrata u krijua dhe qeni u adoptua.";
    }
}
