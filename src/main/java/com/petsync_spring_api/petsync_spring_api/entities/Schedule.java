package com.petsync_spring_api.petsync_spring_api.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private String description;
    private Date date;
    private int status;
    @OneToOne
    @JoinColumn(name = "user_cpf", referencedColumnName = "cpf")
    private User user;
    @OneToOne
    @JoinColumn(name = "pet_code", referencedColumnName = "code")
    private Pet pet;

    public Schedule() {
    }

    public Schedule(int code, String description, Date date, int status, User user, Pet pet) {
        this.code = code;
        this.description = description;
        this.date = date;
        this.status = status;
        this.user = user;
        this.pet = pet;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
