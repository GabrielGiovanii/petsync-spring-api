package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.Pet;
import com.petsync_spring_api.petsync_spring_api.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<Pet> criarPet(@RequestBody Pet pet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pet);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> listarPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<Pet> getPet(@PathVariable String code) {
        Optional<Pet> pet = petService.getPetById(Integer.parseInt(code));

        return pet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Pet> deletarPet(@PathVariable String code) {
        petService.deletePetById(Integer.parseInt(code));
        return ResponseEntity.ok().build();
    }
}
