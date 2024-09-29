package com.petsync_spring_api.petsync_spring_api.dtos;

import com.petsync_spring_api.petsync_spring_api.entities.ProcedureType;

public class ProcedureTypeDTO {

    private int code;
    private String name;

    public ProcedureTypeDTO() {
    }

    public ProcedureTypeDTO(ProcedureType dto) {
        this.code = dto.getCode();
        this.name = dto.getName();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
