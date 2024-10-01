package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.Material;
import com.petsync_spring_api.petsync_spring_api.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        materialService.put(material);

        return ResponseEntity.status(HttpStatus.CREATED).body(material);
    }

    @GetMapping
    public ResponseEntity<List<Material>> getAllMaterials() {
        List<Material> materials = materialService.getAll();

        return ResponseEntity.ok(materials);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<Material> getMaterial(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        Optional<Material> material = materialService.get(codeInt);

        return material.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        materialService.delete(codeInt);
        return ResponseEntity.ok().build();
    }

}
