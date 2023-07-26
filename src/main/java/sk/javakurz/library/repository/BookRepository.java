package sk.javakurz.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.javakurz.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
