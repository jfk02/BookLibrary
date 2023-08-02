package sk.javakurz.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorFormDataDto {
    private Long id;

    @NotBlank(message = "Meno autora je povinný údaj.")
    @Size(min = 3, max = 50)
    private String name;
};
