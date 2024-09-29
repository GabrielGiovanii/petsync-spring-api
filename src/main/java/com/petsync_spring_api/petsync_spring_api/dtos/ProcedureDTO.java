package com.petsync_spring_api.petsync_spring_api.dtos;

import com.petsync_spring_api.petsync_spring_api.entities.Procedure;

import java.util.Date;

public class ProcedureDTO {

    private Integer code;
    private Double cost;
    private Date date;
    private String prescription;
    private Integer statusCode;
    private String veterinarianCpf;
    private Integer procedureTypeCode;
    private Integer scheduleCode;

    public ProcedureDTO() {
    }

    public ProcedureDTO(Procedure entity) {
        this.code = entity.getCode();
        this.cost = entity.getCost();
        this.date = entity.getDate();
        this.prescription = entity.getPrescription();

        if(entity.getStatus() != null) {
            this.statusCode = entity.getStatus().getCode();
        }

        if(entity.getUser() != null) {
            this.veterinarianCpf = entity.getUser().getCpf();
        }

        if(entity.getProcedureType() != null) {
            this.procedureTypeCode = entity.getProcedureType().getCode();
        }

        if(entity.getSchedule() != null) {
            this.scheduleCode = entity.getSchedule().getCode();
        }
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

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getVeterinarianCpf() {
        return veterinarianCpf;
    }

    public void setVeterinarianCpf(String veterinarianCpf) {
        this.veterinarianCpf = veterinarianCpf;
    }

    public Integer getProcedureTypeCode() {
        return procedureTypeCode;
    }

    public void setProcedureTypeCode(Integer procedureTypeCode) {
        this.procedureTypeCode = procedureTypeCode;
    }

    public Integer getScheduleCode() {
        return scheduleCode;
    }

    public void setScheduleCode(Integer scheduleCode) {
        this.scheduleCode = scheduleCode;
    }
}
