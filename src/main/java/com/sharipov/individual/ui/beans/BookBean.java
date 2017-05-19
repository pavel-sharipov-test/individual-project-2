package com.sharipov.individual.ui.beans;


import com.sharipov.individual.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 19.05.2017
 * Time: 14:25
 */

@Named("book")
@ViewScoped
public class BookBean {

    @Autowired
    private BookDAO bookDAO;

    public String getBookName() {
        return bookDAO.find(1).getName();
    }


}
