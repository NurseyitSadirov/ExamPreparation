package org.example.service;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Reader;

public interface ReaderService {

    String saveReader(Reader reader);
    String updateReader(Long id, Reader reader);
    Book getReaderByBookId(Long bookId);
    void deleteReaderById(Long id);
    Reader getReaderByAuthorId(Long authorId);
}
