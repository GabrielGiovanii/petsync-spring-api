package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.Procedure;
import com.petsync_spring_api.petsync_spring_api.repositories.ProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcedureService {

    @Autowired
    private ProcedureRepository ProcedureRepository;

    public Procedure put(Procedure Procedure) {return ProcedureRepository.save(Procedure);}

    public List<Procedure> getAll() {return ProcedureRepository.findAll();}
    public Optional<Procedure> get(int id) {return ProcedureRepository.findById(id);}
    public void delete(int id) {ProcedureRepository.deleteById(id);}

}
