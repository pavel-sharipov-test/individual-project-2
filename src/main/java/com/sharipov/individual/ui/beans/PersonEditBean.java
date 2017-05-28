package com.sharipov.individual.ui.beans;

import com.sharipov.individual.model.Person;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

/*
*
* Created by pavel on 28.05.2017.
*
*/

@Named
@SessionScoped
public class PersonEditBean implements Serializable {

    private Person person;

    @PostConstruct
    public void init() {
        person = new Person();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
