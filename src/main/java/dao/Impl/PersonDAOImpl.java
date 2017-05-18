package dao.Impl;

import dao.PersonDAO;
import model.Person;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 18.05.2017
 * Time: 13:18
 */
public class PersonDAOImpl extends BaseEntityDAOImpl<Person> implements PersonDAO {
    public PersonDAOImpl() {
        super(Person.class);
    }
}
