package com.example.docservice.service;


import com.example.docservice.dto.UserDto;
import com.example.docservice.persistence.entity.User;
import com.example.docservice.persistence.repository.DoctorRepository;
import com.example.docservice.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAllUsers();
        List<UserDto> resultList = new ArrayList<>();
        for (User user : users) {
            UserDto loginUser = new UserDto();
            loginUser.setEmail(user.getEmail());
            loginUser.setPass(user.getPass());
            loginUser.setIsdoc(user.getIsdoc());
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
