package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.ClientPhone;
import com.petsync_spring_api.petsync_spring_api.repositories.ClientPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientPhoneService {

    @Autowired
    private ClientPhoneRepository entityRepository;

    public ClientPhone put(ClientPhone entity) {
        return entityRepository.save(entity);
    }

    public List<ClientPhone> findAll() {
        return entityRepository.findAll();
    }

    public Optional<ClientPhone> findById(int id) {
        return entityRepository.findById(id);
    }

    public void deleteById(int id) {
        entityRepository.deleteById(id);
    }

}
