package project.sw.NilkhetJai.controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import project.sw.NilkhetJai.models.Book;
import project.sw.NilkhetJai.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Value("${app.url}")
    private String appURL;

    @GetMapping("/addBook")
    public String addBook() {
        return "book/add-book";
    }

    @GetMapping("/showBooks")
    public String showAllBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book/show-books";
    }

    @PostMapping("/addBook")
    public String addBookPost(
            @RequestParam("filedata") MultipartFile multipartFile,
            @RequestParam(name = "name", required = true, defaultValue = "") String bookName,
            @RequestParam(name = "language", required = true, defaultValue = "") String language,
            @RequestParam(name = "type", required = true, defaultValue = "") String bookType,
            @RequestParam(name = "writterName", required = true, defaultValue = "") String writterName,
            @RequestParam(name = "numberOfBooks", required = true, defaultValue = "") String numberOfBooks)
            throws IOException {

        Book books = new Book();
        books.setLanguage(language);
        books.setName(bookName);
        books.setType(bookType);
        books.setAuthor(writterName);
        int numberOfBooksInt = Integer.parseInt(numberOfBooks);
        books.setNumberOfBooks(numberOfBooksInt);
        if (numberOfBooksInt > 0) {
            books.setIsAvailable(true);
        } else {
            books.setIsAvailable(false);
        }

        byte[] bytes = multipartFile.getBytes();
        String encodedFileData = Base64.getEncoder().encodeToString(bytes);
        books.setFileType(multipartFile.getContentType());
        books.setFileData(encodedFileData);
        bookService.save(books);

        return "book/success";
    }

    @GetMapping("/makeAvailable")
    public String makeAvailable() {
        return "make-available/make-available";
    }

    @PostMapping("/makeAvailable")
    public String makeAvailablePost(@RequestParam(name = "id", required = true, defaultValue = "") String id,
            Model model) {
        Optional<Book> books = bookService.findById(Long.parseLong(id));
        if (books.get().getIsAvailable()) {
            model.addAttribute("message", "Your book is available, please order this book");
        } else {
            model.addAttribute("message", "Sorry, the books is not available, please try again later.");
        }
        return "make-available/result";
    }

    @GetMapping("/shareBook")
    public String shareBook(Model model) {
        model.addAttribute("appUrl", appURL + "/bookDetails/" + 1);
        return "share-book/share-book";

    }

    @PostMapping("/shareBook")
    public String shareBookPost(@RequestParam(name = "id", required = true, defaultValue = "") String id,
            Model model) {
        Optional<Book> book = bookService.findById(Long.parseLong(id));
        model.addAttribute("book", book);
        model.addAttribute("id", id);
        model.addAttribute("bookDetailsURL", "/bookDetails/" + id);
        return "share-book/share-book";
    }

    @GetMapping("bookDetails/{id}")
    public String bookDetailsGet(@PathVariable Long id, Model model) {
        Optional<Book> books = bookService.findById(id);
        model.addAttribute("bookName", "Book's Name: " + books.get().getName());
        model.addAttribute("writerName", "Writer's Name: " + books.get().getAuthor());
        model.addAttribute("language", "Language: " + books.get().getLanguage());
        if (books.get().getIsAvailable()) {
            model.addAttribute("available", "The book is available in Nilkhet");
        }

        return "book/book-details";
    }

}
