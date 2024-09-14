package com.petsync_spring_api.petsync_spring_api.entities;

import jakarta.persistence.*;

import java.io.File;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_client")
public class Client {
    @Id
    private String cpf;
    private String name;
    private String email;
    @Column(length = 100000)
    private byte[] image;
    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ClientPhone> clientPhones;

    public Client() {
    }

    public Client(String cpf, String nome, String email, byte[] imagem, String endereco) {
        this.cpf = cpf;
        this.name = nome;
        this.email = email;
        this.image = imagem;
        this.address = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<ClientPhone> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(Set<ClientPhone> clientPhones) {
        this.clientPhones = clientPhones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(cpf, client.cpf) && Objects.equals(name, client.name) && Objects.equals(email, client.email) && Objects.equals(image, client.image) && Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, name, email, image, address);
    }
}
