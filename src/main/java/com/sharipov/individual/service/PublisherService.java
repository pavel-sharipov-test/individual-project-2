package com.sharipov.individual.service;

import com.sharipov.individual.model.Publisher;

import java.util.List;

/**
 * Created by pavel on 29.05.2017.
 */

public interface PublisherService {
    Publisher createPublisher(Publisher publisher);

    List<Publisher> findAllPublishers();

    Publisher find(Long id);
}
