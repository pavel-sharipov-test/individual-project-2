package com.sharipov.individual.ui.beans;

import com.sharipov.individual.model.Person;
import com.sharipov.individual.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/*
*
* Created by pavel on 28.05.2017.
*
*/

@Named
@SessionScoped
public class PersonEditBean implements Serializable {

    @Autowired
    PersonService personService;

    private List<Person> persons;

    private Person person;

    @PostConstruct
    public void init() {
        persons = personService.findAllPersons();
        person = new Person();
    }

    public Person getPerson() {
        return person;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String savePerson() {
        personService.createPerson(person);
        return "index";
    }
}
