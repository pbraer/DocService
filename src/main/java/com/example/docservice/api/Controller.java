package com.example.docservice.api;

import com.example.docservice.dto.DoctorsDto;
import com.example.docservice.dto.Login;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.beans.factory.annotation.*;

import com.example.docservice.service.DocServicePage;
import com.example.docservice.dto.DoctorsDto;

@RestController
public class Controller implements Api {
    @Autowired
    private DocServicePage docServicePage;
    @Override
    public ModelAndView sign() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sign"); // указываю какую страницу вернуть
        modelAndView.getModel().put("message", "Вход в систему");
        return modelAndView;
    }

    @Override
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile"); // указываю какую страницу вернуть
        return modelAndView;
    }

    @Override
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration"); // указываю какую страницу вернуть
        return modelAndView;
    }

    @Override
    public ModelAndView schedule() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("schedule"); // указываю какую страницу вернуть
        return modelAndView;
    }
    @GetMapping("/")
    public RedirectView redirectToLoginPage() {
        return new RedirectView("/sign");
    }
    @PostMapping("/sign") // авторизация
    public void login(Login login){
        com.example.docservice.service.DocServicePage.createUser(login);
        System.out.print("");
    }

    @PostMapping("/docinfo") // информация о враче
    public void changeDocInfo(DoctorsDto docAccount){
    }

    @PostMapping("/clientReg") // информация о враче
    public void clientReg(ClientDto client) {
        docServicePage.makeOrder(client);
    }
}