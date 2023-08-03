package sk.javakurz.library.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;
import sk.javakurz.library.entity.Author;

import java.util.Optional;

public record BookDto(
        Long id,
        String title,
        String isbn,
        Integer publishedYear,
        Integer pages,
        AuthorDto authorDto) {
}
