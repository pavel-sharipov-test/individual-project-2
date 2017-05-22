package com.sharipov.individual.model;

import javax.persistence.*;

/**
 * @author Pavel Sharipov
 */

@Entity
public class Book extends BaseEntity {

    private String name;

    //@Column(name = "authorid")
    @JoinColumn(name = "authorid")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Person author;

    //@Column(name = "publisherid")
    @JoinColumn(name = "publisherid")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Publisher publisher;

    @Enumerated(EnumType.STRING)
    BookType bookType;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        if (year != book.year) return false;
        if (pages != book.pages) return false;
        if (!name.equals(book.name)) return false;
        if (!author.equals(book.author)) return false;
        if (!publisher.equals(book.publisher)) return false;
        return bookType == book.bookType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + bookType.hashCode();
        result = 31 * result + year;
        result = 31 * result + pages;
        return result;
    }
}
