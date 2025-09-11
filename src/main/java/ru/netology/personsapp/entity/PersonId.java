package ru.netology.personsapp.entity;

import java.io.Serializable;
import java.util.Objects;

public class PersonId implements Serializable {
    private String name;
    private String surname;
    private Integer age;

    public PersonId() {}

    public PersonId(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonId)) return false;
        PersonId that = (PersonId) o;
        return Objects.equals(name, that.name)
               && Objects.equals(surname, that.surname)
               && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}