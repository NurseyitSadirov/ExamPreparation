package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.config.HibernateConfig;
import org.example.entity.Author;
import org.example.entity.Publisher;
import org.example.repository.AuthorRepository;

import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository {
    EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public String saveAuthor(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author.getFirstName() + " is saved!!!";
    }

    @Override
    public void updateAuthor(Long id, Author author) {
        entityManager.getTransaction().begin();
        entityManager.find(Author.class, id);
        entityManager.merge(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Author getAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }

    @Override
    public String getAuthorByPublisherId(Long publisherId) {
        entityManager.getTransaction().begin();
        TypedQuery<String> authorQuery = entityManager.createQuery(
                        "select a.firstName from Author a " +
                                "join a.publisher p on p.id = :publisherId",
                        String.class)
                .setParameter("publisherId", publisherId);
        String authorName = authorQuery.getSingleResult();
        entityManager.getTransaction().commit();
        return authorName;
    }

    @Override
    public void deleteAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, id);
        entityManager.remove(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public String assignAuthorToPublisher(Long authorId, Long publisherId) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, authorId);
        Publisher publisher = entityManager.find(Publisher.class, publisherId);
        author.getPublisher().add(publisher);
        publisher.getAuthor().add(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "";
    }
}
