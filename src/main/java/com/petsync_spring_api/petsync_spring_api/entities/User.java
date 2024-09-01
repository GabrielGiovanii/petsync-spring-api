package com.petsync_spring_api.petsync_spring_api.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

    private String cpf;
    private String name;
    private String email;
    private String password;

    private Role role;

    private final Set<UserPhone> phoneNumbers;

    public User() {
        this.phoneNumbers = new HashSet<>();
    }

    public User(String cpf, String name, String email, String password, Role role) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phoneNumbers = new HashSet<>();
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<UserPhone> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        User user = (User) object;
        return Objects.equals(cpf, user.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
