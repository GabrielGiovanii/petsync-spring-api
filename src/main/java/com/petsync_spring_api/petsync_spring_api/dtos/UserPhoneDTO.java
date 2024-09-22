package com.petsync_spring_api.petsync_spring_api.dtos;

import com.petsync_spring_api.petsync_spring_api.entities.UserPhone;

public class UserPhoneDTO {

    private Integer code;
    private String number;
    private String userCpf;

    public UserPhoneDTO() {
    }

    public UserPhoneDTO(UserPhone entity) {
        this.code = entity.getCode();
        this.number = entity.getNumber();

        if(entity.getUser() != null) {
            this.userCpf = entity.getUser().getCpf();
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserCpf() {
        return userCpf;
    }

    public void setUserCpf(String userCpf) {
        this.userCpf = userCpf;
    }
}
