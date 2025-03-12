package mk.ukim.finki.wp.emtlabs1.service;

import mk.ukim.finki.wp.emtlabs1.model.Book;
import mk.ukim.finki.wp.emtlabs1.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> listAll();
    Book findById(Long id);
    Book create(String name, String category, Long authorId, Integer availableCopies);
    Book update(Long id, String name, String category, Long authorId, Integer availableCopies);
    void delete(Long id);
    void markAsRented(Long id);

}

