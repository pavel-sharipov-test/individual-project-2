package com.sharipov.individual.ui.beans;

import com.sharipov.individual.model.Book;
import com.sharipov.individual.model.Person;
import com.sharipov.individual.model.Publisher;
import com.sharipov.individual.service.BookService;
import com.sharipov.individual.service.PersonService;
import com.sharipov.individual.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by pavel on 28.05.2017.
 */
@ManagedBean
@ViewScoped
public class BookEditBean implements Serializable {

    private Book book;
    private List<Publisher> publishersList;
    private List<Person> personList;

    @ManagedProperty(value = "#{publisherService}")
    private PublisherService publisherService;
    @ManagedProperty(value = "#{personService}")
    private PersonService personService;
    @ManagedProperty(value = "#{bookService}")
    private BookService bookService;


    @PostConstruct
    public void init() {
        book = new Book();
        publishersList = publisherService.findAllPublishers();
        personList = personService.findAllPersons();
    }

    public void updateBook(Book book) {
        setBook(book);
        init();
    }

    public void saveBook() {
        bookService.createBook(book);

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

    public void setPublisherService(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
