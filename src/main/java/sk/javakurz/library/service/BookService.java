package sk.javakurz.library.service;

import sk.javakurz.library.dto.BookDto;
import sk.javakurz.library.dto.NewBookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();

    void deleteBookWithId(Long id);

    BookDto createNewBook(NewBookDto newBookDto);

    //  BookDto createNewBook(NewBookDto newBookDto);
}
