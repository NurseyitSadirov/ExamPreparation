package org.example.repository;

import org.example.entity.Author;
import org.example.entity.Book;

public interface BookRepository {
    String saveBook(Book book);
    void updateBookAuthor(Long bookId, Author author);
    String getBookAndPublisherBookId();
    void deleteBookByAuthorId(Long id);
}
