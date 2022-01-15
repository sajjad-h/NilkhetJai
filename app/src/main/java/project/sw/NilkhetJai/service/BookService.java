package project.sw.NilkhetJai.service;

import java.util.List;
import java.util.Optional;

import project.sw.NilkhetJai.models.Book;

public interface BookService {
    /**
     * To save book object in book table
     * 
     * @param book
     */
    void save(Book book);

    /**
     * To find by id form book table
     * 
     * @param bookId
     * @return
     */

    Optional<Book> findById(Long bookId);

    /**
     * To find all object from book table
     * 
     * @return
     */
    List<Book> findAll();

}
