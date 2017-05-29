package com.sharipov.individual.ui.beans;

import com.sharipov.individual.dao.PublisherDAO;
import com.sharipov.individual.model.Publisher;
import com.sharipov.individual.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by pavel on 21.05.2017.
 */
@Named
@SessionScoped
public class PublisherEditBean implements Serializable {

    @Autowired
    private PublisherService publisherService;

    private List<Publisher> publishers;

    private Publisher publisher;

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @PostConstruct
    public void init() {
        publisher = new Publisher();
        publishers = publisherService.findAllPublishers();
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public String savePublisher() {
        publisherService.createPublisher(publisher);

        return "index";
    }

    public Publisher getPublisherbyId(Long id) {
        return publishers.stream().filter(person -> person.getId().equals(id)).findFirst().get();
    }
}
