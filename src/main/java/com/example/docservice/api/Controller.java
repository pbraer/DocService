package com.example.docservice.api;

import com.example.docservice.dto.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.docservice.service.UserService;

@RestController
public class Controller implements Api {
    @Autowired
    private UserService userService;
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
    public RedirectView redirectToWelcomePage() {
        return new RedirectView("/sign");
    }
    @PostMapping("/sign") // авторизация
    public void login(Login login){
        if (login.getEmail().equals(userService.findByEmail(login.getEmail()))){
            System.out.print('1');

        }
    }

    }

/*
    // Обработка форм
    @Autowired(required = false)
    private ServicePage servicePage;




    @PostMapping("/docinfo") // информация о враче
    public void changeDocInfo(ProfileDocDto docAccount){
    }

    @PostMapping("/clientReg") // информация о враче
    public void clientReg(ClientReg client){
        servicePage.makeOrder(client);


*/

