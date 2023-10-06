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
import sk.javakurz.library.dto.PatronFormDataDto;
import sk.javakurz.library.service.PatronService;

@Controller
public class PatronController {

    @Autowired
    private PatronService patronService;

    @GetMapping("/all-patrons")
    public String showAllPatrons(Model model) {
        model.addAttribute("patrons", patronService.getAllPatrons());
        return "patrons";
    }

    @GetMapping("/deletePatronWithId/{id}")
    public String deletePatronWithId(@PathVariable(value = "id") Long id) {
        patronService.deletePatronWithId(id);
        return "redirect:/all-patrons";
    }

    @GetMapping("/add-patron")
    public String addPatron(Model model) {
        var newPatronDto = new PatronFormDataDto();
        newPatronDto.setId((long) -1);
        model.addAttribute("patronDto", newPatronDto);
        return "patron-form";
    }

    @GetMapping("/update-patron/{id}")
    public String updatePatronWithId(@PathVariable(value = "id") long patronId, Model model) {
        var patronDto = patronService.findPatronById(patronId);
        model.addAttribute("patronDto", patronDto);
        return "patron-form";
    }

    @PostMapping("/patron-input-data")
    public String newPatron(@Valid @ModelAttribute("patronDto") PatronFormDataDto patronFormDataDto,
                            BindingResult bindingResult) {
        String result;
        if (bindingResult.hasErrors()) {
            result = "/add-patron";
        } else {
            if (patronFormDataDto.getId() == -1) {
                patronService.createPatron(patronFormDataDto);
                result = "redirect:/add-patron";
            } else {
                patronService.updatePatron(patronFormDataDto);
                result = "redirect:/all-patrons";
            }
        }
        return result;
    }
}
