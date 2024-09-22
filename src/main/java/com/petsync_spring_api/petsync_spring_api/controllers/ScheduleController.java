package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.dtos.ScheduleDTO;
import com.petsync_spring_api.petsync_spring_api.entities.Schedule;
import com.petsync_spring_api.petsync_spring_api.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @PostMapping
    public ResponseEntity<ScheduleDTO> createEntity(@RequestBody ScheduleDTO dto) {

        Schedule entity = service.put(service.createEntity(dto));

        if(entity != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ScheduleDTO(entity));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ScheduleDTO>> getAllEntities() {
        List<Schedule> entities = service.findAll();

        if(!entities.isEmpty()) {
            return ResponseEntity.ok().body(entities.stream().map(ScheduleDTO::new).toList());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<ScheduleDTO> getEntity(@PathVariable Integer code) {
        Optional<Schedule> entity = service.findById(code);

        return entity.map(obj -> ResponseEntity
                        .ok().body(new ScheduleDTO(obj)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Integer code) {
        service.deleteById(code);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
