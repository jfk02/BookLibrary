package sk.javakurz.library.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import sk.javakurz.library.entity.Book;
import sk.javakurz.library.entity.Patron;

import java.util.Date;
import java.util.Optional;

public record CheckoutDto(
        Long id,
        @NotNull
        @FutureOrPresent(message = "Dátum výpožičky nemôže byť v minulosti.")
        Date startDate,
        Date endDate,
        boolean isReturned,
        Book book,
        Patron patron) {
}
