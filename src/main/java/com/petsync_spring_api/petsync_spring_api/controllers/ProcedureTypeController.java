package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.ProcedureType;
import com.petsync_spring_api.petsync_spring_api.services.ProcedureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/procedures/types")
public class ProcedureTypeController {

    @Autowired
    private ProcedureTypeService ProcedureTypeService;

    @PostMapping
    public ResponseEntity<ProcedureType> createProcedureType(@RequestBody ProcedureType ProcedureType) {
        ProcedureTypeService.put(ProcedureType);

        return ResponseEntity.status(HttpStatus.CREATED).body(ProcedureType);
    }

    @GetMapping
    public ResponseEntity<List<ProcedureType>> getAllProcedureTypes() {
        List<ProcedureType> ProcedureTypes = ProcedureTypeService.getAll();

        return ResponseEntity.ok(ProcedureTypes);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<ProcedureType> getProcedureType(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        Optional<ProcedureType> ProcedureType = ProcedureTypeService.get(codeInt);

        return ProcedureType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteProcedureType(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        ProcedureTypeService.delete(codeInt);
        return ResponseEntity.ok().build();
    }

}
