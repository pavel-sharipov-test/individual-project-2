package com.sharipov.individual.service;

import com.sharipov.individual.model.Person;

import java.util.List;

/**
 * Created by pavel on 29.05.2017.
 */
public interface PersonService {

    Person createPerson(Person person);

    List<Person> findAllPersons();

    Person find(Long id);
}
