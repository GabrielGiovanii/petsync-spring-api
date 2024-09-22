package com.petsync_spring_api.petsync_spring_api.dtos;

import com.petsync_spring_api.petsync_spring_api.entities.User;

import java.util.HashSet;
import java.util.Set;

public class UserSaveDTO {

    private String cpf;
    private String name;
    private String email;
    private String password;
    private Integer roleCode;

    private final Set<Integer> phoneNumberCodes;

    private final Set<Integer> scheduleCodes;

    public UserSaveDTO() {
        this.phoneNumberCodes = new HashSet<>();
        this.scheduleCodes = new HashSet<>();
    }

    public UserSaveDTO(User entity) {
        this.cpf = entity.getCpf();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();

        if(entity.getRole() != null) {
            this.roleCode = entity.getRole().getCode();
        }

        this.phoneNumberCodes = new HashSet<>();
        this.scheduleCodes = new HashSet<>();

        entity.getSchedules().forEach(obj -> this.scheduleCodes.add(obj.getCode()));
        entity.getPhoneNumbers().forEach(obj -> this.phoneNumberCodes.add(obj.getCode()));
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Integer roleCode) {
        this.roleCode = roleCode;
    }

    public Set<Integer> getPhoneNumberCodes() {
        return phoneNumberCodes;
    }

    public Set<Integer> getScheduleCodes() {
        return scheduleCodes;
    }
}
