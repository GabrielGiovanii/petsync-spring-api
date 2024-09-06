package com.petsync_spring_api.petsync_spring_api.services;

import com.petsync_spring_api.petsync_spring_api.contracts.CRUDImplementation;
import com.petsync_spring_api.petsync_spring_api.entities.Role;
import com.petsync_spring_api.petsync_spring_api.entities.User;
import com.petsync_spring_api.petsync_spring_api.entities.UserPhone;
import com.petsync_spring_api.petsync_spring_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements CRUDImplementation<User, String> {

    @Autowired
    private UserRepository entityRepository;

    @Autowired
    private UserPhoneService userPhoneService;

    @Autowired
    private RoleService roleService;

    @Override
    public User insert(User entity) {
        entity.getPhoneNumbers().forEach(obj -> {
            obj.setUser(entity);

            userPhoneService.insert(obj);
        });

        Role role = roleService.selectByCode(entity.getRole().getCode());
        entity.setRole(role);

        return entityRepository.insert(entity);
    }

    @Override
    public User update(User entity) {
        List<UserPhone> entityNumbers = entity.getPhoneNumbers().stream().toList();

        entityNumbers.forEach(obj -> {
            if(obj.getCode() != null) {
                userPhoneService.update(obj);
            } else if(obj.getNumber() != null) {
                userPhoneService.insert(obj);
            }

            obj.setUser(entity);
        });

        List<Integer> inputPhoneNumberCodes = entityNumbers.stream()
                .map(UserPhone::getCode)
                .toList();

        List<Integer> repositoryPhoneNumberCodes = userPhoneService.selectAll().stream()
                .filter(obj -> obj.getUser().equals(entity))
                .map(UserPhone::getCode)
                .toList();

        repositoryPhoneNumberCodes.forEach(obj -> {
            if(!inputPhoneNumberCodes.contains(obj)) {
                userPhoneService.deleteByCode(obj);
            }
        });

        Role role = roleService.selectByCode(entity.getRole().getCode());
        entity.setRole(role);

        return entityRepository.update(entity);
    }

    @Override
    public Integer deleteByCode(String cpf) {
        return entityRepository.deleteByCode(cpf);
    }

    @Override
    public User selectByCode(String cpf) {
        return entityRepository.selectByCode(cpf);
    }

    @Override
    public List<User> selectAll() {
        return entityRepository.selectAll();
    }
}
