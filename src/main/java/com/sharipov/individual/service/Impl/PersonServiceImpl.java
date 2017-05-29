package com.sharipov.individual.service.Impl;

import com.sharipov.individual.dao.PersonDAO;
import com.sharipov.individual.model.Person;
import com.sharipov.individual.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pavel on 29.05.2017.
 */

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;
    @Override
    public Person createPerson(Person person) {
        personDAO.save(person);
        return person;
    }

    @Override
    public List<Person> findAllPersons() {
        return personDAO.findAll();
    }

    @Override
    public Person find(Long id) {
        return personDAO.find(id);
    }
}
