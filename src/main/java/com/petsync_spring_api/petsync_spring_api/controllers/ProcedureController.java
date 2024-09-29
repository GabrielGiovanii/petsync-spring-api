package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.dtos.ProcedureDTO;
import com.petsync_spring_api.petsync_spring_api.entities.Procedure;
import com.petsync_spring_api.petsync_spring_api.services.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/procedures")
public class ProcedureController {

    @Autowired
    private ProcedureService service;

    @PostMapping
    public ResponseEntity<ProcedureDTO> createEntity(@RequestBody ProcedureDTO dto) {
        if(dto.getVeterinarianCpf() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Procedure entity = service.put(service.createEntity(dto));

        if(entity != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ProcedureDTO(entity));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ProcedureDTO>> getAllEntities() {
        List<Procedure> entities = service.findAll();

        if(!entities.isEmpty()) {
            return ResponseEntity.ok().body(entities.stream().map(ProcedureDTO::new).toList());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<ProcedureDTO> getEntity(@PathVariable Integer code) {
        Optional<Procedure> entity = service.findById(code);

        return entity.map(obj -> ResponseEntity
                        .ok().body(new ProcedureDTO(obj)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Integer code) {
        service.deleteById(code);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
