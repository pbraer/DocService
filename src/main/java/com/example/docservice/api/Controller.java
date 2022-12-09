package com.example.docservice.api;

import com.example.docservice.dto.DoctorsDto;
import com.example.docservice.dto.Login;
import com.example.docservice.service.ClientService;
import com.example.docservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
        modelAndView.getModel().put("doctorForm", new DoctorsDto());
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


    @PostMapping("/login") // авторизация
    public ModelAndView login(@ModelAttribute("userForm") Login login, ModelAndView model){
        String check = userService.checkUser(login.getEmail(), login.getPass());
        int emailInt = userService.checkEmail(login.getEmail());
        int passInt = userService.checkPass(login.getPass());

        if (emailInt == 1 && passInt == 1) { // проверяем совпадает ли с бд

            if (check.equals("doc")){ // проверяем если доктор
                model.clear();
                model.setView(new RedirectView("/profile"));
                return model;
            }

            if (check.equals("client")){ // проверяем если клиент
                model.clear();
                model.setView(new RedirectView("/registration"));
                return model;
            }

        }else if (emailInt == 1 && passInt == 0) { // если почта есть в бд, а пароль не совпал
            model.getModel().put("passwordError", "Неверно введен пароль");
            return model;

        }else if (emailInt == 0 && passInt == 0) { // если нет в бд
            userService.createUser(login); // добавляем клиента в User
            model.clear();
            model.setView(new RedirectView("/registration"));
            return model;
        }

        model.setViewName("sign");
        return model;

    }

    /*@PostMapping("/docEdit") // изменение профиля врача
    public ModelAndView login(@ModelAttribute("doctorForm") DoctorsDto doctorsDto, ModelAndView model){


    }
*/


}



