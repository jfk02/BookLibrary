package sk.javakurz.library.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.javakurz.library.dto.BookDto;
import sk.javakurz.library.entity.Book;

import java.util.List;
@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public interface BookMapper {
    @Mapping(target = "authorDto", source = "author")
    BookDto bookToBookDto(Book book);

    List<BookDto> bookToBookDto(Iterable<Book> book);

    @Mapping(target = "author", source = "authorDto")
    Book bookDtoToBook(BookDto bookDto);

    List<Book> bookDtoToBook(Iterable<BookDto> bookDto);
}
