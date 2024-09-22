package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.dtos.ScheduleDTO;
import com.petsync_spring_api.petsync_spring_api.entities.Pet;
import com.petsync_spring_api.petsync_spring_api.entities.Schedule;
import com.petsync_spring_api.petsync_spring_api.entities.User;
import com.petsync_spring_api.petsync_spring_api.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    public Schedule put(Schedule entity) {
        return repository.save(entity);
    }

    public List<Schedule> findAll() {
        return repository.findAll();
    }

    public Optional<Schedule> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Schedule createEntity(ScheduleDTO dto) {
        Schedule entity = new Schedule();
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());

        if(dto.getPetCode() != null) {
            Pet pet = new Pet();
            pet.setCode(dto.getPetCode());
            entity.setPet(pet);
        }

        if(dto.getCode() != null) {
            Optional<Schedule> scheduleBD;
            scheduleBD = repository.findById(dto.getCode());

            if (scheduleBD.isPresent()) {
                entity.setDate(scheduleBD.get().getDate());
                entity.setUser(scheduleBD.get().getUser());

            }
        } else {
            User user = new User();
            user.setCpf(dto.getUserCpf());
            entity.setUser(user);
        }

        return entity;
    }
}
