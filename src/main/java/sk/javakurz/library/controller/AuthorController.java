package sk.javakurz.library.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.javakurz.library.dto.AuthorFormDataDto;
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
    public String deleteAuthorWithId(@PathVariable(value = "id") Long id) {
        authorService.deleteAuthorWithId(id);
        return "redirect:/all-authors";
    }

    @GetMapping("/add-author")
    public String addAuthor(Model model) {
        var newAuthorDto = new AuthorFormDataDto();
        newAuthorDto.setId((long) -1);
        model.addAttribute("authorDto", newAuthorDto);
        return "author-form";
    }

    @GetMapping("/update-author/{id}")
    public String updateAuthorWithId(@PathVariable(value = "id") long authorId, Model model) {
        var authorDto = authorService.findAuthorById(authorId);
        model.addAttribute("authorDto", authorDto);
        return "author-form";
    }

    @PostMapping("/author-input-data")
    public String newAuthor(@Valid @ModelAttribute("authorDto") AuthorFormDataDto authorFormDataDto,
                            BindingResult bindingResult) {
        String result;
        if (bindingResult.hasErrors()) {
            result = "/add-author";
        } else {
            if (authorFormDataDto.getId() == -1) {
                authorService.createAuthor(authorFormDataDto);
                result = "redirect:/add-author";
            } else {
                authorService.updateAuthor(authorFormDataDto);
                result = "redirect:/all-authors";
            }
        }
        return result;
    }
}
