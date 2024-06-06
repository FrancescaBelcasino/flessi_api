package org.flessi.api.controller;

import lombok.AllArgsConstructor;
import org.flessi.api.model.User;
import org.flessi.api.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {
    private UserService service;

    @GetMapping("/users")
    public List<User> users() {
        return service.getAllUsers();
    }
}
