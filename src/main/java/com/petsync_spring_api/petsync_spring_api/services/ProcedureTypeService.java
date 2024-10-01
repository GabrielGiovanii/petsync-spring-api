package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.ProcedureType;
import com.petsync_spring_api.petsync_spring_api.repositories.ProcedureTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcedureTypeService {

    @Autowired
    private ProcedureTypeRepository ProcedureTypeRepository;

    public ProcedureType put(ProcedureType ProcedureType) {return ProcedureTypeRepository.save(ProcedureType);}

    public List<ProcedureType> getAll() {return ProcedureTypeRepository.findAll();}
    public Optional<ProcedureType> get(int id) {return ProcedureTypeRepository.findById(id);}
    public void delete(int id) {ProcedureTypeRepository.deleteById(id);}

}
