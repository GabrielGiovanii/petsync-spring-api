package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.VaccineHistory;
import com.petsync_spring_api.petsync_spring_api.services.VaccineHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "vaccine_history")
public class VaccineHistoryController {

    @Autowired
    private VaccineHistoryService VaccineHistoryService;

    @PostMapping
    public ResponseEntity<VaccineHistory> createVaccineHistory(@RequestBody VaccineHistory VaccineHistory) {
        VaccineHistoryService.put(VaccineHistory);

        return ResponseEntity.status(HttpStatus.CREATED).body(VaccineHistory);
    }

    @GetMapping
    public ResponseEntity<List<VaccineHistory>> getAllVaccineHistory() {
        List<VaccineHistory> surgeryHistories = VaccineHistoryService.getAll();

        return ResponseEntity.ok(surgeryHistories);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<VaccineHistory> getVaccineHistory(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        Optional<VaccineHistory> VaccineHistory = VaccineHistoryService.get(codeInt);

        return VaccineHistory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteVaccineHistory(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        VaccineHistoryService.delete(codeInt);
        return ResponseEntity.ok().build();
    }

}
