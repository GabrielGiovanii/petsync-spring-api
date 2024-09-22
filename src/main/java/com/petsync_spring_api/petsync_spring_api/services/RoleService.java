package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.dtos.RoleDTO;
import com.petsync_spring_api.petsync_spring_api.entities.Role;
import com.petsync_spring_api.petsync_spring_api.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role put(Role entity) {
        return roleRepository.save(entity);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }

    public void deleteById(Integer id) {
        roleRepository.deleteById(id);
    }

    public Role createEntity(RoleDTO dto) {
        Role entity = new Role();
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());

        return entity;
    }
}
