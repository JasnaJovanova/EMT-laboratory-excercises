package mk.ukim.finki.wp.emtlabs1.controller;

import mk.ukim.finki.wp.emtlabs1.service.BookRentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
@CrossOrigin(origins = "http://localhost:3000")
public class BookRentalController {
    private final BookRentalService bookRentalService;

    public BookRentalController(BookRentalService bookRentalService) {
        this.bookRentalService = bookRentalService;
    }

    // POST e za iznjami kniga
    @PostMapping("/rent")
    public ResponseEntity<Void> rentBook(@RequestParam Long bookId, @RequestParam String userName) {
        bookRentalService.rentBook(bookId, userName);
        return ResponseEntity.ok().build();
    }

    // GET gi vrakja site sto ja iznajmile
    @GetMapping("/{bookId}")
    public ResponseEntity<List<String>> getRentersByBookId(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookRentalService.getRentersByBookId(bookId));
    }
}
