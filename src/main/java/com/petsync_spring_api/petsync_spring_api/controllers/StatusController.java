package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.Status;
import com.petsync_spring_api.petsync_spring_api.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/status")
public class StatusController {

    @Autowired
    private StatusService StatusService;

    @PostMapping
    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
        StatusService.put(status);

        return ResponseEntity.status(HttpStatus.CREATED).body(status);
    }

    @GetMapping
    public ResponseEntity<List<Status>> getAllStatus() {
        List<Status> Status = StatusService.getAll();

        return ResponseEntity.ok(Status);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<Status> getStatus(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        Optional<Status> Status = StatusService.get(codeInt);

        return Status.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteStatus(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        StatusService.delete(codeInt);
        return ResponseEntity.ok().build();
    }

}
