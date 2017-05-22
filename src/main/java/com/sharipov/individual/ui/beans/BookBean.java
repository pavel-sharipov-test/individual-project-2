package com.sharipov.individual.ui.beans;


import com.sharipov.individual.dao.BookDAO;
import com.sharipov.individual.model.Book;
import com.sharipov.individual.service.BookService;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
    private BookService bookService;

    private Book book = new Book();
    private List<Book> books;

    @PostConstruct
    private void init() {
        books = bookService.findAllBooks();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String doCreateBook() {
        bookService.createBook(book);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Book created", "Книга" + book.getName() + " была создана с id=" + book.getId()));
        return "newBook.xhtml";
    }

    public List<Book> getBooks() {
        init();
        return books;
    }

    public void deleteBook(Book book) {
        bookService.deleteBook(book);
        init();
    }


}
