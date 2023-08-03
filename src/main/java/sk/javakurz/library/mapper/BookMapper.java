package sk.javakurz.library.mapper;

import org.mapstruct.*;
import sk.javakurz.library.dto.AuthorDto;
import sk.javakurz.library.dto.BookDto;
import sk.javakurz.library.dto.BookFormDataDto;
import sk.javakurz.library.entity.Book;
import sk.javakurz.library.service.AuthorService;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public abstract class BookMapper {

    @Mapping(target = "authorDto", source = "author")
    public abstract BookDto bookToBookDto(Book book);

    public abstract List<BookDto> bookToBookDto(Iterable<Book> book);

    @Mapping(target = "author", source = "authorDto")
    @Mapping(target="checkouts", ignore = true)
    public abstract Book bookDtoToBook(BookDto bookDto);

    @Mapping(target = "author", source = "authorId", qualifiedByName = "authorIdToAuthor")
    @Mapping(target="checkouts", ignore = true)
    @Mapping(target="id", ignore = true)
    public abstract Book newBookDtoToBook(BookFormDataDto bookDto, @Context AuthorService authorService);

    @Mapping(target = "authorId", source = "author.id")
    public abstract BookFormDataDto bookToFormBookDto(Book book);

    @Mapping(target="id", ignore = true)
    @Mapping(target="checkouts", ignore = true)
    @Mapping(target = "author", source = "authorId", qualifiedByName = "authorIdToAuthor")
    public abstract void updateBookFromFormBookDto(@MappingTarget Book book, BookFormDataDto bookFormDataDto, @Context AuthorService authorService);

    @Named("authorIdToAuthor")
    public AuthorDto mapAuthorIdToAuthor(Long authorId, @Context AuthorService authorService) {
        return authorService.findAuthorById(authorId);
    }
}
