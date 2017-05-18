package com.sharipov.individual.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Pavel Sharipov
 */
@Entity
public class Person extends BaseEntity {

    private int bookCount;

    private String name;

    //@CollectionTable(name = "Book", joinColumns = @JoinColumn(name = "id"))
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "author")
    private List<Book> books;

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

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
}
