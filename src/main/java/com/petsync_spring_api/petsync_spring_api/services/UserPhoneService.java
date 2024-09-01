package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.contracts.CRUDImplementation;
import com.petsync_spring_api.petsync_spring_api.entities.UserPhone;
import com.petsync_spring_api.petsync_spring_api.repositories.UserPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPhoneService implements CRUDImplementation<UserPhone, Integer> {

    @Autowired
    private UserPhoneRepository entityRepository;

    @Override
    public UserPhone insert(UserPhone entity) {
        return entityRepository.insert(entity);
    }

    @Override
    public UserPhone update(UserPhone entity) {
        return entityRepository.update(entity);
    }

    @Override
    public Integer deleteByCode(Integer code) {
        return entityRepository.deleteByCode(code);
    }

    @Override
    public UserPhone selectByCode(Integer code) {
        return entityRepository.selectByCode(code);
    }

    @Override
    public List<UserPhone> selectAll() {
        return entityRepository.selectAll();
    }
}
