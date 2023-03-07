package com.example.people_data.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "address")
public class AddressModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "houseNo")
    private int houseNo;
    @Column(name = "Street")
    private String street;
    @Column(name = "City")
    private String city;

    public AddressModel(int houseNo, String street, String city) {
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
    }

    public AddressModel() {

    }
}
