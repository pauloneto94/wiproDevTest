package com.pauloNeto.wipro.service;

import com.pauloNeto.wipro.model.User;
import com.pauloNeto.wipro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(User user){
        return userRepository.findAll().contains(user);
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

}
