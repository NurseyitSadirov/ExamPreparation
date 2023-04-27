package org.example.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.config.HibernateConfig;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.repository.BookRepository;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveBook(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        return book.getName() + " is saved";
    }

    @Override
    public void updateBookAuthor(Long bookId, Author author) {
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, bookId);
        book.setAuthor(author);
        entityManager.merge(book);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public String getBookAndPublisherBookId() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select c from Book c join Publisher p on c.id = p.id");
        List resultList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList.size() +" successfully get id";
    }

    @Override
    public void deleteBookByAuthorId(Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select b from Book  b join b.author a where a.id = :id");
        List<Book> books = query.getResultList();
        for (Book book : books) {
            entityManager.remove(book);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
