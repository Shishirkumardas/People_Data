package com.example.people_data.controller;

import com.example.people_data.model.PeopleModel;
import com.example.people_data.pojo.Person;
import com.example.people_data.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/persons")
public class PeopleController {
    private final PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public PeopleModel getById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

//    @GetMapping("/{id}")
//    public Person getById(@PathVariable Long id) {
//        return personService.getPerson(id);
//    }

    @GetMapping("/all")
    public List<PeopleModel> getAllPerson() {
        return personService.getAllPerson();
    }

    @PostMapping("/savePerson")
    public PeopleModel savetoModel(@RequestBody Person person) {
        return personService.saveToModel(person);
    }

    @PostMapping("/batch")
    public void saveAllPersons(@RequestBody List<Person> personModels) {
        personService.saveAllPersons(personModels);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }

}
