package project.sw.NilkhetJai.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.sw.NilkhetJai.models.Book;
import project.sw.NilkhetJai.models.Order;
import project.sw.NilkhetJai.models.User;
import project.sw.NilkhetJai.service.BookService;
import project.sw.NilkhetJai.service.OrderService;
import project.sw.NilkhetJai.service.UserService;

@Controller
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderService orderService;

    @Value("${app.url}")
    private String appURL;

    /**
     * orderBook is a PostMapping Function for order a book
     * 
     * @param bookId
     * @return
     * @throws IOException
     */

    @PostMapping("/orderBook")
    public String orderBook(
            @RequestParam(name = "book_id", required = true, defaultValue = "") Long bookId,
            Authentication authentication, Model model)
            throws IOException {
        Optional<User> optionalUser = userService.findById(Long.parseLong(authentication.getName()));
        if (!optionalUser.isPresent()) {
            return "error";
        }
        User user = optionalUser.get();
        Optional<Book> optionalBook = bookService.findById(bookId);
        if (!optionalBook.isPresent()) {
            return "error";
        }
        Book book = optionalBook.get();
        Order order = new Order();
        List<Book> books = order.getBooks();
        if (books == null) {
            books = new ArrayList<Book>();
        }
        books.add(book);
        order.setBooks(books);
        order.setUser(user);
        orderService.save(order);
        model.addAttribute("message", "Book has been ordered successfully!");
        return "success";
    }
}
