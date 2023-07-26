package sk.javakurz.library.service;

import sk.javakurz.library.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);

    List<AuthorDto> getAllAuthors();

    void deleteAuthorWithId(Long id);
}
