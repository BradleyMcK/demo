package com.example.demo.rest;


import com.example.demo.domain.Person;
import com.example.demo.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepo;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {

        Person person = personRepo.findById(id).get();
        Long myId = person.getId();
        String name1 = person.getFirstName();
        String name2 = person.getLastName();
        return person;
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {

        Person savedPerson = personRepo.save(person);
        return savedPerson;
    }

}
