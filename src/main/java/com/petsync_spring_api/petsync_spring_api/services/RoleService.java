package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.contracts.CRUDImplementation;
import com.petsync_spring_api.petsync_spring_api.entities.Role;
import com.petsync_spring_api.petsync_spring_api.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements CRUDImplementation<Role, Integer> {

    @Autowired
    private RoleRepository entityRepository;

    @Override
    public Role insert(Role entity) {
        return entityRepository.insert(entity);
    }

    @Override
    public Role update(Role entity) {
        return entityRepository.update(entity);
    }

    @Override
    public Integer deleteByCode(Integer code) {
        return entityRepository.deleteByCode(code);
    }

    @Override
    public Role selectByCode(Integer code) {
        return entityRepository.selectByCode(code);
    }

    @Override
    public List<Role> selectAll() {
        return entityRepository.selectAll();
    }
}
