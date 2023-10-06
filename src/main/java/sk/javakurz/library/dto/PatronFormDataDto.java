package sk.javakurz.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatronFormDataDto {
    private Long id;

    @NotBlank(message = "Meno čitateľa je povinný údaj.")
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank(message = "Adresa je povinný údaj.")
    @Size(min = 3, max = 100)
    private String address;
};
