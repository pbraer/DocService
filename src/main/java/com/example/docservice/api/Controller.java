package com.example.docservice.api;

import com.example.docservice.dto.Login;

import com.example.docservice.persistence.entity.User;
import com.example.docservice.persistence.repository.UserRepository;
import com.example.docservice.service.ServicePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.docservice.service.UserService;

import java.util.List;

@RestController
public class Controller implements Api {
    @Autowired
    private UserService userService;
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
    public void login(Login login) {
        List<Login> users = userService.getAllUsers();
        System.out.println(users);
        String emailFromCons = login.getEmail(); // берем почту с консоли
        System.out.println(emailFromCons); // выводим ее, проверка что работает
        // надо эту прочту проверить по бд, что 0 или 1.
        // как это сделать........
        /*
        // берем список всех юзеров
        for (UserDto user : users) { // прогоняем по циклу
            Boolean role = user.getIsdoc(); // берем у каждого роль
            String email = user.getEmail(); // берем почту
            if (email.equals(emailFromCons)) { // проверяем что почты совпадают с бд и консиоли
                System.out.println(role); // выводим номер роли
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

    }
}