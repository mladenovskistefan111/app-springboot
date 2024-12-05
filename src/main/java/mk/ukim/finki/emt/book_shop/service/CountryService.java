package mk.ukim.finki.emt.book_shop.service;

import mk.ukim.finki.emt.book_shop.model.Country;
import mk.ukim.finki.emt.book_shop.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

public interface CountryService {

   Country findById(Long id);

    List<Country> listAll();

    Country create(Country country);
}
