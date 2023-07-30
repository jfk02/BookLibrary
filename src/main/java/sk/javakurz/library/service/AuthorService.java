package sk.javakurz.library.service;

import sk.javakurz.library.dto.AuthorDto;
import sk.javakurz.library.dto.NewAuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(NewAuthorDto newAuthorDto);

    List<AuthorDto> getAllAuthors();

    AuthorDto findAuthorById(Long authorId);

    void deleteAuthorWithId(Long id);
}
