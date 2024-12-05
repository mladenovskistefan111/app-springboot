package mk.ukim.finki.emt.book_shop.service.impl;

import mk.ukim.finki.emt.book_shop.model.Author;
import mk.ukim.finki.emt.book_shop.model.Country;
import mk.ukim.finki.emt.book_shop.model.exception.AuthorNotFoundException;
import mk.ukim.finki.emt.book_shop.model.exception.CountryNotFoundException;
import mk.ukim.finki.emt.book_shop.repository.AuthorRepository;
import mk.ukim.finki.emt.book_shop.repository.CountryRepository;
import mk.ukim.finki.emt.book_shop.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

        private final AuthorRepository authorRepository;
        private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.of(this.authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id)));
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> create(Author author) {
    return Optional.of(author);
    }
}
