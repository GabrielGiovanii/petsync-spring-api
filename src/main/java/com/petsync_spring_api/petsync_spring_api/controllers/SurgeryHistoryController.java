package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.SurgeryHistory;
import com.petsync_spring_api.petsync_spring_api.services.SurgeryHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "surgery_history")
public class SurgeryHistoryController {

    @Autowired
    private SurgeryHistoryService SurgeryHistoryService;

    @PostMapping
    public ResponseEntity<SurgeryHistory> createSurgeryHistory(@RequestBody SurgeryHistory surgeryHistory) {
        SurgeryHistoryService.put(surgeryHistory);

        return ResponseEntity.status(HttpStatus.CREATED).body(surgeryHistory);
    }

    @GetMapping
    public ResponseEntity<List<SurgeryHistory>> getAllSurgeryHistory() {
        List<SurgeryHistory> surgeryHistories = SurgeryHistoryService.getAll();

        return ResponseEntity.ok(surgeryHistories);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<SurgeryHistory> getSurgeryHistory(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        Optional<SurgeryHistory> surgeryHistory = SurgeryHistoryService.get(codeInt);

        return surgeryHistory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteSurgeryHistory(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        SurgeryHistoryService.delete(codeInt);
        return ResponseEntity.ok().build();
    }

}
