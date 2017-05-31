package com.sharipov.individual.ui.beans;

import com.sharipov.individual.model.Person;
import com.sharipov.individual.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

/*
*
* Created by pavel on 28.05.2017.
*
*/

@ManagedBean
@ViewScoped
public class PersonEditBean implements Serializable {

    @ManagedProperty(value = "#{personService}")
    private PersonService personService;

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

    public void savePerson() {
        personService.createPerson(person);

    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
