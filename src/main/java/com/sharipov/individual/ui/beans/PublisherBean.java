package com.sharipov.individual.ui.beans;

import com.sharipov.individual.dao.PublisherDAO;
import com.sharipov.individual.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Created by pavel on 21.05.2017.
 */
@Named("publisherBean")
@ViewScoped
public class PublisherBean {

    @Autowired
    private PublisherDAO publisherDAO;

    private List<Publisher> publishers;

    @PostConstruct
    public void init() {
        publishers = publisherDAO.findAll();
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void deletePublisher(Publisher publisher) {
        publisherDAO.delete(publisher);
        init();
    }

    public Publisher findPublisherById(Long id) {
        return publisherDAO.find(id);
    }

    public Publisher getPublisherbyId(Long id) {
        init();
        return publishers.stream().filter(publisher -> publisher.getId().equals(id)).findFirst().get();
    }



}
