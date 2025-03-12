package mk.ukim.finki.wp.emtlabs1.repository;

import mk.ukim.finki.wp.emtlabs1.model.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRentalRepository extends JpaRepository<BookRental, Long> {
    List<BookRental> findByBookId(Long bookId);  // Го наоѓаат сите записи за дадена книга
}

