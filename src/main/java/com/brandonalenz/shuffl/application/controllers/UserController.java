package com.brandonalenz.shuffl.application.controllers;

import com.brandonalenz.shuffl.application.model.User;
import com.brandonalenz.shuffl.application.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserRepository userRepository;

    protected UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable(value = "userId") long id) {
        return userRepository.findById(id);
    }
}
