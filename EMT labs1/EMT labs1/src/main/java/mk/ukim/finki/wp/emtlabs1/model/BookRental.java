package mk.ukim.finki.wp.emtlabs1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class BookRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;
    private String userName; // Корисникот што ја изнајмил книгата

    public BookRental(Long bookId, String userName) {
        this.bookId = bookId;
        this.userName = userName;
    }

    public BookRental() {

    }

    public Long getId() {
        return id;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getUserName() {
        return userName;
    }

}
