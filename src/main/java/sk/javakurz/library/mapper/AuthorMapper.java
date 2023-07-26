package sk.javakurz.library.mapper;

import org.mapstruct.Mapper;
import sk.javakurz.library.dto.AuthorDto;
import sk.javakurz.library.entity.Author;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto authorToAuthorDto(Author author);

    List<AuthorDto> authorToAuthorDto(Iterable<Author> author);

    Author authorDtoToAuthor(AuthorDto authorDto);

    List<Author> authorDtoToAuthor(Iterable<AuthorDto> authorDto);

}
