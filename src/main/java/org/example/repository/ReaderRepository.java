package org.example.repository;

import org.example.entity.Book;
import org.example.entity.Reader;

public interface ReaderRepository {
    String saveReader(Reader reader);
    String updateReader(Long id, Reader reader);
    Book getReaderByBookId(Long bookId);
    void deleteReaderById(Long id);
    Reader getReaderByAuthorId(Long authorId);
}
