package ru.netology.personsapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import ru.netology.personsapp.entity.Person;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Person> getPersonsByCity(String city) {
        TypedQuery<Person> query = em.createQuery(
                "select p from Person p where p.cityOfLiving = :city",
                Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }
}