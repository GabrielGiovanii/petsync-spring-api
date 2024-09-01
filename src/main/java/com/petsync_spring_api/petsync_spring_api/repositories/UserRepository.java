package com.petsync_spring_api.petsync_spring_api.repositories;

import com.petsync_spring_api.petsync_spring_api.contracts.CRUDImplementation;
import com.petsync_spring_api.petsync_spring_api.entities.User;
import com.petsync_spring_api.petsync_spring_api.entities.UserPhone;
import com.petsync_spring_api.petsync_spring_api.services.UserPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Repository
public class UserRepository implements CRUDImplementation<User, String> {

    @Autowired
    private UserPhoneService userPhoneService;

    private final HashSet<User> usersRepositoryMock;

    public UserRepository() {
        this.usersRepositoryMock = new HashSet<>();
    }

    @Override
    public User insert(User entity) {
        usersRepositoryMock.add(entity);

        return entity;
    }

    @Override
    public User update(User entity) {
        User user = selectByCode(entity.getCpf());

        if(user != null) {
            user.setName(entity.getName());
            user.setEmail(entity.getEmail());
            user.setPassword(entity.getPassword());
            user.setRole(entity.getRole());
            user.getPhoneNumbers().clear();

            List<UserPhone> userPhones = userPhoneService.selectAll().stream()
                    .filter(obj -> obj.getUser().equals(entity)).toList();

            userPhones.forEach(obj -> user.getPhoneNumbers().add(obj));

            return user;
        } else {
            return  null;
        }
    }

    @Override
    public Integer deleteByCode(String cpf) {
        User entity = selectByCode(cpf);

        int numberOfAffectedRows = 0;

        if(entity != null) {
            usersRepositoryMock.remove(entity);

            numberOfAffectedRows++;
        }

        return numberOfAffectedRows;
    }

    @Override
    public User selectByCode(String cpf) {
        return usersRepositoryMock.stream()
                .filter(entity -> entity.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> selectAll() {
        return usersRepositoryMock.stream().toList();
    }
}
