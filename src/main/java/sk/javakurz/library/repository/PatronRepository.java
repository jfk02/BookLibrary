package sk.javakurz.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.javakurz.library.entity.Patron;

public interface PatronRepository extends JpaRepository<Patron, Long> {
}
