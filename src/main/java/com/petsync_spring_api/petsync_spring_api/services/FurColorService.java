package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.FurColor;
import com.petsync_spring_api.petsync_spring_api.repositories.FurColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FurColorService {

    @Autowired
    private FurColorRepository furColorRepository;

    public FurColor put(FurColor furColor) {
        return furColorRepository.save(furColor);
    }

    public List<FurColor> getAll() {
        return furColorRepository.findAll();
    }
    public Optional<FurColor> get(int id) {
        return furColorRepository.findById(id);
    }
    public void delete(int id) {
        furColorRepository.deleteById(id);
    }

}
