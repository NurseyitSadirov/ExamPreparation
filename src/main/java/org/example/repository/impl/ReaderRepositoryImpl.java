package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.config.HibernateConfig;
import org.example.entity.Book;
import org.example.entity.Reader;
import org.example.repository.ReaderRepository;

public class ReaderRepositoryImpl implements ReaderRepository {
    EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveReader(Reader reader) {
        entityManager.getTransaction().begin();
        entityManager.persist(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return reader.getName() + " is saved ";
    }

    @Override
    public String updateReader(Long id, Reader reader) {
        entityManager.getTransaction().begin();
        Reader existingReader = entityManager.find(Reader.class, id);
        if (existingReader == null) {
            entityManager.getTransaction().rollback();
            return "Reader with ID " + id + " does not exist";
        }
        existingReader.setName(reader.getName());
        existingReader.setEmail(reader.getEmail());
        existingReader.setAge(reader.getAge());
        Reader updatedReader = entityManager.merge(existingReader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return updatedReader + " Successfully updated";
//        entityManager.getTransaction().begin();
//        entityManager.find(Reader.class,id);
//        Reader merge = entityManager.merge(reader);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        return merge + " Successfully update ";
    }

    @Override
    public Book getReaderByBookId(Long bookId) {
        entityManager.getTransaction().begin();
        TypedQuery<Book> bookTypedQuery = entityManager.createQuery("" +
                "select r From Reader r " +
                "join r.book b where b.id = :bookId",
                 Book.class)
                .setParameter("bookId", bookId);
        entityManager.detach(bookTypedQuery);
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public void deleteReaderById(Long id) {
        entityManager.getTransaction().begin();
        Reader reader = entityManager.find(Reader.class, id);
        entityManager.remove(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Reader getReaderByAuthorId(Long authorId) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Reader a " +
                "join a.book b " +
                "where b.id = :authorId", Reader.class);
        query.setParameter("authorId",authorId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }
}
