package mk.ukim.finki.wp.emtlabs1.service;

import mk.ukim.finki.wp.emtlabs1.model.BookRental;

import java.util.List;

public interface BookRentalService {
    void rentBook(Long bookId, String userName);
    List<String> getRentersByBookId(Long bookId);
}
