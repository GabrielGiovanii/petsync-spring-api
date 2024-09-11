package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.AnimalType;
import com.petsync_spring_api.petsync_spring_api.repositories.AnimalTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalTypeService {

    @Autowired
    private AnimalTypeRepository animalTypeRepository;

    public AnimalType put(AnimalType animalType) {
        return animalTypeRepository.save(animalType);
    }

    public List<AnimalType> findAll(){
        return animalTypeRepository.findAll();
    }

    public Optional<AnimalType> findById(int id) {
        return animalTypeRepository.findById(id);
    }

    public void deleteById(int id) {
        animalTypeRepository.deleteById(id);
    }

}
