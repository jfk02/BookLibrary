package sk.javakurz.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewBookDto {
    @NotBlank(message = "Názov knihy je povinný.")
    @Size(min = 3, max = 50)
    private String title;

    @NotBlank(message = "ISBN je povinné.")
    @Size(min = 3, max = 15)
    private String isbn;

    @NotNull
    @Positive(message = "Rok vydania knihy musí byť väčší ako 0.")
    private Integer publishedYear;

    @Positive(message = "Počet strán knihy musí byť väčší ako 0.")
    private Integer pages;

    @NotNull(message = "Autor musí byť vybraný.")
    private Long authorId;
}
