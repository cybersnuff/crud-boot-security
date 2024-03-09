package ru.itmentor.spring.boot_security.demo.configs.controllers;

import org.springframework.security.core.Authentication;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmentor.spring.boot_security.demo.configs.models.User;
import ru.itmentor.spring.boot_security.demo.configs.service.UserService;

@Controller
@RequestMapping("/user")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUserProfile(Model model, Authentication authentication) {
        String auth = authentication.getName(); // Получаем имя текущего пользователя

        User user = userService.getUserByUsername(auth);

        model.addAttribute("user", user);
        return "user-profile";
    }



}
