package project.sw.NilkhetJai.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import project.sw.NilkhetJai.models.Books;

public interface BooksRepository extends CrudRepository<Books, Long> {
    Optional<Books> findById(String id);
}
