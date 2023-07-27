package sk.javakurz.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sk.javakurz.library.dto.BookDto;
import sk.javakurz.library.dto.NewBookDto;
import sk.javakurz.library.service.AuthorService;
import sk.javakurz.library.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public String backToHome() {
        return "index";
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

    @PostMapping("/new-book")
    public String newBook(@ModelAttribute("bookDto") NewBookDto bookDto) {
        //bookService.createBook(bookDto);
        return "redirect:/all-books";
    }

    @GetMapping("/add-book")
    public String addBook(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("bookDto", new NewBookDto());
        return "create-book";
    }
}
