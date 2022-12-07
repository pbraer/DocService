package com.example.docservice.service;


import com.example.docservice.dto.Login;

import com.example.docservice.persistence.entity.User;
import com.example.docservice.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public List<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<Login> getAllUsers(){
        List<User> users = userRepository.findAllUsers();
        List<Login> resultList = new ArrayList<>();
        for (User user : users) {
            Login loginUser = new Login();
            loginUser.setEmail(user.getEmail());
            loginUser.setPass(user.getPass());
            resultList.add(loginUser);
        }
        return resultList;
    }
/*
    public Boolean getByIsdoc(){
        User users = new User();
        return users.getIsdoc();
    }
*/



}
