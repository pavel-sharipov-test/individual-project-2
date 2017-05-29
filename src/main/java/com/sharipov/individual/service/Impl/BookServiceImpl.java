package com.sharipov.individual.service.Impl;

import com.sharipov.individual.dao.BookDAO;
import com.sharipov.individual.model.Book;
import com.sharipov.individual.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 22.05.2017
 * Time: 13:26
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDAO bookDAO;

    @Override
    public Book createBook(Book book) {
        bookDAO.save(book);
        return book;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        return bookDAO.find(id);
    }

    @Override
    public void deleteBook(Book book) {
        bookDAO.delete(book);
    }
}
