package project.sw.NilkhetJai.controllers;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
            @RequestParam("filedata") MultipartFile multipartFile,
            @RequestParam(name = "name", required = true, defaultValue = "") String bookName,
            @RequestParam(name = "language", required = true, defaultValue = "") String language,
            @RequestParam(name = "type", required = true, defaultValue = "") String bookType,
            @RequestParam(name = "writterName", required = true, defaultValue = "") String writterName)
            throws IOException {

        Books books = new Books();
        books.setLanguage(language);
        books.setName(bookName);
        books.setType(bookType);
        books.setWriteName(writterName);

        byte[] bytes = multipartFile.getBytes();
        String encodedFileData = Base64.getEncoder().encodeToString(bytes);

        books.setFileType(multipartFile.getContentType());
        books.setFileData(encodedFileData);
        booksService.save(books);
        System.out.println("Book added " + books.getFileType() + " " +
                encodedFileData);

        return "book/success";
    }
}
