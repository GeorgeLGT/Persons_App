package ru.netology.personsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.personsapp.entity.Person;
import ru.netology.personsapp.entity.PersonId;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {

    List<Person> findByCityOfLiving(String city);

    List<Person> findByAgeLessThanOrderByAgeAsc(Integer age);

    Optional<Person> findByNameAndSurname(String name, String surname);

}