package org.example.service.impl;

import org.example.entity.Publisher;
import org.example.repository.PublisherRepository;
import org.example.repository.impl.PublisherRepositoryImpl;
import org.example.service.PublisherService;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    PublisherRepository publisherRepository = new PublisherRepositoryImpl();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.savePublisher(publisher);
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.getPublisherById(id);
    }

    @Override
    public List<Publisher> getPublishers() {
        return publisherRepository.getPublishers();
    }

    @Override
    public void updatePublisher(Long id, Publisher publisher) {
        publisherRepository.updatePublisher(id,publisher);
    }

    @Override
    public String deletePublisherByName(String name) {
        return publisherRepository.deletePublisherByName(name);
    }
}
