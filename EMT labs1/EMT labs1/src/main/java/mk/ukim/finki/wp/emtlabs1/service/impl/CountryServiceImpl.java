package mk.ukim.finki.wp.emtlabs1.service.impl;

import mk.ukim.finki.wp.emtlabs1.model.Country;
import mk.ukim.finki.wp.emtlabs1.repository.CountryRepository;
import mk.ukim.finki.wp.emtlabs1.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
    }

    @Override
    public Country create(String name, String continent) {
        return null;
    }

//    @Override
//    public Country create(String name, String continent) {
//        Country country = new Country(name, continent);
//        return countryRepository.save(country);
//    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}

