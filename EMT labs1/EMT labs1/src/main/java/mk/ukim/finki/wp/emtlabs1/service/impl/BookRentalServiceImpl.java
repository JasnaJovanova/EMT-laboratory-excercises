package mk.ukim.finki.wp.emtlabs1.service.impl;

import mk.ukim.finki.wp.emtlabs1.model.BookRental;
import mk.ukim.finki.wp.emtlabs1.repository.BookRentalRepository;
import mk.ukim.finki.wp.emtlabs1.service.BookRentalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookRentalServiceImpl implements BookRentalService {
    private final BookRentalRepository bookRentalRepository;

    public BookRentalServiceImpl(BookRentalRepository bookRentalRepository) {
        this.bookRentalRepository = bookRentalRepository;
    }

    @Override
    public void rentBook(Long bookId, String userName) {
        BookRental rental = new BookRental(bookId, userName);
        bookRentalRepository.save(rental);
    }

    @Override
    public List<String> getRentersByBookId(Long bookId) {
        return bookRentalRepository.findByBookId(bookId)  // Ги земаме сите записи за таа книга
                .stream()
                .map(BookRental::getUserName)  // Вадиме само имиња од објектите
                .collect(Collectors.toList()); // Ги враќаме како листа
    }
}
