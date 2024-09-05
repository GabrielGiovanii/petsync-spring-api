package com.petsync_spring_api.petsync_spring_api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_clientphone")
public class ClientPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private String phone;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
