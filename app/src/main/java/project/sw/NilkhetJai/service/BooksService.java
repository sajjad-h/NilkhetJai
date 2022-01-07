package project.sw.NilkhetJai.service;

import java.util.Optional;

import project.sw.NilkhetJai.models.Books;

public interface BooksService {
    void save(Books books);

    Optional<Books> findById(Long id);

}
