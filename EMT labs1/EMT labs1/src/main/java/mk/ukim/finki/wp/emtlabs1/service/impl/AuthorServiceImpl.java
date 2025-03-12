package mk.ukim.finki.wp.emtlabs1.service.impl;

import mk.ukim.finki.wp.emtlabs1.model.Author;
import mk.ukim.finki.wp.emtlabs1.model.Country;
import mk.ukim.finki.wp.emtlabs1.repository.AuthorRepository;
import mk.ukim.finki.wp.emtlabs1.repository.CountryRepository;
import mk.ukim.finki.wp.emtlabs1.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public Author create(String name, String surname, Long countryId) {
        return null;
    }

//    @Override
//    public Author create(String name, String surname, Long countryId) {
//        Country country = countryRepository.findById(countryId)
//                .orElseThrow(() -> new RuntimeException("Country not found"));
//        Author author = new Author(name, surname, country);
//        return authorRepository.save(author);
//    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

}
