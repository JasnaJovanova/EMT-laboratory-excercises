package mk.ukim.finki.wp.emtlabs1.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.emtlabs1.model.Author;
import mk.ukim.finki.wp.emtlabs1.model.Country;
import mk.ukim.finki.wp.emtlabs1.repository.AuthorRepository;
import mk.ukim.finki.wp.emtlabs1.repository.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init(){
        countryRepository.save(new Country("Belgium", "Europe"));
        countryRepository.save(new Country("France", "Europe"));
        countryRepository.save(new Country("Italy", "Europe"));

        authorRepository.save(new Author("Steven", "Smith", countryRepository.findById(1L).orElse(null)));
        authorRepository.save(new Author("Maria", "Kiri",countryRepository.findById(1L).orElse(null)));
        authorRepository.save(new Author("Anna", "Gru",countryRepository.findById(1L).orElse(null)));

    }
}
