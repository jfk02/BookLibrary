package sk.javakurz.library.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sk.javakurz.library.dto.AuthorDto;
import sk.javakurz.library.dto.BookDto;
import sk.javakurz.library.dto.NewBookDto;
import sk.javakurz.library.entity.Book;
import sk.javakurz.library.service.AuthorService;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public interface BookMapper {

    @Mapping(target = "authorDto", source = "author")
    BookDto bookToBookDto(Book book);

    List<BookDto> bookToBookDto(Iterable<Book> book);

    @Mapping(target = "author", source = "authorDto")
    @Mapping(target="checkouts", ignore = true)
    Book bookDtoToBook(BookDto bookDto);

    List<Book> bookDtoToBook(Iterable<BookDto> bookDto);

    @Mapping(target = "author", source = "authorId", qualifiedByName = "authorIdToAuthor")
    @Mapping(target="checkouts", ignore = true)
    @Mapping(target="id", ignore = true)
    Book newBookDtoToBook(NewBookDto bookDto, @Context AuthorService authorService);

    @Named("authorIdToAuthor")
    default AuthorDto mapAuthorIdToAuthor(Long authorId, @Context AuthorService authorService) {
        return authorService.findAuthorById(authorId);
    }
}
