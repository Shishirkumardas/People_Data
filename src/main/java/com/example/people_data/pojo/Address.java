package com.example.people_data.pojo;

import lombok.Data;

@Data
public class Address {
    private int houseNo;
    private String street;
    private String city;
    public Address(int houseNo,String street,String city){
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
    }
}
