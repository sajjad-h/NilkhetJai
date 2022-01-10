package project.sw.NilkhetJai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import project.sw.NilkhetJai.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findById(Long id);

    List<Book> findAll();
}
