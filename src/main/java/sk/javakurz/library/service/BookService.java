package sk.javakurz.library.service;

import sk.javakurz.library.dto.BookDto;
import sk.javakurz.library.dto.BookFormDataDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();

    void deleteBookWithId(Long id);

    BookDto createNewBook(BookFormDataDto bookFormDataDto);

    //  BookDto createNewBook(NewBookDto newBookDto);
}
