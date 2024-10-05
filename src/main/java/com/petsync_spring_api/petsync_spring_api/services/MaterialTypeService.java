package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.MaterialType;
import com.petsync_spring_api.petsync_spring_api.repositories.MaterialTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialTypeService {

    @Autowired
    private MaterialTypeRepository materialTypeRepository;

    public MaterialType put(MaterialType materialType) {return materialTypeRepository.save(materialType);}

    public List<MaterialType> getAll() {return materialTypeRepository.findAll();}
    public Optional<MaterialType> get(int id) {return materialTypeRepository.findById(id);}
    public void delete(int id) {materialTypeRepository.deleteById(id);}

}
