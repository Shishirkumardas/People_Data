package com.example.people_data.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;



@Data
@JsonDeserialize(using = PersonModelDeserializer.class)
@JsonSerialize(using = PersonModelSerializer.class)
public class Person {
    private String name;
    private int age;
    private Address address;
    private String birthdate;
    private String securityNumber;
    public Person(String name, int age, Address address,
                  String birthdate, String securityNumber){
        this.name=name;
        this.age=age;
        this.birthdate= birthdate;
        this.securityNumber=securityNumber;
        this.address= address;
    }

}
