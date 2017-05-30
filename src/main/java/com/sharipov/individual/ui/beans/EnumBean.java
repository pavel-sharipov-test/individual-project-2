package com.sharipov.individual.ui.beans;

import com.sharipov.individual.model.BookType;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 30.05.2017
 * Time: 14:26
 */

@ManagedBean
@ViewScoped
public class EnumBean {
    public Map<String, BookType> getAllBookTypes() {
        return Stream.of(BookType.values()).collect(Collectors.toMap(BookType::name, e -> e));
    }
}
