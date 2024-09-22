package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.dtos.UserPhoneDTO;
import com.petsync_spring_api.petsync_spring_api.entities.User;
import com.petsync_spring_api.petsync_spring_api.entities.UserPhone;
import com.petsync_spring_api.petsync_spring_api.repositories.UserPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPhoneService {

    @Autowired
    private UserPhoneRepository userPhoneRepository;

    public UserPhone put(UserPhone entity) {
        return userPhoneRepository.save(entity);
    }

    public List<UserPhone> findAll() {
        return userPhoneRepository.findAll();
    }

    public Optional<UserPhone> findById(Integer id) {
        return userPhoneRepository.findById(id);
    }

    public void deleteById(Integer id) {
        userPhoneRepository.deleteById(id);
    }

    public UserPhone createEntity(UserPhoneDTO dto) {
        UserPhone entity = new UserPhone();
        entity.setCode(dto.getCode());
        entity.setNumber(dto.getNumber());

        if(dto.getUserCpf() != null) {
            User user = new User();
            user.setCpf(dto.getUserCpf());
            entity.setUser(user);
            user.getPhoneNumbers().add(entity);
        }

        return entity;
    }
}
