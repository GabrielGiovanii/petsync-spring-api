package com.petsync_spring_api.petsync_spring_api.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tb_procedure")
public class Procedure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private float cost;
    private Date date;
    //CAMPO QUE N ENTENDI DA PRINT.
    @OneToOne
    @JoinColumn(name = "status", referencedColumnName = "code")
    private Status status;
    @OneToOne
    @JoinColumn(name = "user_cpf", referencedColumnName = "cpf")
    private User user;
    @OneToOne
    @JoinColumn(name = "proceduretype_code", referencedColumnName = "code")
    private ProcedureType procedureType;
    @OneToOne
    @JoinColumn(name = "schedule_code", referencedColumnName = "code")
    private Schedule schedule;

    public Procedure() {
    }

    public Procedure(int code, float cost, Date date, Status status, User user, ProcedureType procedureType, Schedule schedule) {
        this.code = code;
        this.cost = cost;
        this.date = date;
        this.status = status;
        this.user = user;
        this.procedureType = procedureType;
        this.schedule = schedule;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
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

    public ProcedureType getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(ProcedureType procedureType) {
        this.procedureType = procedureType;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
