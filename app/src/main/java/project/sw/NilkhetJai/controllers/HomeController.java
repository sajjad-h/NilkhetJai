package project.sw.NilkhetJai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.sw.NilkhetJai.models.Books;
import project.sw.NilkhetJai.service.BooksService;

@Controller
public class HomeController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        System.out.println("Hi, you are in /home");
        return "home/index";
    }

    @GetMapping("/addBook")
    public String addBook() {
        return "book/add-book";
    }

    @PostMapping("/addBook")
    public String addBookPost(
            @RequestParam(name = "name", required = true, defaultValue = "") String bookName,
            @RequestParam(name = "language", required = true, defaultValue = "") String language,
            @RequestParam(name = "type", required = true, defaultValue = "") String bookType,
            @RequestParam(name = "writterName", required = true, defaultValue = "") String writterName) {

        Books books = new Books();
        books.setLanguage(language);
        books.setName(bookName);
        books.setType(bookType);
        books.setWriteName(writterName);
        booksService.save(books);
        System.out.println("Book added");

        return "book/success";
    }
}
