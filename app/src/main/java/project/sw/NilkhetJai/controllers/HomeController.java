package project.sw.NilkhetJai.controllers;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import project.sw.NilkhetJai.models.User;
import project.sw.NilkhetJai.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        Long userId = Long.parseLong(loggedInUser.getName());

        Optional<User> userOptional = userService.findById(userId);
        User user = userOptional.get();

        model.addAttribute("name", user.getFirstName() + " " + user.getLastName());
        System.out.println(user.getFirstName());

        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home/index";
    }

}
