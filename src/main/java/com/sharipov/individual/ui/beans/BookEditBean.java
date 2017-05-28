package com.sharipov.individual.ui.beans;

import com.sharipov.individual.dao.PersonDAO;
import com.sharipov.individual.dao.PublisherDAO;
import com.sharipov.individual.model.Book;
import com.sharipov.individual.model.Person;
import com.sharipov.individual.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by pavel on 28.05.2017.
 */
@Named
@SessionScoped
public class BookEditBean implements Serializable {

    private Book book;
    private List<Publisher> publishersList;
    private List<Person> personList;

    @Autowired
    private PublisherDAO publisherDAO;
    @Autowired
    private PersonDAO personDAO;


    @PostConstruct
    public void init() {
        book = new Book();
        publishersList = publisherDAO.findAll();
        personList = personDAO.findAll();
    }

    public String updateBook(Book book) {
        setBook(book);
        init();
        return "add_edit_book.xhtml";
    }





    public List<Person> getPersonList() {
        return personList;
    }


    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Publisher> getPublishersList() {

        return publishersList;
    }

    public void setPublishersList(List<Publisher> publishersList) {
        this.publishersList = publishersList;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
