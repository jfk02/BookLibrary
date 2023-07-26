package sk.javakurz.library.service;

import sk.javakurz.library.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);

    List<BookDto> getAllBooks();

    void deleteBookWithId(Long id);
}
