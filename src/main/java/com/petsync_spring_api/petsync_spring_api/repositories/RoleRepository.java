package com.petsync_spring_api.petsync_spring_api.repositories;

import com.petsync_spring_api.petsync_spring_api.contracts.CRUDImplementation;
import com.petsync_spring_api.petsync_spring_api.entities.Role;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Repository
public class RoleRepository implements CRUDImplementation<Role, Integer> {

    private final HashSet<Role> rolesRepositoryMock;

    public RoleRepository() {
        this.rolesRepositoryMock = new HashSet<>();

        Role r1 = new Role(1, "REPRESENTATIVE");
        Role r2 = new Role(2, "OWNER");
        Role r3 = new Role(3, "STOCKKEEPER");
        Role r4 = new Role(4, "ATTENDANT");

        rolesRepositoryMock.addAll(List.of(r1, r2, r3, r4));
    }

    @Override
    public Role insert(Role entity) {
        int nextCode = rolesRepositoryMock.stream()
                .mapToInt(Role::getCode)
                .max()
                .orElse(0);

        entity.setCode(++nextCode);
        rolesRepositoryMock.add(entity);

        return entity;
    }

    @Override
    public Role update(Role entity) {
        Role role = selectByCode(entity.getCode());

        if(role != null) {
            role.setCode(entity.getCode());
            role.setName(entity.getName());

            return role;
        } else {
            return  null;
        }
    }

    @Override
    public Integer deleteByCode(Integer code) {
        Role entity = selectByCode(code);

        int numberOfAffectedRows = 0;

        if(entity != null) {
            rolesRepositoryMock.remove(entity);

            numberOfAffectedRows++;
        }

        return numberOfAffectedRows;
    }

    @Override
    public Role selectByCode(Integer code) {
        return rolesRepositoryMock.stream()
                .filter(entity -> entity.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Role> selectAll() {
        return rolesRepositoryMock.stream().toList();
    }
}
