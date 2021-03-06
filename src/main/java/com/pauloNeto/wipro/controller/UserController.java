package com.pauloNeto.wipro.controller;

import com.pauloNeto.wipro.model.User;
import com.pauloNeto.wipro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/user")
    public ResponseEntity<User> newUser(@RequestBody User user){
        if(userService.loginExist(user.getLogin())) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user/{login}")
    public ResponseEntity<User> getUser(@PathVariable String login){
        if(!userService.loginExist(login)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else return ResponseEntity.status(HttpStatus.OK).body(userService.findByLogin(login));
    }
}
