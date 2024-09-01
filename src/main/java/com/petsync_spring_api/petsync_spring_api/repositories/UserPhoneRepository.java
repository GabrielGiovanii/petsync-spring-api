package com.petsync_spring_api.petsync_spring_api.repositories;

import com.petsync_spring_api.petsync_spring_api.contracts.CRUDImplementation;
import com.petsync_spring_api.petsync_spring_api.entities.UserPhone;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Repository
public class UserPhoneRepository implements CRUDImplementation<UserPhone, Integer> {

    private final HashSet<UserPhone> userPhonesRepositoryMock;

    public UserPhoneRepository() {
        this.userPhonesRepositoryMock = new HashSet<>();
    }

    @Override
    public UserPhone insert(UserPhone entity) {
        int nextCode = userPhonesRepositoryMock.stream()
                .mapToInt(UserPhone::getCode)
                .max()
                .orElse(0);

        entity.setCode(++nextCode);
        userPhonesRepositoryMock.add(entity);

        return entity;
    }

    @Override
    public UserPhone update(UserPhone entity) {
        UserPhone userPhone = selectByCode(entity.getCode());

        if(userPhone != null) {
            userPhone.setNumber(entity.getNumber());

            return userPhone;
        } else {
            return  null;
        }
    }

    @Override
    public Integer deleteByCode(Integer code) {
        UserPhone entity = selectByCode(code);

        int numberOfAffectedRows = 0;

        if(entity != null) {
            userPhonesRepositoryMock.remove(entity);

            numberOfAffectedRows++;
        }

        return numberOfAffectedRows;
    }

    @Override
    public UserPhone selectByCode(Integer code) {
        return userPhonesRepositoryMock.stream()
                .filter(entity -> entity.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<UserPhone> selectAll() {
        return userPhonesRepositoryMock.stream().toList();
    }
}
