package com.sharipov.individual.service.Impl;

import com.sharipov.individual.dao.PublisherDAO;
import com.sharipov.individual.model.Publisher;
import com.sharipov.individual.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pavel on 29.05.2017.
 */

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    PublisherDAO publisherDAO;

    @Override
    public Publisher createPublisher(Publisher publisher) {
        publisherDAO.save(publisher);
        return publisher;
    }

    @Override
    public List<Publisher> findAllPublishers() {
        return publisherDAO.findAll();
    }

    @Override
    public Publisher find(Long id) {
        return publisherDAO.find(id);
    }
}
