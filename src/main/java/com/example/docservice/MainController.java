
@Controller
public class MainController {

    @GetMapping("/") // функция обрабатывает главную страничку
    public String signin(Model model) {
        model.addAttribute("title", "Вход в систему"); // передаем название странички
        return "signin";
    }

    @GetMapping("/registration") // функция обрабатывает страницу с регистрацией
    public String registration(Model model) {
        model.addAttribute("title", "Записаться к врачу"); // передаем название странички
        return "registration";
    }


}