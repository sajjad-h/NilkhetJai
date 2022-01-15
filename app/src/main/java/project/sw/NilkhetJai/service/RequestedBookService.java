package project.sw.NilkhetJai.service;

import java.util.List;
import java.util.Optional;

import project.sw.NilkhetJai.models.RequestedBook;

public interface RequestedBookService {
    /**
     * To save requestedBook object in database
     * 
     * @param requestedBook
     */
    void save(RequestedBook requestedBook);

    /**
     * To find a requestedBook object from database
     * 
     * @param id
     * @return
     */

    Optional<RequestedBook> findById(Long id);

    /**
     * To find all requestedBook objects from database
     * 
     * @return
     */

    List<RequestedBook> findAll();
}
