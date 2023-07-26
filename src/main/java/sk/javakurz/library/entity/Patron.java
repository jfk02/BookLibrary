package sk.javakurz.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "patrons")
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Meno čitateľa je povinný údaj.")
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank(message = "Adresa bydliska čitateľa je povinný údaj.")
    @Size(min = 3, max = 100)
    private String address;

    @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL)
    private List<Checkout> checkouts;
}
