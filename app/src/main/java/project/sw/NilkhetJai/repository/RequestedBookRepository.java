package project.sw.NilkhetJai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import project.sw.NilkhetJai.models.RequestedBook;

public interface RequestedBookRepository extends CrudRepository<RequestedBook, Long> {

    /**
     * To find a requestedBook object from database
     */
    Optional<RequestedBook> findById(Long id);

    /**
     * To find all requestedBook objects from database
     * 
     */

    List<RequestedBook> findAll();

}
