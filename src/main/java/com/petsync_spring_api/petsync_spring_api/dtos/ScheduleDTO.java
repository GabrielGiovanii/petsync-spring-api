package com.petsync_spring_api.petsync_spring_api.dtos;

import com.petsync_spring_api.petsync_spring_api.entities.Schedule;

import java.util.Date;

public class ScheduleDTO {

    private Integer code;
    private String description;
    private Date date;
    private Integer status;

    private String userCpf;

    private Integer petCode;

    public ScheduleDTO() {
    }

    public ScheduleDTO(Schedule entity) {
        this.code = entity.getCode();
        this.description = entity.getDescription();
        this.date = entity.getDate();
        this.status = entity.getStatus();

        if (entity.getUser() != null) {
            this.userCpf = entity.getUser().getCpf();
        }

        if(entity.getPet() != null) {
            this.petCode = entity.getPet().getCode();
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserCpf() {
        return userCpf;
    }

    public void setUserCpf(String userCpf) {
        this.userCpf = userCpf;
    }

    public Integer getPetCode() {
        return petCode;
    }

    public void setPetCode(Integer petCode) {
        this.petCode = petCode;
    }
}
