package com.github.zcmee.godmodehibernate.controllers;

import com.github.zcmee.godmodehibernate.entities.User;
import com.github.zcmee.godmodehibernate.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

}
