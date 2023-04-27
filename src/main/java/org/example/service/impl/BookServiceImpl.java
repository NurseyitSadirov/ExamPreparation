package org.example.service.impl;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.example.repository.impl.BookRepositoryImpl;
import org.example.service.BookService;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository = new BookRepositoryImpl();
    @Override
    public String saveBook(Book book) {
        return bookRepository.saveBook(book);
    }

    @Override
    public void updateBookAuthor(Long bookId, Author author) {
        bookRepository.updateBookAuthor(bookId,author);
    }

    @Override
    public String getBookAndPublisherBookId() {
        return bookRepository.getBookAndPublisherBookId();
    }

    @Override
    public void deleteBookByAuthorId(Long id) {
        bookRepository.deleteBookByAuthorId(id);
    }
}
