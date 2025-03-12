package mk.ukim.finki.wp.emtlabs1.service.impl;

import mk.ukim.finki.wp.emtlabs1.model.Author;
import mk.ukim.finki.wp.emtlabs1.model.Book;
import mk.ukim.finki.wp.emtlabs1.model.Category;
import mk.ukim.finki.wp.emtlabs1.repository.AuthorRepository;
import mk.ukim.finki.wp.emtlabs1.repository.BookRepository;
import mk.ukim.finki.wp.emtlabs1.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public Book create(String name, String category, Long authorId, Integer availableCopies) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Book book = new Book();
        book.setName(name);
        book.setCategory(Category.valueOf(category));
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, String name, String category, Long authorId, Integer availableCopies) {
        Book book = findById(id);
        book.setName(name);
        book.setCategory(Category.valueOf(category));
        book.setAvailableCopies(availableCopies);
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void markAsRented(Long id) {
        Book book = findById(id);
        if (book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookRepository.save(book);
        }
    }
}

