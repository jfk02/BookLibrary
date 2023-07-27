package sk.javakurz.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewBookDto {
    private String title;
    private String isbn;
    private Integer publishedYear;

    private Integer pages;
    private AuthorDto authorDto;
}
