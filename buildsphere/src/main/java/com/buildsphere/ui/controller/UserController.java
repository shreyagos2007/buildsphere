package com.buildsphere.ui.controller;

import com.buildsphere.ui.model.User;
import com.buildsphere.ui.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // LOGIN
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent() &&
                user.get().getPassword().equals(password)) {

            // Save logged-in user information
            session.setAttribute("username", user.get().getUsername());
            session.setAttribute("role", user.get().getRole());

            return "success";
        }

        return "error";
    }

    // LOGOUT
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        // Clear the current login session
        session.invalidate();

        // Return to the login page
        return "redirect:/";
    }
}
