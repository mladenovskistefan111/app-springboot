package mk.ukim.finki.emt.book_shop.service.impl;

import mk.ukim.finki.emt.book_shop.model.Country;
import mk.ukim.finki.emt.book_shop.model.exception.CountryNotFoundException;
import mk.ukim.finki.emt.book_shop.repository.CountryRepository;
import mk.ukim.finki.emt.book_shop.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();

    }

    @Override
    public Country create(Country country) {
       return this.countryRepository.save(country);
    }
}
