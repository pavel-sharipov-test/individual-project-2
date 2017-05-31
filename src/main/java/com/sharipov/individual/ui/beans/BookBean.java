package com.sharipov.individual.ui.beans;


import com.sharipov.individual.model.Book;
import com.sharipov.individual.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 19.05.2017
 * Time: 14:25
 */

@ManagedBean
@ViewScoped
public class BookBean implements Serializable {

    @ManagedProperty(value = "#{bookService}")
    private BookService bookService;

    private Book book = new Book();
    private List<Book> books;

    @PostConstruct
    public void init() {
        book = new Book();
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

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
