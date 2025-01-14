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
    @ManyToOne
    @JoinColumn(name = "status_code", referencedColumnName = "code")
    private Status status;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_cpf", referencedColumnName = "cpf")
    private User user;
    @ManyToOne
    @JoinColumn(name = "pet_code", referencedColumnName = "code")
    private Pet pet;
    @OneToOne(mappedBy = "schedule")
    private Procedure procedure;

    public Schedule() {
        this.date = new Date();
    }

    public Schedule(int code, String description, Status status, User user, Pet pet, Procedure procedure) {
        this.code = code;
        this.description = description;
        this.date = new Date();
        this.status = status;
        this.user = user;
        this.pet = pet;
        this.procedure = procedure;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }
}
