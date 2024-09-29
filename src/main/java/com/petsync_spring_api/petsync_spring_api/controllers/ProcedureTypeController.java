package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.dtos.ProcedureTypeDTO;
import com.petsync_spring_api.petsync_spring_api.entities.ProcedureType;
import com.petsync_spring_api.petsync_spring_api.services.ProcedureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/procedureTypes")
public class ProcedureTypeController {

    @Autowired
    private ProcedureTypeService service;

    @PostMapping
    public ResponseEntity<ProcedureTypeDTO> createEntity(@RequestBody ProcedureTypeDTO dto) {

        ProcedureType entity = service.put(service.createEntity(dto));

        if(entity != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ProcedureTypeDTO(entity));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ProcedureTypeDTO>> getAllEntities() {
        List<ProcedureType> entities = service.findAll();

        if(!entities.isEmpty()) {
            return ResponseEntity.ok().body(entities.stream().map(ProcedureTypeDTO::new).toList());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<ProcedureTypeDTO> getEntity(@PathVariable Integer code) {
        Optional<ProcedureType> entity = service.findById(code);

        return entity.map(obj -> ResponseEntity
                        .ok().body(new ProcedureTypeDTO(obj)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Integer code) {
        service.deleteById(code);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
