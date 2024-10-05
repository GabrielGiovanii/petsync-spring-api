package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.MaterialType;
import com.petsync_spring_api.petsync_spring_api.services.MaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/material/types")
public class MaterialTypeController {

    @Autowired
    private MaterialTypeService materialTypeService;

    @PostMapping
    public ResponseEntity<MaterialType> createMaterialType(@RequestBody MaterialType materialType) {
        materialTypeService.put(materialType);

        return ResponseEntity.status(HttpStatus.CREATED).body(materialType);
    }

    @GetMapping
    public ResponseEntity<List<MaterialType>> getAllMaterialTypes() {
        List<MaterialType> materialTypes = materialTypeService.getAll();

        return ResponseEntity.ok(materialTypes);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<MaterialType> getMaterialType(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        Optional<MaterialType> materialType = materialTypeService.get(codeInt);

        return materialType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteMaterialType(@PathVariable String code) {
        int codeInt = Integer.parseInt(code);

        materialTypeService.delete(codeInt);
        return ResponseEntity.ok().build();
    }

}
