package com.example.docservice.service;

import com.example.docservice.dto.Login;
import com.example.docservice.entity.Account;

@org.springframework.stereotype.Service
public class ServicePage {

//    private final AccountRepository accountRepository;
//
//    public ServicePage(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }

    public void createUser(Login login) {
        Account account = new Account();
        account.setEmail(login.getLogin());
        account.setPassword(login.getPass());

//        accountRepository.save(account);
//
//        List<Account> lisr = accountRepository.findAllDoctors();
        System.out.println("");
    }
}