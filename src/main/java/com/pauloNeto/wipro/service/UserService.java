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

    public User currentUser = null;

    public User logIn(User user){
        if(userRepository.findAll().contains(user)){
            currentUser = user;
            return user;
        }else return null;
    }

    public void logOff(User user){
        if(currentUser != null){
            currentUser = null;
        }
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

}
