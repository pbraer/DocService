package com.example.docservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.StudentDto;
import rest.service.HtmlPageService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class MainController {

    @GetMapping("/") // функция обрабатывает главную страничку
    public String signin(Model model) {
        model.addAttribute("title", "Вход в систему"); // передаем название странички
        return "signin";
    }

    @GetMapping("/profile") // функция обрабатывает главную страничку
    public String profile(Model model) {
        model.addAttribute("title", "Профиль"); // передаем название странички
        return "profile";
    }

    @GetMapping("/registration") // функция обрабатывает страницу с регистрацией
    public String registration(Model model) {
        model.addAttribute("title", "Записаться к врачу"); // передаем название странички
        return "registration";
    }

    @GetMapping("/schedule") // функция обрабатывает страницу с расписанием
    public String schedule(Model model) {
        model.addAttribute("title", "Расписание"); // передаем название странички
        return "schedule";
    }

    // Обработка форм
    @Autowired(required = false)
    private ServicePage servicePage;

    @PostMapping("/sign") // авторизация
    public void login(Login login){
        servicePage.createUser(login);
        System.out.printf("");
    }

    @PostMapping("/docinfo") // информация о враче
    public void changeDocInfo(AccountDto docAccount){
    }

    @PostMapping("/clientReg") // информация о враче
    public void clientReg(ClientReg client){
        servicePage.makeOrder(client);
    }


}