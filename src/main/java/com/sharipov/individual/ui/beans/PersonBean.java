package com.sharipov.individual.ui.beans;

import com.sharipov.individual.dao.PersonDAO;
import com.sharipov.individual.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Created by pavel on 21.05.2017.
 */

@Named("personBean")
@ViewScoped
public class PersonBean {

    @Autowired
    private PersonDAO personDAO;

    private List<Person> persons;

    @PostConstruct
    public void init() {
        persons = personDAO.findAll();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void deletePerson(Person person) {
        personDAO.delete(person);
        init();
    }

    public Person getPersonbyId(Long id) {
        return persons.stream().filter(person -> person.getId().equals(id)).findFirst().get();
    }
}
