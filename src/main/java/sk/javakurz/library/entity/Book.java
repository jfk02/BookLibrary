package sk.javakurz.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Názov knihy je povinný.")
    @Size(min = 3, max = 50)
    private String title;

    @NotBlank(message = "ISBN je povinné.")
    @Size(min = 3, max = 15)
    private String isbn;

    @Positive(message = "Rok vydania knihy je povinný.")
    private Integer publishedYear;

    @Positive(message = "Počet strán knihy je povinný.")
    private Integer pages;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Checkout> checkouts;
}
