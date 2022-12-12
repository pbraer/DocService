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

    public List<Login> getAllUsers() {
        List<User> users = userRepository.findAllUsers();
        List<Login> resultList = new ArrayList<>();
        for (User user : users) {
            Login login = new Login();
            login.setId(user.getId().toString());
            login.setEmail(user.getEmail().toString());
            login.setPass(user.getPass().toString());
            login.setIsdoc(user.getIsdoc().toString());
            resultList.add(login);
        }

        return resultList;
    }

    public String getId(Login login) {
        String id = null;
        List<User> users = userRepository.findAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(login.getEmail())) {
                id = user.getId();
            }

        }

        return id;
    }

    public void createUser(Login login) {
        User user = new User();
        user.setId(String.valueOf(userRepository.findAllUsers().size() + 1));
        user.setEmail(login.getEmail());
        user.setPass(login.getPass());
        user.setIsdoc("0");
        userRepository.save(user);

    }

    public void removeUserByEmail(Long id) {
        userRepository.deleteById(id);
    }


    public String checkUser(String email, String pass) {

        List<Login> userList = getAllUsers();
        for (Login user : userList) {
            if (user.getEmail().equals(email) && user.getPass().equals(pass)){

                if (user.getIsdoc().equals("1")){
                    return("doc");
                }else{
                    return("client");
                }
            }
        }

        return "Клиента нет";
    }

    public int checkEmail(String email) {
        int i = 0;
        List<Login> userList = getAllUsers();
        for (Login user : userList) {
            if (user.getEmail().equals(email)) {
                i++;
                return i;
            }
        }
        return i;
    }

    public int checkPass(String pass) {
        int i = 0;
        List<Login> userList = getAllUsers();
        for (Login user : userList) {
            if (user.getPass().equals(pass)) {
                i++;
                return i;
            }
        }
        return i;
    }

}
