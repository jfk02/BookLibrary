package sk.javakurz.library.dto;

import sk.javakurz.library.entity.Book;
import sk.javakurz.library.entity.Patron;
import java.util.Date;

public record CheckoutDto(
        Long id,
        Date startDate,
        Date endDate,
        boolean isReturned,
        Book book,
        Patron patron) {
}
