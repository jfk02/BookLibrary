package sk.javakurz.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.NonNull;

public record PatronDto(
        Long id,
        @NotBlank(message = "Meno čitateľa je povinný údaj.")
        @Size(min = 3, max = 50)
        String name,
        @NotBlank(message = "Adresa bydliska čitateľa je povinný údaj.")
        @Size(min = 3, max = 100)
        String address) {
}
