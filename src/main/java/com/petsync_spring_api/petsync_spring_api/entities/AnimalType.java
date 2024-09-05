package com.petsync_spring_api.petsync_spring_api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_animaltype")
public class AnimalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private String name;

    public AnimalType() {
    }

    public AnimalType(int code, String name) {
        this.code = code;
        this.name = name;
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
