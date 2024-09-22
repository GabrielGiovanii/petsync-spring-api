package com.petsync_spring_api.petsync_spring_api.dtos;

import com.petsync_spring_api.petsync_spring_api.entities.Status;

public class StatusDTO {

    private Integer code;
    private String name;

    public StatusDTO() {
    }

    public StatusDTO(Status entity) {
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
