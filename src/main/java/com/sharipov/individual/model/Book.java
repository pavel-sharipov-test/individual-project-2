package com.sharipov.individual.model;

import javax.persistence.*;

/**
 * @author Pavel Sharipov
 */

@Entity
public class Book extends BaseEntity {

    private String name;


    @JoinColumn(name = "authorid")
    @ManyToOne
    private Person author;


    @JoinColumn(name = "publisherid")
    @ManyToOne
    private Publisher publisher;

    @Enumerated(EnumType.STRING)
    private BookType bookType;

    private int year;

    private int pages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}
