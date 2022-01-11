package project.sw.NilkhetJai.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import project.sw.NilkhetJai.models.User;
import project.sw.NilkhetJai.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    /**
     * index function return the landing page of Nilkhet jai project.
     * 
     * @return
     */
    public String index(Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        Long userId = Long.parseLong(loggedInUser.getName());

        Optional<User> userOptional = userService.findById(userId);
        User user = userOptional.get();

        model.addAttribute("name", user.getFirstName() + " " + user.getLastName());
        System.out.println(user.getFirstName());

        return "index";
    }

}
