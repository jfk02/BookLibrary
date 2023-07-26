package sk.javakurz.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.javakurz.library.entity.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
}
