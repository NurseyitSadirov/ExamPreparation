package org.example.service.impl;

import org.example.entity.Author;
import org.example.repository.AuthorRepository;
import org.example.repository.impl.AuthorRepositoryImpl;
import org.example.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {
    AuthorRepository authorRepository = new AuthorRepositoryImpl();
    @Override
    public String saveAuthor(Author author) {
        return authorRepository.saveAuthor(author);
    }

    @Override
    public void updateAuthor(Long id, Author author) {
        authorRepository.updateAuthor(id,author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.getAuthorById(id);
    }

    @Override
    public String getAuthorByPublisherId(Long publisherId) {
        return authorRepository.getAuthorByPublisherId(publisherId);
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorRepository.deleteAuthorById(id);
    }

    @Override
    public String assignAuthorToPublisher(Long authorId, Long publisherId) {
        return authorRepository.assignAuthorToPublisher(authorId,publisherId);
    }
}
