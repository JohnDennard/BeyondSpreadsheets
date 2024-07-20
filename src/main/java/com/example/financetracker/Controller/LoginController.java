package com.example.financetracker.Controller;

import com.example.financetracker.Service.user.UserService;
import com.example.financetracker.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserEntity user, Model model, RedirectAttributes redirectAttributes) {
        // Check if username already exists
        if (userService.isUserExists(user.getUsername())) {
            System.out.println("UserName " + user.getUsername());
            // Username already exists, add error message and return to signup form
            redirectAttributes.addFlashAttribute("error1", "Username already exists. Please choose a different username.");
            return "redirect:/Signup"; // Adjust URL if we change file name of Signup page 
        }

        userService.saveUser(user);

//        model.addAttribute("message", "User registered successfully!");
        redirectAttributes.addFlashAttribute("message", "User registered successfully");

        return "redirect:/login";
    }
}
