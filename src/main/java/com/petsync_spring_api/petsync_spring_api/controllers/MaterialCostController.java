package com.petsync_spring_api.petsync_spring_api.controllers;

import com.petsync_spring_api.petsync_spring_api.entities.MaterialCost;
import com.petsync_spring_api.petsync_spring_api.services.MaterialCostService;
import com.petsync_spring_api.petsync_spring_api.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@RestController()
@RequestMapping(value = "/materials/cost")
public class MaterialCostController {

    @Autowired
    MaterialService materialService;
    @Autowired
    private MaterialCostService materialCostService;

    @PostMapping
    public ResponseEntity<MaterialCost> createMaterialCost(@RequestBody final MaterialCost materialCost) {
        materialCostService.put(materialCost);

        return  ResponseEntity.status(HttpStatus.CREATED).body(materialCost);
    }

    @GetMapping
    public ResponseEntity<List<MaterialCost>> getAllMaterialCosts() {
        List<MaterialCost> materialCosts = materialCostService.getAll();

        return  ResponseEntity.ok(materialCosts);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<MaterialCost> getMaterialCost(@PathVariable String code) {
        int intCode = Integer.parseInt(code);

        Optional<MaterialCost> materialCost = materialCostService.get(intCode);

        return materialCost.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteMaterialCost(@PathVariable String code) {
        int intCode = Integer.parseInt(code);

        materialCostService.delete(intCode);

        return ResponseEntity.ok().build();
    }
}
