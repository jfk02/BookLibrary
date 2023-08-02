package sk.javakurz.library.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.javakurz.library.dto.AuthorDto;
import sk.javakurz.library.dto.AuthorFormDataDto;
import sk.javakurz.library.entity.Author;
import sk.javakurz.library.exception.ResourceNotFoundException;
import sk.javakurz.library.mapper.AuthorMapper;
import sk.javakurz.library.repository.AuthorRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorDto createAuthor(AuthorFormDataDto authorFormDataDto) {
        Author author = authorMapper.newAuthorDtoToAuthor(authorFormDataDto);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.authorToAuthorDto(savedAuthor);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        var allAuthors = authorRepository.findAll();
        return authorMapper.authorToAuthorDto(allAuthors);
    }

    @Override
    public AuthorDto findAuthorById(Long authorId) {
        var author = authorRepository.findById(authorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Autor s ID: " + authorId + " neexistuje!"));
        return authorMapper.authorToAuthorDto(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorFormDataDto updatedAuthor) {
        var author = authorRepository.findById(updatedAuthor.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Autor s ID: " + updatedAuthor.getId() + " neexistuje!"));
        authorMapper.updateAuthorFromFormAuthorDto(author, updatedAuthor);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.authorToAuthorDto(savedAuthor);
    }

    @Override
    public void deleteAuthorWithId(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
