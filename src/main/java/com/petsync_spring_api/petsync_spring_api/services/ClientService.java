package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.entities.Client;
import com.petsync_spring_api.petsync_spring_api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client put(Client client){
        return clientRepository.save(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    public void deleteById(String id) {
        clientRepository.deleteById(id);
    }

}
