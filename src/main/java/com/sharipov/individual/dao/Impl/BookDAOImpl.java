package com.sharipov.individual.dao.Impl;

import com.sharipov.individual.dao.BookDAO;
import com.sharipov.individual.model.Book;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 18.05.2017
 * Time: 13:15
 */
@Repository
public class BookDAOImpl extends BaseEntityDAOImpl<Book> implements BookDAO {
    public BookDAOImpl() {
        super(Book.class);
    }

}
