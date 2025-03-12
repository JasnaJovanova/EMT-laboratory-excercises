package mk.ukim.finki.wp.emtlabs1.service;

import mk.ukim.finki.wp.emtlabs1.model.Author;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findById(Long id);
    Author create(String name, String surname, Long countryId);
    void delete(Long id);

}

