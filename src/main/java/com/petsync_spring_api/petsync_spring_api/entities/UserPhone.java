package com.petsync_spring_api.petsync_spring_api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_userphone")
public class UserPhone {

    @Id
    private Integer code;
    private String number;

    @JsonIgnore
    @ManyToOne
    private User user;

    public UserPhone() {
    }

    public UserPhone(Integer code, String number, User user) {
        this.code = code;
        this.number = number;
        this.user = user;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        UserPhone userPhone = (UserPhone) object;
        return Objects.equals(number, userPhone.number) && Objects.equals(user, userPhone.user);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(number);
        result = 31 * result + Objects.hashCode(user);
        return result;
    }
}
