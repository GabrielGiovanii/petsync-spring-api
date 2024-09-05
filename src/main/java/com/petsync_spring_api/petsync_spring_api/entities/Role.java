package com.petsync_spring_api.petsync_spring_api.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    private String name;

    public Role() {
    }

    public Role(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Role role = (Role) object;
        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
