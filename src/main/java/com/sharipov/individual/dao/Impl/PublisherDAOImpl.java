package com.sharipov.individual.dao.Impl;

import com.sharipov.individual.dao.PublisherDAO;
import com.sharipov.individual.model.Publisher;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 18.05.2017
 * Time: 13:19
 */
@Repository
public class PublisherDAOImpl extends BaseEntityDAOImpl<Publisher> implements PublisherDAO {
    public PublisherDAOImpl() {
        super(Publisher.class);
    }
}
