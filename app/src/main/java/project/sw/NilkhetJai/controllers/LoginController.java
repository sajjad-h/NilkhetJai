package project.sw.NilkhetJai.controllers;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.sw.NilkhetJai.form.UserLoginForm;
import project.sw.NilkhetJai.models.User;
import project.sw.NilkhetJai.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/login")
    public String viewUserLoginPage(
            @RequestParam(name = "user_id", required = false, defaultValue = "-1") Long userId,
            @RequestParam(name = "secret_code", required = false, defaultValue = "") String secretLoginCode,
            @RequestParam(name = "back_url", required = false, defaultValue = "") String backURL,
            Model model, Authentication authentication, HttpServletRequest request) {

        if (backURL.length() > 0) {
            request.getSession().setAttribute("backurlbutton", backURL);
        }
        if (authentication != null && authentication.isAuthenticated()) {
            model.addAttribute("notification", "You are already logged in");
            return "redirect:/";
        }
        if (secretLoginCode.length() > 0) {
            Optional<User> userOptional = userService.findById(userId);
            if (!userOptional.isPresent()) {
                model.addAttribute("description", "Wrong user id!");
                return "error";
            }
            return "redirect:/";
        }
        return "login/login";

    }

    @PostMapping("/login")
    public String userLogin(@Valid UserLoginForm userLoginForm, BindingResult bindingResult,
            Model model) {
        model.addAttribute("notification", "Successfully logged in");
        return "redirect:/";
    }

    @GetMapping("/registration")
    public String viewUserRegistrationPage(
            @RequestParam(name = "username", required = false, defaultValue = "") String username,
            User user,
            Model model, Authentication authentication, HttpServletRequest request) {
        if (authentication != null && authentication.isAuthenticated()) {
            model.addAttribute("notification", "You are already logged in");
            return "redirect:/";
        }

        model.addAttribute("user", user);
        model.addAttribute("phone", username);
        return "registration/registration";
    }

    @PostMapping("/registration")
    public String registerUser(
            @RequestParam(name = "email", required = false, defaultValue = "") String email,
            @RequestParam(name = "password", required = true, defaultValue = "") String password,
            @RequestParam(name = "confirmPassword", required = true, defaultValue = "") String confirmPassword,
            @RequestParam(name = "firstName", required = true, defaultValue = "") String firstName,
            @RequestParam(name = "lastName", required = true, defaultValue = "") String lastName,

            Model model,
            RedirectAttributes redirectAttributes) {
        email = email.trim();

        Optional<User> userOptional = userService.findByEmail(email);
        if (userOptional.isPresent()) {
            redirectAttributes.addFlashAttribute("emailError", "This email is already registered!");
            redirectAttributes.addFlashAttribute("firstName", firstName);
            redirectAttributes.addFlashAttribute("lastName", lastName);
            redirectAttributes.addFlashAttribute("email", email);

            return "redirect:/registration";
        }

        if (!confirmPassword.equals(password)) {
            redirectAttributes.addFlashAttribute("confirmPasswordError",
                    "Password and confirm password does not matched!");
            redirectAttributes.addFlashAttribute("firstName", firstName);
            redirectAttributes.addFlashAttribute("lastName", lastName);
            redirectAttributes.addFlashAttribute("email", email);

            return "redirect:/registration";
        }

        User user = new User();

        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setEmail(email);

        userService.save(user);

        redirectAttributes.addFlashAttribute("notification", "Successfully registered!");

        return "redirect:/";
    }

}
