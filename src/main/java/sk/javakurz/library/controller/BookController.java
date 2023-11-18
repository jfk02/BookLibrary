package sk.javakurz.library.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.javakurz.library.dto.BookFormDataDto;
import sk.javakurz.library.service.AuthorService;
import sk.javakurz.library.service.BookService;

@Controller
public class BookController {

    private final BookService bookService;

    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/all-books")
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/deleteBookWithId/{id}")
    public String deleteBookWithId(@PathVariable(value="id") Long id) {
        bookService.deleteBookWithId(id);
        return "redirect:/all-books";
    }

    @GetMapping("/add-book")
    public String addBook(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        var bookFormDataDto = new BookFormDataDto();
        bookFormDataDto.setId((long) -1);
        model.addAttribute("bookDto", bookFormDataDto);
        return "book-form";
    }

    @GetMapping("/update-book/{id}")
    public String updateBookWithId(@PathVariable(value = "id") long bookId, Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        var bookDto = bookService.findBookByIdForForm(bookId);
        model.addAttribute("bookDto", bookDto);
        return "book-form";
    }


    @PostMapping("/book-input-data")
    public String newBook(@Valid @ModelAttribute("bookDto") BookFormDataDto bookFormDataDto, BindingResult bindingResult) {
        String result;
        if (bindingResult.hasErrors()) {
            result = "/add-book";
        }else{
            if(bookFormDataDto.getId() == -1){
                bookService.createBook(bookFormDataDto);
                result = "redirect:/add-book";
            }else{
                bookService.updateBook(bookFormDataDto);
                result = "redirect:/all-books";
            }
        }
        return result;
    }
}
