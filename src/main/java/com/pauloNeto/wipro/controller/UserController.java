package com.pauloNeto.wipro.controller;

import com.pauloNeto.wipro.model.User;
import com.pauloNeto.wipro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateUser(User user){
        return new ResponseEntity<Boolean>(userService.validateUser(user), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> newUser(@RequestBody User user){
        if(userService.loginExist(user.getLogin())) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.OK);
    }
}
