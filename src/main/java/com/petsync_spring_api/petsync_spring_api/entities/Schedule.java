package com.petsync_spring_api.petsync_spring_api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    private String description;
    private Date date;
    private Integer status;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_cpf", referencedColumnName = "cpf")
    private User user;
    @OneToOne
    @JoinColumn(name = "pet_code", referencedColumnName = "code")
    private Pet pet;

    public Schedule() {
        this.date = new Date();
    }

    public Schedule(int code, String description, Integer status, User user, Pet pet) {
        this.code = code;
        this.description = description;
        this.date = new Date();
        this.status = status;
        this.user = user;
        this.pet = pet;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
