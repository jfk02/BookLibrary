package sk.javakurz.library.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.javakurz.library.dto.BookDto;
import sk.javakurz.library.dto.BookFormDataDto;
import sk.javakurz.library.entity.Book;
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
    public List<BookDto> getAllBooks() {
        var allBooks = bookRepository.findAll();
        return bookMapper.bookToBookDto(allBooks);
    }

    @Override
    public void deleteBookWithId(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public BookDto createNewBook(BookFormDataDto bookFormDataDto) {
        Book book = bookMapper.newBookDtoToBook(bookFormDataDto, authorService);
        Book savedBook = bookRepository.save(book);
        return bookMapper.bookToBookDto(savedBook);
    }
}
