package com.github.zcmee.godmodehibernate.controllers;

import com.github.zcmee.godmodehibernate.entities.User;
import com.github.zcmee.godmodehibernate.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("user")
    public User findUserById(@RequestParam String username) {
        return userService.findByFirstName(username);
    }

}
