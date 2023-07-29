package sk.javakurz.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthorDto(
        Long id,
        String name,
        Integer booksCount) {
}
