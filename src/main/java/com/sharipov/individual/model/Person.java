package com.sharipov.individual.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Sharipov
 */
@Entity
public class Person extends BaseEntity {

    private String name;

    //@CollectionTable(name = "Book", joinColumns = @JoinColumn(name = "id"))
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "author")
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
        book.setAuthor(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Person person = (Person) o;

        if (bookCount != person.bookCount) return false;
        if (!name.equals(person.name)) return false;
        return books.equals(person.books);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + bookCount;
        result = 31 * result + name.hashCode();
        result = 31 * result + books.hashCode();
        return result;
    }
}
