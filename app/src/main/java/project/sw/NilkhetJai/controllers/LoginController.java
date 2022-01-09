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
            User user = userOptional.get();
            LocalDateTime requestedDateTime = LocalDateTime.now();
            // loginManually(user);
            return "redirect:/";
        }
        return "login/login";

    }

    @PostMapping("/login")
    public String userLogin(@Valid UserLoginForm userLoginForm, BindingResult bindingResult,
            Model model) {

        // User existing =
        // userService.findByEmail(userLoginForm.getEmail().trim()).get();
        // if (existing == null) {
        // bindingResult.rejectValue("email", null, "Invalid email or password");
        // System.out.println("Invalid email or password");
        // return "login/login";
        // }
        // System.out.println("Successfully logged in");

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

    @Transactional
    @PostMapping("/registration")
    public String registerUser(
            @RequestParam(name = "email", required = false, defaultValue = "") String email,
            @RequestParam(name = "password", required = true, defaultValue = "") String password,
            Model model,
            RedirectAttributes redirectAttributes)
            throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
        // clears leading or trailing spaces
        email = email.trim();

        User user = new User();
        // user.setFirstName(firstName);
        // user.setLastName(lastName);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setEmail(email);

        User registeredUser = userService.save(user);

        redirectAttributes.addFlashAttribute("notification", "Successfully registered!");

        // loginManually(registeredUser);

        return "redirect:/";
    }

    // private void loginManually(User user) {
    // Authentication authentication = new UsernamePasswordAuthenticationToken(
    // userDetailsService
    // .loadUserByUsername(phoneContactService.findByUserAndIsLogin(user,
    // true).get().getNumber()),
    // null, AuthorityUtils.createAuthorityList(UserRole.USER.toString()));
    // SecurityContextHolder.getContext().setAuthentication(authentication);
    // }

    @GetMapping("/results")
    public String results() {
        return "results";
    }

}
