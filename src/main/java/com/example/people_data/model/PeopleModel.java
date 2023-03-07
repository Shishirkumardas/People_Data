package com.example.people_data.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
public class PeopleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "addressID")
    private long addressId = 0;

    @Column(name = "birthDate")
    private String birthdate;
    @Column(name = "securityNumber")
    private String securityNumber;

    public PeopleModel(String name, int age, long addressId, String birthdate, String securityNumber) {
        this.name = name;
        this.age = age;
        this.addressId = addressId;
        this.birthdate = birthdate;
        this.securityNumber = securityNumber;
    }

    public PeopleModel() {

    }
}
