package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.AnimalType;
import com.petsync_spring_api.petsync_spring_api.services.AnimalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/animals/types")
public class AnimalTypeController {

    @Autowired
    private AnimalTypeService animalTypeService;

    @PostMapping
    public ResponseEntity<AnimalType> createAnimalType(@RequestBody AnimalType animalType) {
        animalTypeService.put(animalType);
        return ResponseEntity.status(HttpStatus.CREATED).body(animalType);
    }

    @GetMapping
    public ResponseEntity<List<AnimalType>> getAllAnimalTypes() {
        return ResponseEntity.ok(animalTypeService.findAll());
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<AnimalType> getAnimalTypeByCode(@PathVariable String code) {
        int id = Integer.parseInt(code);
        Optional<AnimalType> animalType = animalTypeService.findById(id);
        return animalType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteAnimalTypeByCode(@PathVariable String code) {
        int id = Integer.parseInt(code);
        animalTypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
