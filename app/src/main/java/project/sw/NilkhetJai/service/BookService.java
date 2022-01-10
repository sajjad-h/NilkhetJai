package project.sw.NilkhetJai.service;

import java.util.List;
import java.util.Optional;

import project.sw.NilkhetJai.models.Book;

public interface BookService {
    void save(Book books);

    Optional<Book> findById(Long id);

    List<Book> findAll();

}
