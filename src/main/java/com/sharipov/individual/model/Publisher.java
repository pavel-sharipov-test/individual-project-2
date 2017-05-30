package com.sharipov.individual.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Sharipov
 */
@Entity
public class Publisher extends BaseEntity {

    private String name;

    //@CollectionTable(name = "Book", joinColumns = @JoinColumn(name = "id"))
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "publisher")
    private List<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    //For test reasons only
    public void addBook(Book book) {
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(book);
        book.setPublisher(this);
    }

}
