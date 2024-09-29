package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.dtos.ProcedureTypeDTO;
import com.petsync_spring_api.petsync_spring_api.entities.ProcedureType;
import com.petsync_spring_api.petsync_spring_api.repositories.ProcedureTypeRepository;
import com.petsync_spring_api.petsync_spring_api.repositories.ProcedureTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcedureTypeService {

    @Autowired
    private ProcedureTypeRepository repository;

    public ProcedureType put(ProcedureType entity) {
        return repository.save(entity);
    }

    public List<ProcedureType> findAll() {
        return repository.findAll();
    }

    public Optional<ProcedureType> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public ProcedureType createEntity(ProcedureTypeDTO dto) {
        ProcedureType entity = new ProcedureType();
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());

        return entity;
    }
}
