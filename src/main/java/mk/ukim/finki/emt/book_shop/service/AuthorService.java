package mk.ukim.finki.emt.book_shop.service;

import mk.ukim.finki.emt.book_shop.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

   Optional<Author> findById(Long id);

    List<Author> listAll();

    Optional<Author> create(Author author);
}
