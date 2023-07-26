package sk.javakurz.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthorDto(
        Long id,
        @NotBlank(message = "Meno autora knihy je povinné.")
        @Size(min = 3, max = 50)
        String name) {
}
