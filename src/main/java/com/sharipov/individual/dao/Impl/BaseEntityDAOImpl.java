package com.sharipov.individual.dao.Impl;

import com.sharipov.individual.dao.BaseEntityDAO;
import com.sharipov.individual.model.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 18.05.2017
 * Time: 11:47
 */
@Transactional
public abstract class BaseEntityDAOImpl<T extends BaseEntity> implements BaseEntityDAO<T> {
    private Class<T> type;

    public BaseEntityDAOImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public void add(T object) {

    }

    @Override
    public void update(T object) {

    }

    @Override
    public T find(long id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public void delete(T object) {

    }
}
