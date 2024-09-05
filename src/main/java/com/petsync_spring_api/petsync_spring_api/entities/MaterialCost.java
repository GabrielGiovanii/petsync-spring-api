package com.petsync_spring_api.petsync_spring_api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_materialcost")
public class MaterialCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "procedure_code", referencedColumnName = "code")
    private Procedure procedure;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_code", referencedColumnName = "code")
    private Material material;
    private int quantity;
    private float valor;

    public MaterialCost() {
    }

    public MaterialCost(int code, Procedure procedure, Material material, int quantity, float valor) {
        this.code = code;
        this.procedure = procedure;
        this.material = material;
        this.quantity = quantity;
        this.valor = valor;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
