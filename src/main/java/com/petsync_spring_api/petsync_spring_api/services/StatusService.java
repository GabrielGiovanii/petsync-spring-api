package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.dtos.StatusDTO;
import com.petsync_spring_api.petsync_spring_api.entities.Status;
import com.petsync_spring_api.petsync_spring_api.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public Status put(Status entity) {
        return statusRepository.save(entity);
    }

    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    public Optional<Status> findById(Integer id) {
        return statusRepository.findById(id);
    }

    public void deleteById(Integer id) {
        statusRepository.deleteById(id);
    }

    public Status createEntity(StatusDTO dto) {
        Status entity = new Status();
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());

        return entity;
    }
}
