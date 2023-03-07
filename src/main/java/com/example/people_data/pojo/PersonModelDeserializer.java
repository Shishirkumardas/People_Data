package com.example.people_data.pojo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;


public class PersonModelDeserializer extends JsonDeserializer<Person> {


    @Override
    public Person deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);

        String name = node.get("name").asText();
        int age = node.get("age").asInt();

        // deserialize the address object
        JsonNode AddressNode = node.get("address");
        Address address = null;
        int houseNo = AddressNode.get("HouseNo").asInt();
        String street = AddressNode.get("Street").asText();
        String city = AddressNode.get("City").asText();
        address = new Address(houseNo, street, city);

        String birthDate = node.get("birthdate").asText();
        String securityNumber = node.get("securityNumber").asText();
        return new Person(name, age, address, birthDate, securityNumber);

    }
}
