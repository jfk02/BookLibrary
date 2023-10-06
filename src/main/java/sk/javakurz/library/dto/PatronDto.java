package sk.javakurz.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.NonNull;

public record PatronDto(
        Long id,
        String name,
        String address) {
}
