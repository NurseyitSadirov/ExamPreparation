package org.example.service.impl;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Reader;
import org.example.repository.ReaderRepository;
import org.example.repository.impl.ReaderRepositoryImpl;
import org.example.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    ReaderRepository repository = new ReaderRepositoryImpl();
    @Override
    public String saveReader(Reader reader) {
        return repository.saveReader(reader);
    }

    @Override
    public String updateReader(Long id, Reader reader) {
        return repository.updateReader(id,reader);
    }

    @Override
    public Book getReaderByBookId(Long bookId) {
        return repository.getReaderByBookId(bookId);
    }

    @Override
    public void deleteReaderById(Long id) {
        repository.deleteReaderById(id);
    }

    @Override
    public Reader getReaderByAuthorId(Long authorId) {
        return repository.getReaderByAuthorId(authorId);
    }
}
