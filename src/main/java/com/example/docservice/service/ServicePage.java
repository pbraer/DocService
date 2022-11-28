package com.example.docservice.service;

import com.example.docservice.dto.Login;
import com.example.docservice.entity.ProfileDoc;

@org.springframework.stereotype.Service
public class ServicePage {

//    private final DocRepository accountRepository;
//
//    public ServicePage(DocRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }

    public void createUser(Login login) {
        ProfileDoc profileDoc = new ProfileDoc();
        profileDoc.setEmail(login.getLogin());
        profileDoc.setPassword(login.getPass());

//        accountRepository.save(profileDoc);
//
//        List<ProfileDoc> lisr = accountRepository.findAllDoctors();
        System.out.println("");
    }
}