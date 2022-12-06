package com.example.docservice.service;

import com.example.docservice.dto.Login;
import persistence.entity.Doctor;

@org.springframework.stereotype.Service
public class ServicePage {
//    private final DocRepository accountRepository;
//
//    public ServicePage(DocRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }

    public static void createUser(Login login) {
        Doctor profileDoc = new Doctor();
        profileDoc.setEmail(login.getLogin());
        profileDoc.setPassword(login.getPass());

//        accountRepository.save(profileDoc);
//
//        List<ProfileDoc> lisr = accountRepository.findAllDoctors();
        System.out.println("");
    }
}

