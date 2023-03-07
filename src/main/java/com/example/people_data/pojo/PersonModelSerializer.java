package com.example.people_data.pojo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public abstract class PersonModelSerializer extends JsonSerializer<Person> {
    @Override
    public void serialize(Person person, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name",person.getName());
        jsonGenerator.writeNumberField("age",person.getAge());

        // serialize the address object
        Address address = null;

        jsonGenerator.writeObjectFieldStart("address");
        jsonGenerator.writeNumberField("HouseNo", address.getHouseNo());
        jsonGenerator.writeStringField("Street", address.getStreet());
        jsonGenerator.writeStringField("City", address.getCity());
        jsonGenerator.writeEndObject();


        jsonGenerator.writeStringField("birthdate", person.getBirthdate());
        jsonGenerator.writeStringField("securityNumber", person.getSecurityNumber());
        jsonGenerator.writeEndObject();
    }
}
