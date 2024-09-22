package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.dtos.StatusDTO;
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
    private StatusService service;

    @PostMapping
    public ResponseEntity<StatusDTO> createEntity(@RequestBody StatusDTO dto) {

        Status entity = service.put(service.createEntity(dto));

        if(entity != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new StatusDTO(entity));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<StatusDTO>> getAllEntities() {
        List<Status> entities = service.findAll();

        if(!entities.isEmpty()) {
            return ResponseEntity.ok().body(entities.stream().map(StatusDTO::new).toList());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<StatusDTO> getEntity(@PathVariable Integer code) {
        Optional<Status> entity = service.findById(code);

        return entity.map(obj -> ResponseEntity
                        .ok().body(new StatusDTO(obj)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Integer code) {
        service.deleteById(code);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
