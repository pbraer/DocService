package com.example.docservice.api;

import com.example.docservice.dto.ClientDto;
import com.example.docservice.dto.Login;

import com.example.docservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.docservice.service.UserService;

@RestController
public class Controller implements Api {
    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @Override
    public ModelAndView sign() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sign"); // указываю какую страницу вернуть
        modelAndView.getModel().put("userForm", new Login());
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
    public ModelAndView login(@ModelAttribute("userForm") Login login, ModelAndView model){
        String check = userService.checkUser(login.getEmail(), login.getPass());
        int emailInt = userService.checkEmail(login.getEmail());
        int passInt = userService.checkPass(login.getPass());
        if (emailInt == 1 && passInt == 1) { // проверяем совпадает ли с бд
            if (check.equals("doc")){ // проверяем если доктор
                model.setViewName("profile");
                return model;
            }
            if (check.equals("client")){ // проверяем если клиент
                model.setViewName("registration");
                return model;
            }
        }
        if (emailInt == 1 && passInt == 0) { // если почта есть в бд, а пароль не совпал
            model.getModel().put("passError", "Неверно введен пароль"); // надо в html добавить сноску на ошибку
            return model;
        }

        if (emailInt == 0 && passInt == 0) {
            userService.createUser(login);
            model.setViewName("registration");
            return model;
        }
        //userService.removeUserByEmail(Long.valueOf("12"));
        //userService.removeUserByEmail(Long.valueOf("13"));

        model.setViewName("sign");
        return model;

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

