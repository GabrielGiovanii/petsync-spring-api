package com.petsync_spring_api.petsync_spring_api.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tb_procedure")
public class Procedure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    private Double cost;
    private Date date;
    //CAMPO QUE N ENTENDI DA PRINT.
    private String prescription;
    @ManyToOne
    @JoinColumn(name = "status_code", referencedColumnName = "code")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "veterinarian_cpf", referencedColumnName = "cpf")
    private User user;
    @ManyToOne
    @JoinColumn(name = "proceduretype_code", referencedColumnName = "code")
    private ProcedureType procedureType;
    @OneToOne
    @JoinColumn(name = "schedule_code", referencedColumnName = "code")
    private Schedule schedule;

    public Procedure() {
        this.date = new Date();
    }

    public Procedure(Integer code, Double cost, String prescription, Status status, User user, ProcedureType procedureType, Schedule schedule) {
        this.code = code;
        this.cost = cost;
        this.prescription = prescription;
        this.date = new Date();
        this.status = status;
        this.user = user;
        this.procedureType = procedureType;
        this.schedule = schedule;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
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
