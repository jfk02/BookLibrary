package sk.javakurz.library.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;
import sk.javakurz.library.entity.Author;

import java.util.Optional;

public record BookDto(
        Long id,
        @NotBlank(message = "Názov knihy je povinný.")
        @Size(min = 3, max = 50)
        String title,
        @NotBlank(message = "ISBN je povinné.")
        @Size(min = 3, max = 15)
        String isbn,
        @NotNull
        @Positive(message = "Rok vydania knihy musí byť väčší ako 0.")
        Integer publishedYear,
        @NotNull
        @Positive(message = "Počet strán knihy musí byť väčší ako 0.")
        Integer pages,
        AuthorDto authorDto) {
}
