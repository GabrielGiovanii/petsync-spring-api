package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.Material;
import com.petsync_spring_api.petsync_spring_api.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public Material put(Material material) {return materialRepository.save(material);}

    public List<Material> getAll() {return materialRepository.findAll();}
    public Optional<Material> get(int id) {return materialRepository.findById(id);}
    public void delete(int id) {materialRepository.deleteById(id);}

}
