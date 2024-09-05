package com.petsync_spring_api.petsync_spring_api.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private float totalValue;
    private Date paymentDate;
    private String observations;
    private int parcelQuantity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "procedure_code", referencedColumnName = "code")
    private Procedure procedure;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentmethod_code", referencedColumnName = "code")
    private PaymentMethod paymentMethod;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status", referencedColumnName = "code")
    private Status status;

    public Payment() {
    }

    public Payment(int code, float totalValue, Date paymentDate, String observations, int parcelQuantity, Procedure procedure, PaymentMethod paymentMethod, Status status) {
        this.code = code;
        this.totalValue = totalValue;
        this.paymentDate = paymentDate;
        this.observations = observations;
        this.parcelQuantity = parcelQuantity;
        this.procedure = procedure;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public int getParcelQuantity() {
        return parcelQuantity;
    }

    public void setParcelQuantity(int parcelQuantity) {
        this.parcelQuantity = parcelQuantity;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
