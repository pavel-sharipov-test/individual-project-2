package com.sharipov.individual.service;

import com.sharipov.individual.model.Book;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 22.05.2017
 * Time: 13:31
 */
public interface BookService {
    Book createBook(Book book);

    List<Book> findAllBooks();

    Book findBookById(Long id);

    void deleteBook(Book book);
}
