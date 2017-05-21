package com.sharipov.individual.ui.beans;


import com.sharipov.individual.dao.BookDAO;
import com.sharipov.individual.model.Book;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.List;

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

/*    public String deleteBook(Book book) {
        bookDAO.delete(book);
        books = bookDAO.findAll();
        return null;

    }*/
}
