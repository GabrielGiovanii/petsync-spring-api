package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.dtos.ProcedureDTO;
import com.petsync_spring_api.petsync_spring_api.entities.*;
import com.petsync_spring_api.petsync_spring_api.repositories.ProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcedureService {

    @Autowired
    private ProcedureRepository repository;

    @Autowired
    private StatusService statusService;

    public Procedure put(Procedure entity) {
        return repository.save(entity);
    }

    public List<Procedure> findAll() {
        return repository.findAll();
    }

    public Optional<Procedure> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Procedure createEntity(ProcedureDTO dto) {
        Procedure entity = new Procedure();
        entity.setCode(dto.getCode());
        entity.setCost(dto.getCost());
        entity.setPrescription(dto.getPrescription());

        if(dto.getStatusCode() != null) {
            Status status = new Status();
            status.setCode(dto.getStatusCode());
            entity.setStatus(status);
        }

        if(dto.getCode() != null) {
            Optional<Procedure> scheduleBD;
            scheduleBD = repository.findById(dto.getCode());

            if (scheduleBD.isPresent()) {
                User user = scheduleBD.get().getUser();
                entity.setDate(scheduleBD.get().getDate());
                entity.setUser(user);

                user.getProcedures().add(entity);
            }
        } else {
            User user = new User();
            user.setCpf(dto.getVeterinarianCpf());
            entity.setUser(user);

            user.getProcedures().add(entity);
        }

        if(dto.getProcedureTypeCode() != null) {
            ProcedureType procedureType = new ProcedureType();
            procedureType.setCode(dto.getProcedureTypeCode());
            entity.setProcedureType(procedureType);
        }

        if(dto.getScheduleCode() != null) {
            Schedule schedule = new Schedule();
            schedule.setCode(dto.getScheduleCode());
            entity.setSchedule(schedule);
        }

        return entity;
    }
}
