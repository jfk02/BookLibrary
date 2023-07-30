package sk.javakurz.library.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.javakurz.library.dto.NewAuthorDto;
import sk.javakurz.library.dto.NewBookDto;
import sk.javakurz.library.service.AuthorService;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/all-authors")
    public String showAllAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

    @GetMapping("/deleteAuthorWithId/{id}")
    public String deleteAuthorWithId(@PathVariable(value="id") Long id) {
        authorService.deleteAuthorWithId(id);
        return "redirect:/all-authors";
    }

    @GetMapping("/add-author")
    public String addAuthor(Model model) {
        model.addAttribute("authorDto", new NewAuthorDto());
        return "create-author";
    }

    @PostMapping("/new-author")
    public String newAuthor(@ModelAttribute("authorDto") NewAuthorDto newAuthorDto) {
        authorService.createAuthor(newAuthorDto);
        return "redirect:/add-author";
    }
}
