package sk.javakurz.library.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.javakurz.library.dto.AuthorDto;
import sk.javakurz.library.entity.Author;
import sk.javakurz.library.mapper.AuthorMapper;
import sk.javakurz.library.repository.AuthorRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class AuthorServiceImpl  implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = authorMapper.authorDtoToAuthor(authorDto);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.authorToAuthorDto(savedAuthor);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        var allAuthors = authorRepository.findAll();
        return authorMapper.authorToAuthorDto(allAuthors);
    }

    @Override
    public void deleteAuthorWithId(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
