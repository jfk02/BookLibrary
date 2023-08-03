package sk.javakurz.library.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.javakurz.library.dto.BookDto;
import sk.javakurz.library.dto.BookFormDataDto;
import sk.javakurz.library.entity.Book;
import sk.javakurz.library.exception.ResourceNotFoundException;
import sk.javakurz.library.mapper.BookMapper;
import sk.javakurz.library.repository.BookRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorService authorService;

    @Override
    public BookDto createBook(BookFormDataDto bookFormDataDto) {
        Book book = bookMapper.newBookDtoToBook(bookFormDataDto, authorService);
        Book savedBook = bookRepository.save(book);
        return bookMapper.bookToBookDto(savedBook);
    }

    @Override
    public List<BookDto> getAllBooks() {
        var allBooks = bookRepository.findAll();
        return bookMapper.bookToBookDto(allBooks);
    }

    @Override
    public BookFormDataDto findBookByIdForForm(Long bookId) {
        var book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book s ID: " + bookId + " neexistuje!"));
        return bookMapper.bookToFormBookDto(book);
    }

    @Override
    public BookDto updateBook(BookFormDataDto updatedBook) {
        var book = bookRepository.findById(updatedBook.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book s ID: " + updatedBook.getId() + " neexistuje!"));
        bookMapper.updateBookFromFormBookDto(book, updatedBook, authorService);
        Book savedBook = bookRepository.save(book);
        return bookMapper.bookToBookDto(savedBook);
    }

    @Override
    public void deleteBookWithId(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
