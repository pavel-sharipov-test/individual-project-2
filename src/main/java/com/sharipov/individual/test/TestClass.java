package com.sharipov.individual.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    }
}
