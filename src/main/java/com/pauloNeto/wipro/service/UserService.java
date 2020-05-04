package com.pauloNeto.wipro.service;

import com.pauloNeto.wipro.model.User;
import com.pauloNeto.wipro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User currentUser = null;

    public Boolean logIn(User user){
        Map<String, String> users = new HashMap<>();
        userRepository.findAll().stream().map(u ->
            users.put(u.getLogin(), u.getPassword())
                ).collect(Collectors.toList());

        System.out.println(users);
        System.out.println(users.get(user.getLogin()));
        System.out.println(user.getPassword() == users.get(user.getLogin()));
        if(users.get(user.getLogin()) == user.getPassword()) return true;
        else return false;
    }

    public User createUser(User user){ return userRepository.save(user); }

    public Boolean loginExist(String login){
        List<String> usersName = userRepository.findAll()
                .stream()
                .map(user -> user.getLogin())
                .collect(Collectors.toList());

        if(usersName.contains(login)) return true;
        else return false;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }

}
