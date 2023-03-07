package com.example.people_data.service;

import com.example.people_data.model.AddressModel;
import com.example.people_data.model.PeopleModel;
import com.example.people_data.pojo.Address;
import com.example.people_data.pojo.Person;
import com.example.people_data.repository.AddressRepository;
import com.example.people_data.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@CacheConfig
@Service
@CacheConfig(cacheNames = "personCache", cacheManager = "cacheManager")
public class PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }


    //to get person info for person Model
    @Cacheable(key = "#id")
    public PeopleModel getPersonById(long id) {
        PeopleModel person = personRepository.findById(id).get();
        return person;
    }

    //to get person info for person pojo
    public Person getPerson(long id) {
        PeopleModel person = personRepository.findById(id).get();
        return PersonModelToPojo(person);
    }

    public List<PeopleModel> getAllPerson() {
        return new ArrayList<>(personRepository.findAll());
    }

    //5 methods to get the full details of the person including address
    //To get info from person Model to Person(pojo) including address
    private Person PersonModelToPojo(PeopleModel person) {
        Address address = AddressModelToPojo(person);
        return new Person(person.getName(), person.getAge(), address, person.getBirthdate(), person.getSecurityNumber());
    }

    //Extract address from the addressModel to Pojo
    private Address AddressModelToPojo(PeopleModel person) {
        AddressModel address = addressRepository.findById(person.getAddressId()).get();
        return new Address(address.getHouseNo(), address.getStreet(), address.getCity());
    }

    //    to save person info to person pojo
    @CachePut(key = "#result.id")
    public PeopleModel saveToModel(Person person) {
        addressRepository.save(pojoToAddressModel(person.getAddress()));
        return personRepository.save(pojoToPersonModel(person));
    }

    public PeopleModel pojoToPersonModel(Person person) {
        long addressId = pojoToAddressModel(person.getAddress()).getId();
        return new PeopleModel(person.getName(), person.getAge(), addressId, person.getBirthdate(), person.getSecurityNumber());
    }

    public AddressModel pojoToAddressModel(Address address) {
        return new AddressModel(address.getHouseNo(), address.getCity(), address.getStreet());
    }

    //    saving with pojo ends here

    public List<PeopleModel> saveAllPersons(List<Person> persons) {
        List<PeopleModel> savedPeople = new ArrayList<>();
        for (Person person : persons) {
            addressRepository.save(pojoToAddressModel(person.getAddress()));
            PeopleModel peopleModel = personRepository.save(pojoToPersonModel(person));
            savedPeople.add(peopleModel);
        }
        return savedPeople;
    }

    @CacheEvict(key = "#id")
    public void delete(long id) {
        personRepository.deleteById(id);
    }
}
