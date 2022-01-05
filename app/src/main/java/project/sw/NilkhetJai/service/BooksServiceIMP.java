package project.sw.NilkhetJai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.sw.NilkhetJai.models.Books;
import project.sw.NilkhetJai.repository.BooksRepository;

@Service
public class BooksServiceIMP implements BooksService {
    @Autowired
    BooksRepository booksRepository;

    @Override
    public void save(Books books) {
        booksRepository.save(books);
    }

    @Override
    public Optional<Books> findById(Long id) {
        return booksRepository.findById(id);
    }
}
