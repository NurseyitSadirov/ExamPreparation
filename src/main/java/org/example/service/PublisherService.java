package org.example.service;

import org.example.entity.Publisher;

import java.util.List;

public interface PublisherService {

    Publisher savePublisher(Publisher publisher);
    Publisher getPublisherById(Long id);
    List<Publisher> getPublishers();
    void updatePublisher(Long id, Publisher publisher);
    String deletePublisherByName(String name);
}
