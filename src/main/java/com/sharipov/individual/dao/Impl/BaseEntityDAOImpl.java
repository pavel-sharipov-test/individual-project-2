package com.sharipov.individual.dao.Impl;

import com.sharipov.individual.dao.BaseEntityDAO;
import com.sharipov.individual.model.BaseEntity;
import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 18.05.2017
 * Time: 11:47
 */
@Transactional
public abstract class BaseEntityDAOImpl<T extends BaseEntity> implements BaseEntityDAO<T> {

    //private static final Logger LOGGER = LoggerFactory.getLogger(BaseEntityDAOImpl.class);
    private Class<T> type;

    @PersistenceContext
    protected EntityManager entityManager;

    public BaseEntityDAOImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public void save(T object) {
        if (object.getId() == null) {
            entityManager.persist(object);
        } else {
            entityManager.merge(object);
        }
    }

    @Override
    public T find(long id) {
        T result = entityManager.find(type, id);
        return result;
    }


    @Override
    public List<T> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
        Root<T> root = criteriaQuery.from(type);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void delete(T object) {
        entityManager.remove(object);
    }
}
