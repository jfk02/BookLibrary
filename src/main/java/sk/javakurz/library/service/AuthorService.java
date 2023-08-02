package sk.javakurz.library.service;

import sk.javakurz.library.dto.AuthorDto;
import sk.javakurz.library.dto.AuthorFormDataDto;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(AuthorFormDataDto authorFormDataDto);

    List<AuthorDto> getAllAuthors();

    AuthorDto findAuthorById(Long authorId);

    AuthorDto updateAuthor(AuthorFormDataDto updatedAuthor);

    void deleteAuthorWithId(Long id);
}
