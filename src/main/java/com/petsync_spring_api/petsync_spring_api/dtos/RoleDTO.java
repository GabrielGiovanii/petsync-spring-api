package com.petsync_spring_api.petsync_spring_api.dtos;

import com.petsync_spring_api.petsync_spring_api.entities.Role;

public class RoleDTO {

    private Integer code;
    private String name;

    public RoleDTO() {
    }

    public RoleDTO(Role entity) {
        this.code = entity.getCode();
        this.name = entity.getName();
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
}
