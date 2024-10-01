package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.Procedure;
import com.petsync_spring_api.petsync_spring_api.services.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/procedures")
public class ProcedureController {

    @Autowired
    private ProcedureService ProcedureService;

    @PostMapping
    public ResponseEntity<Procedure> createProcedure(@RequestBody Procedure Procedure) {
        ProcedureService.put(Procedure);

        return ResponseEntity.status(HttpStatus.CREATED).body(Procedure);
    }

    @GetMapping
    public ResponseEntity<List<Procedure>> getAllProcedures() {
        List<Procedure> Procedures = ProcedureService.getAll();

        return ResponseEntity.ok(Procedures);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<Procedure> getProcedure(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        Optional<Procedure> Procedure = ProcedureService.get(codeInt);

        return Procedure.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteProcedure(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        ProcedureService.delete(codeInt);
        return ResponseEntity.ok().build();
    }

}
