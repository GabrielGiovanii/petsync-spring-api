package com.petsync_spring_api.petsync_spring_api.services;

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
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        User returnEntity = userRepository.save(entity);

        Optional<Role> role = roleService.findById(entity.getRole().getCode());
        returnEntity.setRole(role.orElseThrow());

        return returnEntity;
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
}
