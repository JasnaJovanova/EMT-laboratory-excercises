package mk.ukim.finki.wp.emtlabs1.controller;

import mk.ukim.finki.wp.emtlabs1.model.Book;
import mk.ukim.finki.wp.emtlabs1.model.Category;
import mk.ukim.finki.wp.emtlabs1.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.listAll();
    }

    @PostMapping
    public Book createBook(@RequestParam String name,
                           @RequestParam String category,
                           @RequestParam Long authorId,
                           @RequestParam Integer availableCopies) {
        return bookService.create(name, category, authorId, availableCopies);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestParam String name,
                           @RequestParam String category,
                           @RequestParam Long authorId,
                           @RequestParam Integer availableCopies) {
        return bookService.update(id, name, category, authorId, availableCopies);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PutMapping("/{id}/rent")
    public void markAsRented(@PathVariable Long id) {
        bookService.markAsRented(id);
    }
}