package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.Status;
import com.petsync_spring_api.petsync_spring_api.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/status")
public class StatusController {

    @Autowired
    private StatusService entityService;

    @PostMapping
    public ResponseEntity<Status> createStatus(@RequestBody Status entityRequest) {
        Status entity = entityService.put(entityRequest);

        if(entity != null) {
            return ResponseEntity.status(HttpStatus.OK).body(entity);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Status>> getAllStatus() {
        List<Status> entities = entityService.findAll();

        if(!entities.isEmpty()) {
            return ResponseEntity.ok().body(entities);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<Status> getStatus(@PathVariable Integer code) {
        Optional<Status> entity = entityService.findById(code);

        return entity.map(role -> ResponseEntity
                        .ok().body(role))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Integer code) {
        entityService.deleteById(code);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
