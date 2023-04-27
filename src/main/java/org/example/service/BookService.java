package org.example.service;

import org.example.entity.Author;
import org.example.entity.Book;

public interface BookService {

    String saveBook(Book book);
    void updateBookAuthor(Long bookId, Author author);
    String getBookAndPublisherBookId();
    void deleteBookByAuthorId(Long id);
}
