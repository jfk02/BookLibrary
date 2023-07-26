package sk.javakurz.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.javakurz.library.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
