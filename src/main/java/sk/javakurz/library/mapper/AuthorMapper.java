package sk.javakurz.library.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import sk.javakurz.library.dto.AuthorDto;
import sk.javakurz.library.dto.AuthorFormDataDto;
import sk.javakurz.library.entity.Author;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AuthorMapper {

    public abstract AuthorDto authorToAuthorDto(Author author);

    public abstract List<AuthorDto> authorToAuthorDto(Iterable<Author> author);

    @Mapping(target = "booksCount", ignore = true)
    @Mapping(target = "books", ignore = true)
    public abstract Author authorDtoToAuthor(AuthorDto authorDto);

    @Mapping(target="id", ignore = true)
    @Mapping(target="booksCount", ignore = true)
    @Mapping(target="books", ignore = true)
    public abstract Author newAuthorDtoToAuthor(AuthorFormDataDto authorFormDataDto);

    public abstract AuthorFormDataDto authorToFormAuthorDto(Author author);

    @Mapping(target="id", ignore = true)
    @Mapping(target = "booksCount", ignore = true)
    @Mapping(target = "books", ignore = true)
    public abstract void updateAuthorFromFormAuthorDto(@MappingTarget Author author, AuthorFormDataDto authorFormDataDto);
}
