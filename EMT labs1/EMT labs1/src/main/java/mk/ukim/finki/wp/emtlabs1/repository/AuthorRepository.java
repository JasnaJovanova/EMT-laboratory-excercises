package mk.ukim.finki.wp.emtlabs1.repository;

import mk.ukim.finki.wp.emtlabs1.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
