package com.sharipov.individual;

import com.sharipov.individual.dao.BookDAO;
import com.sharipov.individual.dao.Impl.BookDAOImpl;
import com.sharipov.individual.dao.Impl.PersonDAOImpl;
import com.sharipov.individual.dao.Impl.PublisherDAOImpl;
import com.sharipov.individual.dao.PersonDAO;
import com.sharipov.individual.dao.PublisherDAO;
import com.sharipov.individual.model.Book;
import com.sharipov.individual.model.BookType;
import com.sharipov.individual.model.Person;
import com.sharipov.individual.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 18.05.2017
 * Time: 14:05
 */

public class TestClass {






    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.isActive());
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
        TestClass testClass = new TestClass();
        PublisherDAO publisherDAO = context.getBean(PublisherDAO.class);
        PersonDAO personDAO = context.getBean(PersonDAO.class);
        BookDAO bookDAO = context.getBean(BookDAO.class);

        Publisher publisher1 = new Publisher();
        publisher1.setName("First test publisher");
        Person person1 = new Person();
        person1.setName("First person - author");
        Book book1 = new Book();
        book1.setAuthor(person1);
        book1.setPublisher(publisher1);
        book1.setName("First test book");
        book1.setPages(300);
        book1.setYear(2017);
        book1.setBookType(BookType.CHILDREN);
        Publisher publisher2 = new Publisher();
        publisher2.setName("Second test publisher");
        Person person2 = new Person();
        person2.setName("Second person - author");
        Book book2 = new Book();
        book2.setAuthor(person2);
        book2.setYear(2018);
        book2.setPublisher(publisher2);
        book2.setName("Second test book");
        book2.setPages(400);
        book2.setBookType(BookType.HISTORY);
        publisher1.addBook(book1);
        publisher2.addBook(book2);
        person2.addBook(book1);
        person1.addBook(book2);
/*        person1.setId(1L);
        person2.setId(2L);
        publisher1.setId(1L);
        publisher2.setId(2L);*/
        personDAO.save(person1);
        personDAO.save(person2);
        publisherDAO.save(publisher1);
        publisherDAO.save(publisher2);






    }
}
