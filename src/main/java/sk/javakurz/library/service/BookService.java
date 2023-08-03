package sk.javakurz.library.service;

import sk.javakurz.library.dto.BookDto;
import sk.javakurz.library.dto.BookFormDataDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();

    BookFormDataDto findBookByIdForForm(Long bookId);

    BookDto updateBook(BookFormDataDto updatedBook);

    void deleteBookWithId(Long id);

    BookDto createBook(BookFormDataDto bookFormDataDto);
}
