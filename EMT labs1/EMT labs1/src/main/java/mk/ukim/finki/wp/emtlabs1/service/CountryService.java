package mk.ukim.finki.wp.emtlabs1.service;

import mk.ukim.finki.wp.emtlabs1.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();
    Country findById(Long id);
    Country create(String name, String continent);
    void delete(Long id);
}
