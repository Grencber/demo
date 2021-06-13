package com.example.demo.interfaceAdapters;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerDataMapper {
    @Id
    @GeneratedValue
    Integer id;
    @NonNull
    String name;
    @NonNull
    String surname;
    @OneToMany(mappedBy = "customer")
    List<AccountDataMapper> accounts;

    public CustomerDataMapper() {
    }

    public CustomerDataMapper(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

