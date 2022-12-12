package com.example.docservice.api;

import com.example.docservice.dto.DoctorsDto;
import com.example.docservice.dto.Login;
import com.example.docservice.service.ClientService;
import com.example.docservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView profile(@PathVariable(value = "id") String id) {
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
    public ModelAndView schedule(@PathVariable(value = "id") String id) {
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

        if (emailInt == 0 && passInt == 0) { // если нет в бд
            if (!login.getEmail().equals("") && !login.getPass().equals("")) { //проверяем что поля не пустые
                userService.createUser(login); // добавляем клиента в User
                model.clear();
                model.setView(new RedirectView("/registration"));
            }
            else if (login.getEmail().equals("") && !login.getPass().equals("") ) { //проверяем что почта не пустая
                model.getModel().put("emailError", "Введите почту");
            }
            else if (login.getPass().equals("") && !login.getEmail().equals("")) { //проверяем что пароль не пустой
                model.getModel().put("passError", "Введите пароль");
            }
            else{ //проверяем что пароль и почка не пустые
                model.getModel().put("emailError", "Введите данные");
            }
            return model;
        }
        else if (emailInt == 1 && passInt == 1) { // проверяем совпадает ли с бд

            if (check.equals("doc")){ // проверяем если доктор
                model.clear();
                model.setView(new RedirectView("/profile/" + userService.getId(login)));
                return model;
            }

            if (check.equals("client")){ // проверяем если клиент
                model.clear();
                model.setView(new RedirectView("/registration"));
                return model;
            }

        }else if (emailInt == 1 && passInt == 0) { // если почта есть в бд, а пароль не совпал
            if (login.getPass().equals("")) { //проверяем что поля не пустые
                model.getModel().put("passError", "Введите пароль");
            }
            else{
            model.getModel().put("passError", "Неверно введен пароль");
            }
            return model;

        }
        else if (emailInt == 0 && passInt == 1) { // если пароль есть в бд
            if (login.getEmail().equals("") && !login.getPass().equals("")) { //проверяем что почта не пустая
                model.getModel().put("emailError", "Введите почту");
            }
            return model;
        }
        model.setViewName("sign");
        return model;
    }

    @PostMapping("/schedule") //
    public ModelAndView schedule(@ModelAttribute("userForm") Login login, ModelAndView model){
        model.clear();
        model.setView(new RedirectView("/schedule/" + userService.getId(login)));
        return model;
    }




    @PostMapping("/docEdit") // изменение профиля врача
    public ModelAndView login(@ModelAttribute("doctorForm") DoctorsDto doctorsDto, ModelAndView model) {
        System.out.println(doctorsDto.getId());
        System.out.println(doctorsDto.getEmail());
        System.out.println(doctorsDto.getPass());
        System.out.println(doctorsDto.getLastname());
        System.out.println(doctorsDto.getFirstname());
        System.out.println(doctorsDto.getMiddlename());
        System.out.println(doctorsDto.getImage());
        System.out.println(doctorsDto.getQualif());
        System.out.println(doctorsDto.getMonday());
        System.out.println(doctorsDto.getTimeFrom());
        return model;
    }
}

