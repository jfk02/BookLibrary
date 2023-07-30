package sk.javakurz.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewAuthorDto {
    @NotBlank(message = "Meno autora je povinný údaj.")
    @Size(min = 3, max = 50)
    public String name;
}
