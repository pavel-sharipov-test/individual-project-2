package com.sharipov.individual.dao;

import com.sharipov.individual.model.BaseEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author Pavel Sharipov
 *         Date: 18.05.2017
 *         Time: 11:32
 */
public interface BaseEntityDAO<T extends BaseEntity> {
    void add(T object);

    void update(T object);

    T find(long id);

    List<T> findAll();

    void delete(T object);
}
