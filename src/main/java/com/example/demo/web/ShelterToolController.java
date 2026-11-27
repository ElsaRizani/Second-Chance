package com.example.demo.web;

import com.example.demo.application.ShelterToolService;
import com.example.demo.infrastructure.ShelterToolsEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shelters/{shelterId}/tools")
public class ShelterToolController {

    private final ShelterToolService shelterToolService;

    public ShelterToolController(ShelterToolService shelterToolService) {
        this.shelterToolService = shelterToolService;
    }

    // POST /api/shelters/{shelterId}/tools
    @PostMapping
    public ResponseEntity<String> allocateToolToShelter(
            @PathVariable Long shelterId,
            @RequestHeader("X-Manager-Id") Long currentManagerId,
            @RequestBody AllocateToolRequest request) {

        shelterToolService.addToolToShelter(
                shelterId,
                request.getToolId(),
                request.getRequestedQuantity(),
                currentManagerId
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Mjeti u alokua me sukses në strehimore.");
    }

    // GET /api/shelters/{shelterId}/tools
    @GetMapping
    public ResponseEntity<List<ShelterToolResponse>> getToolsByShelter(@PathVariable Long shelterId) {
        List<ShelterToolsEntity> allocations = shelterToolService.getToolsByShelter(shelterId);

        List<ShelterToolResponse> response = allocations.stream()
                .map(item -> new ShelterToolResponse(
                        item.getId(),
                        item.getShelter().getId(),
                        item.getTool().getId(),
                        item.getTool().getType(),
                        item.getQuantity()
                ))
                .toList();

        return ResponseEntity.ok(response);
    }
}