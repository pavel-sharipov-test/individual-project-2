package com.sharipov.individual.ui.beans;


import com.sharipov.individual.dao.BookDAO;
import com.sharipov.individual.model.Book;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 19.05.2017
 * Time: 14:25
 */

@Named("bookBean")
@ViewScoped
public class BookBean {

    @Autowired
    private BookDAO bookDAO;

    private Book book;

    public Book getBook() {
        return book;
    }

    public void createBook() {
        getBook().setName(getBook().getName().trim());
        bookDAO.save(book);
    }

    public String getBookName() {
        return bookDAO.find(1).getName();
    }

    @PostConstruct
    private void init() {
        books = bookDAO.findAll();
    }

    private List<Book> books;

 /*   public void deleteBook(Book book) {
        bookDAO.delete(book);
    }*/

    public List<Book> getBooks() {
        return books;
    }

    public void deleteBook(Book book) {
        bookDAO.delete(book);
        init();


    }

    public void viewPersons() {
        Map<String,Object> options = new HashMap<>();
        options.put("resizable", false);
        RequestContext.getCurrentInstance().openDialog("persons", options, null);
    }

/*    public String deleteBook(Book book) {
        bookDAO.delete(book);
        books = bookDAO.findAll();
        return null;

    }*/
}
