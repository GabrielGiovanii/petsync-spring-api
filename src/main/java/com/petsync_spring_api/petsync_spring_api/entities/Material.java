package com.petsync_spring_api.petsync_spring_api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private String name;
    private String brand;
    private float valor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "materialtype_code", referencedColumnName = "code")
    private MaterialType type;

    public Material() {
    }

    public Material(int code, String name, String brand, float valor, MaterialType type) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.valor = valor;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public MaterialType getType() {
        return type;
    }

    public void setType(MaterialType type) {
        this.type = type;
    }
}
