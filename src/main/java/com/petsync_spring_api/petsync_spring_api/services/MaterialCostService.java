package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.MaterialCost;
import com.petsync_spring_api.petsync_spring_api.repositories.MaterialCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialCostService {

    @Autowired
    MaterialCostRepository materialCostRepository;

    public MaterialCost put(MaterialCost materialCost) {
        return materialCostRepository.save(materialCost);
    }

    public Optional<MaterialCost> get(int id) {
        return materialCostRepository.findById(id);
    }

    public List<MaterialCost> getAll() {
        return materialCostRepository.findAll();
    }

    public void delete(int id) {
        materialCostRepository.deleteById(id);
    }
}
