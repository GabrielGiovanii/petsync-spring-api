package com.petsync_spring_api.petsync_spring_api.dtos;

import com.petsync_spring_api.petsync_spring_api.entities.User;

import java.util.HashSet;
import java.util.Set;

public class UserResponseDTO {

    private String cpf;
    private String name;
    private String email;
    private Integer roleCode;

    private final Set<UserPhoneDTO> phoneNumbers;

    private final Set<Integer> scheduleCodes;

    public UserResponseDTO() {
        this.phoneNumbers = new HashSet<>();
        this.scheduleCodes = new HashSet<>();
    }

    public UserResponseDTO(User entity) {
        this.cpf = entity.getCpf();
        this.name = entity.getName();
        this.email = entity.getEmail();

        if(entity.getRole() != null) {
            this.roleCode = entity.getRole().getCode();
        }

        this.phoneNumbers = new HashSet<>();
        this.scheduleCodes = new HashSet<>();

        this.phoneNumbers.addAll(entity.getPhoneNumbers().stream().map(UserPhoneDTO::new).toList());
        entity.getSchedules().forEach(obj -> scheduleCodes.add(obj.getCode()));
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

    public Integer getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Integer roleCode) {
        this.roleCode = roleCode;
    }

    public Set<UserPhoneDTO> getPhoneNumbers() {
        return phoneNumbers;
    }

    public Set<Integer> getScheduleCodes() {
        return scheduleCodes;
    }
}
