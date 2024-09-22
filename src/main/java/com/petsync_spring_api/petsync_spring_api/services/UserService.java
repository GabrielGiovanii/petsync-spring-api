package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.dtos.UserSaveDTO;
import com.petsync_spring_api.petsync_spring_api.entities.Role;
import com.petsync_spring_api.petsync_spring_api.entities.User;
import com.petsync_spring_api.petsync_spring_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User put(User entity) {
        return userRepository.save(entity);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String cpf) {
        return userRepository.findById(cpf);
    }

    public void deleteById(String cpf) {
        userRepository.deleteById(cpf);
    }

    public User createEntity(UserSaveDTO dto) {
        User entity = new User();
        entity.setCpf(dto.getCpf());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());

        encryptPassword(entity);

        if (dto.getRoleCode() != null) {
            Role role = new Role();
            role.setCode(dto.getRoleCode());
            entity.setRole(role);
        }

        return entity;
    }

    public void encryptPassword(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
    }
}
