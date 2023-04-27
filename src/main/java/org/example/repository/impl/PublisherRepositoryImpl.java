package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.entity.Publisher;
import org.example.repository.PublisherRepository;

import java.util.List;

public class PublisherRepositoryImpl implements PublisherRepository {
    EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public Publisher getPublisherById(Long id) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public List<Publisher> getPublishers() {
        entityManager.getTransaction().begin();
        List<Publisher> select = entityManager.createQuery("select c from Publisher c", Publisher.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return select;
    }

    @Override
    public void updatePublisher(Long id, Publisher publisher) {
        entityManager.getTransaction().begin();
        entityManager.find(Publisher.class, id);
        entityManager.merge(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public String deletePublisherByName(String name) {
        entityManager.getTransaction().begin();
        Publisher name1 = entityManager.createQuery("select p from Publisher p where p.name = :name",Publisher.class).setParameter("name", name).getSingleResult();
        entityManager.remove(name1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return " Successfully deleted!!!";
    }
}
