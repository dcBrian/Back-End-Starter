package com.project.starter.controllers;

import java.util.List;

import com.project.starter.models.User;
import com.project.starter.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User one(@PathVariable Long id) {
        return userService.getOneEntity(id);
    }

    @GetMapping
    public List<User> all() {
        return userService.getAllEntities();
    }
}
