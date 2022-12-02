package com.example.docservice.api;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//import com.example.docservice.service.ServicePage;

@RestController
public class Controller implements Api {
    @Override
    public ModelAndView singin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signin"); // указываю какую страницу вернуть
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
    public ModelAndView singin(ModelAndView model) {
        model.setViewName("Вход");
        return model;
    }


    }

/*
    // Обработка форм
    @Autowired(required = false)
    private ServicePage servicePage;

    @PostMapping("/sign") // авторизация
    public void login(Login login){
        servicePage.createUser(login);
        System.out.printf("");
    }

    @PostMapping("/docinfo") // информация о враче
    public void changeDocInfo(ProfileDocDto docAccount){
    }

    @PostMapping("/clientReg") // информация о враче
    public void clientReg(ClientReg client){
        servicePage.makeOrder(client);
    }

*/

