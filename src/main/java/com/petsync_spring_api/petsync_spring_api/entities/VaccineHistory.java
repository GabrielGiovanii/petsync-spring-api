package com.petsync_spring_api.petsync_spring_api.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_vaccinehistory")
public class VaccineHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private int vaccineType;
    private String vaccineBrand;
    private Date applicationDate;
    private Date dueDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_code", referencedColumnName = "code")
    private Pet pet;

    public VaccineHistory() {
    }

    public VaccineHistory(int code, int vaccineType, String vaccineBrand, Date applicationDate, Date dueDate, Pet pet) {
        this.code = code;
        this.vaccineType = vaccineType;
        this.vaccineBrand = vaccineBrand;
        this.applicationDate = applicationDate;
        this.dueDate = dueDate;
        this.pet = pet;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(int vaccineType) {
        this.vaccineType = vaccineType;
    }

    public String getVaccineBrand() {
        return vaccineBrand;
    }

    public void setVaccineBrand(String vaccineBrand) {
        this.vaccineBrand = vaccineBrand;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
