package org.example.repository;

import org.example.entity.Author;

public interface AuthorRepository {
    String saveAuthor(Author author);
    void updateAuthor(Long id, Author author);
    Author getAuthorById(Long id);
    String getAuthorByPublisherId(Long publisherId);
    void deleteAuthorById(Long id);
    String assignAuthorToPublisher(Long authorId, Long publisherId);

}
