package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.facade.UserFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserFacade facade;

    public UserController(UserFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", facade.findAllUsers());
        return "list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        facade.findUserById(id).ifPresent(user -> model.addAttribute("user", user));
        return "detail";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserEntity user) {
        facade.saveUser(user);
        return "redirect:/users";
    }
}