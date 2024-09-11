package com.petsync_spring_api.petsync_spring_api.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "animal_code", referencedColumnName = "code")
    private AnimalType animalType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "furcolor_code", referencedColumnName = "code")
    private FurColor furColor;

    private Date birthDate;
    private Integer sex;
    private float weight;
    @Column(length = 100000)
    private byte[] Image;
    private Integer pet_condition;
    private String observation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_cpf", referencedColumnName = "cpf")
    private Client client;

    public Pet() {
    }

    public Pet(Client client, String observation, Integer pet_condition, byte[] image, float weight, Integer sex, Date birthDate, FurColor furColor, AnimalType animalType, String name, Integer code) {
        this.client = client;
        this.observation = observation;
        this.pet_condition = pet_condition;
        Image = image;
        this.weight = weight;
        this.sex = sex;
        this.birthDate = birthDate;
        this.furColor = furColor;
        this.animalType = animalType;
        this.name = name;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public FurColor getFurColor() {
        return furColor;
    }

    public void setFurColor(FurColor furColor) {
        this.furColor = furColor;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }

    public Integer getPet_condition() {
        return pet_condition;
    }

    public void setPet_condition(Integer condition) {
        this.pet_condition = condition;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
