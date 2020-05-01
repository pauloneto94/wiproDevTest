package com.pauloNeto.wipro.service;

import com.pauloNeto.wipro.model.User;
import com.pauloNeto.wipro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(User user){
        return userRepository.findAll().contains(user);
    }

    public User createUser(User user){ return userRepository.save(user); }

}
