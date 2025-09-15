package ru.netology.personsapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.netology.personsapp.entity.Person;
import ru.netology.personsapp.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return repository.findByCityOfLiving(city);
    }


    @GetMapping("/younger-than")
    public List<Person> getPersonsYoungerThan(@RequestParam Integer age) {
        return repository.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/by-name-surname")
    public ResponseEntity<Person> getPersonByNameAndSurname(
            @RequestParam String name,
            @RequestParam String surname) {

        Optional<Person> person = repository.findByNameAndSurname(name, surname);
        return person.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return repository.save(person);
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person person) {
        return repository.save(person);
    }

    @DeleteMapping
    public void deletePerson(@RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam Integer age) {
        repository.deleteById(new ru.netology.personsapp.entity.PersonId(name, surname, age));
    }

    @GetMapping
    public List<Person> findAll() {
        return repository.findAll();
    }
}