package com.sharipov.individual.dao.Impl;

import com.sharipov.individual.dao.PersonDAO;
import com.sharipov.individual.model.Person;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 18.05.2017
 * Time: 13:18
 */
@Repository
public class PersonDAOImpl extends BaseEntityDAOImpl<Person> implements PersonDAO {
    public PersonDAOImpl() {
        super(Person.class);
    }
}
