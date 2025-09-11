create schema if not exists netology;

create table if not exists netology.persons(
                                               name varchar(50),
    surname varchar(50),
    age integer,
    phone_number varchar(20),
    city_of_living varchar(50),
    primary key (name, surname, age)
    );