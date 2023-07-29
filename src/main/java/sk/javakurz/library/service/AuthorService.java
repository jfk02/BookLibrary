package sk.javakurz.library.service;

import sk.javakurz.library.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);

    List<AuthorDto> getAllAuthors();

    AuthorDto findAuthorById(Long authorId);

    void deleteAuthorWithId(Long id);
}
