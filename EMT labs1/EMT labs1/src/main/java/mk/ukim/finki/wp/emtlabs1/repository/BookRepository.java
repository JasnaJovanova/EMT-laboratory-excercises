package mk.ukim.finki.wp.emtlabs1.repository;

import mk.ukim.finki.wp.emtlabs1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
