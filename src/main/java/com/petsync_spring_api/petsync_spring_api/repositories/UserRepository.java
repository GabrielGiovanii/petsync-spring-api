package com.petsync_spring_api.petsync_spring_api.repositories;

import com.petsync_spring_api.petsync_spring_api.contracts.CRUDImplementation;
import com.petsync_spring_api.petsync_spring_api.entities.User;
import com.petsync_spring_api.petsync_spring_api.entities.UserPhone;
import com.petsync_spring_api.petsync_spring_api.services.RoleService;
import com.petsync_spring_api.petsync_spring_api.services.UserPhoneService;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Repository
public class UserRepository implements CRUDImplementation<User, String> {

    private final UserPhoneService userPhoneService;

    private final HashSet<User> usersRepositoryMock;

    public UserRepository(UserPhoneService userPhoneService, RoleService roleService) {
        this.userPhoneService = userPhoneService;
        this.usersRepositoryMock = new HashSet<>();

        UserPhone up1 = new UserPhone();
        up1.setCode(1);
        up1.setNumber("18558421754");

        UserPhone up2 = new UserPhone();
        up2.setCode(2);
        up2.setNumber("18997281458");

        User u1 = new User();
        u1.setCpf("12354214251");
        u1.setName("Developer");
        u1.setEmail("developer@gmail.com");
        u1.setPassword("$2a$10$IUq9savDOCV8ETjIfKmUH.FeWAw6BmS03hVi1P2lEcJdSns84Lm4W");
        u1.setRole(roleService.selectByCode(1));
        u1.getPhoneNumbers().add(up1);
        u1.getPhoneNumbers().add(up2);

        up1.setUser(u1);
        up2.setUser(u1);

        usersRepositoryMock.add(u1);
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
