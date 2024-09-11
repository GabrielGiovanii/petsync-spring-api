package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.FurColor;
import com.petsync_spring_api.petsync_spring_api.services.FurColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pets/furcolor")
public class FurColorController {

    @Autowired
    private FurColorService furColorService;

    @PostMapping
    public ResponseEntity<FurColor> saveFurColor(@RequestBody FurColor furColor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(furColorService.put(furColor));
    }

    @GetMapping
    public ResponseEntity<List<FurColor>> getAllFurColors() {
        return ResponseEntity.ok(furColorService.getAll());
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<FurColor> getFurColor(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);
        return ResponseEntity.ok(furColorService.get(codeInt));
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<FurColor> deleteFurColor(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);
        furColorService.delete(codeInt);
        return ResponseEntity.ok().build();
    }

}
