package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.Status;
import com.petsync_spring_api.petsync_spring_api.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository StatusRepository;

    public Status put(Status Status) {return StatusRepository.save(Status);}

    public List<Status> getAll() {return StatusRepository.findAll();}
    public Optional<Status> get(int id) {return StatusRepository.findById(id);}
    public void delete(int id) {StatusRepository.deleteById(id);}

}
