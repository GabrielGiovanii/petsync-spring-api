package com.petsync_spring_api.petsync_spring_api.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "tb_surgeryhistory")
public class SurgeryHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private String procedureName;
    private Date date;
    private String detail;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_code", referencedColumnName = "code")
    private Pet pet;

    public SurgeryHistory() {
    }

    public SurgeryHistory(int code, String procedureName, Date date, String detail, Pet pet) {
        this.code = code;
        this.procedureName = procedureName;
        this.date = date;
        this.detail = detail;
        this.pet = pet;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
