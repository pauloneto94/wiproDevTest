package com.pauloNeto.wipro.controller;

import com.pauloNeto.wipro.model.User;
import com.pauloNeto.wipro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/validate")
    public boolean validateUser(User user){
        return userService.validateUser(user);
    }
}
