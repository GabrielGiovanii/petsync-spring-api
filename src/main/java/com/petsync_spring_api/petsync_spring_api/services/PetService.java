package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.Pet;
import com.petsync_spring_api.petsync_spring_api.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet putPet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(int id) {
        return petRepository.findById(id);
    }

    public void deletePetById(int id) {
        petRepository.deleteById(id);
    }

}
