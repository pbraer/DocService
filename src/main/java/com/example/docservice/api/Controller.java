package com.example.docservice.api;

import com.example.docservice.dto.*;
import com.example.docservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller implements Api {
    @Autowired
    private UserService userService;

    @Autowired
    private ServicePage docService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private FileService fileService;

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
        modelAndView.addObject("userId", id);
        modelAndView.addObject("firstname", docService.findDoctorByUserId(id).getFirstname());
        modelAndView.addObject("lastname", docService.findDoctorByUserId(id).getLastname());
        modelAndView.addObject("middlename", docService.findDoctorByUserId(id).getMiddlename());
        modelAndView.addObject("qualif", docService.findDoctorByUserId(id).getQualif());
        modelAndView.addObject("timefrom", docService.findDoctorByUserId(id).getTimefrom());
        modelAndView.addObject("timeto", docService.findDoctorByUserId(id).getTimeto());
        if(docService.findDoctorByUserId(id).getMonday() != null){
            modelAndView.addObject("monday", "checked");
        }else{
            modelAndView.addObject("monday", "unchecked");
        }
        if(docService.findDoctorByUserId(id).getTuesday() != null){
            modelAndView.addObject("tuesday", "checked");
        }else{
            modelAndView.addObject("tuesday", "unchecked");
        }
        if(docService.findDoctorByUserId(id).getWednesday() != null){
            modelAndView.addObject("wednesday", "checked");
        }else{
            modelAndView.addObject("wednesday", "unchecked");
        }
        if(docService.findDoctorByUserId(id).getThursday() != null){
            modelAndView.addObject("thursday", "checked");
        }else{
            modelAndView.addObject("thursday", "unchecked");
        }
        if(docService.findDoctorByUserId(id).getFriday() != null){
            modelAndView.addObject("friday", "checked");
        }else{
            modelAndView.addObject("friday", "unchecked");
        }
        if(docService.findDoctorByUserId(id).getSaturday() != null){
            modelAndView.addObject("saturday", "checked");
        }else{
            modelAndView.addObject("saturday", "unchecked");
        }
        if(docService.findDoctorByUserId(id).getSunday() != null){
            modelAndView.addObject("sunday", "checked");
        }else{
            modelAndView.addObject("sunday", "unchecked");
        }
        modelAndView.addObject("img", docService.findDoctorByUserId(id).getImage());

        return modelAndView;
    }


    @Override
    public ModelAndView registration(@PathVariable(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration"); // указываю какую страницу вернуть
        modelAndView.getModel().put("clientForm", new ClientDto());
        modelAndView.addObject("userId", id);
        modelAndView.addObject("docs", docService.getAllDoctors());
        //System.out.println((String) modelAndView.getModel().get("qualif"));
        //modelAndView.getModel().put("docs", docService.findOnequalifDoc((String) modelAndView.getModel().get("qualif")));

        //modelAndView.getModel().put("client", clientService.getRecordsById(userService.getEmailById(id)));
        return modelAndView;
    }

    @Override
    public ModelAndView schedule(@PathVariable(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("schedule"); // указываю какую страницу вернуть
        //modelAndView.addObject("records", new ClientDto()); // пропишем get list для записей id
        if (clientService.getRecordsById(id).size() != 0) {
            modelAndView.getModel().put("records", clientService.getRecordsById(id));
        }else{
            modelAndView.getModel().put("noClientsError", "У Вас пока нет ни одного клиента");
        }
        modelAndView.addObject("userId", id);
        return modelAndView;
    }

    @Override
    public ModelAndView documents(@PathVariable(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("documents"); // указываю какую страницу вернуть
        modelAndView.addObject("userId", id);
        return modelAndView;
    }

    @Override
    public ModelAndView patients(@PathVariable(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("patients"); // указываю какую страницу вернуть
        modelAndView.addObject("userId", id);
        modelAndView.getModel().put("patients", clientService.getNearestDatas(id));
        return modelAndView;
    }

    @GetMapping(value = "/get-doc")
    @ResponseBody
    public List<DoctorsDto> getListAccount(@RequestParam String spec) {

        return docService.findOnequalifDoc(spec);
    }

    @GetMapping(value = "/get-time")
    @ResponseBody
    public List<String> getListTime(@RequestParam String docdate,
                                    @RequestParam String docid) throws ParseException, NonWorkdayEx {
        try {
            return docService.getDocFreetime(String.valueOf(docid), docdate);
        }catch (NonWorkdayEx e) {
            List<String> ex = new ArrayList<String>();
            ex.add("Врач не работает в этот день!");
            return ex;
        }
    }

    @PostMapping(value = "/upload-image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public FilesDto uploadFile(MultipartFile file) {
        if (file.getName() == null && file.getName() == ""){
            return null;
        }
        imageService.save(file);
        return new FilesDto();
    }

    @PostMapping("/add-image")
    public void uploadFile(String img, String id) {
        System.out.println(img);
        if (img != null && img != "") {
            docService.updateDoctorImg(id, img);
        }
    }


    @PostMapping(value = "/upload-file",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ImageDto uploadFiles(MultipartFile file) {
        if (file.getName() == null && file.getName() == ""){
            return null;
        }
        fileService.save(file);
        return new ImageDto();
    }

    @PostMapping("/add-file")
    public void uploadFiles(String docid, String client, String doc) {
        if (doc != null && doc != "") {
            clientService.addDocument(client, docid, doc);
        }
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
                model.setView(new RedirectView("/registration/"+ userService.getId(login)));
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
                model.setView(new RedirectView("/registration/"+ userService.getId(login)));
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


    @PostMapping("/profile") // изменение профиля врача
    public ModelAndView profile(@ModelAttribute("doctorForm") DoctorsDto doctorsDto, ModelAndView model){

        if(doctorsDto.getLastname().equals("")){
            model.getModel().put("lastnameError", "Заполните данные");
            return model;
        }else if(doctorsDto.getFirstname().equals("")) {
            model.getModel().put("firstnameError", "Заполните данные");
            return model;
        }else {
            String img = docService.findDoctorByUserId(doctorsDto.getUserid()).getImage();
            System.out.println("set prof " + img);;
            docService.updateDoctorInfo(doctorsDto);
            model.clear();
            model.setView(new RedirectView("/profile/"+ doctorsDto.getUserid()));
            return model;
        }

    }

    @PostMapping("/patients") // изменение профиля врача
    public ModelAndView profile(@ModelAttribute("patientsForm") FilesDto filesDto, ModelAndView model) throws Exception {

        if(filesDto.getFilename() == null){
            return model;
        }else {
            try {
                System.out.println("set prof " + filesDto.getFilename());
                clientService.addDocument(filesDto.getDocid(), filesDto.getClientid(), filesDto.getFilename());
                model.clear();
                model.setView(new RedirectView("/patients/" + filesDto.getDocid()));
                return model;
            }catch(RuntimeException e){
                model.getModel().put("fileExist", "Такой файл уже существует");
                clientService.addDocument(filesDto.getDocid(), filesDto.getClientid(), filesDto.getFilename());
                model.addObject("file", filesDto.getFilename());
                model.setView(new RedirectView("/patients/" + filesDto.getDocid()));
                return model;

            }
        }

    }

    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute("clientForm") ClientDto clientDto,  ModelAndView model) {

        if(clientDto.getQualif().equals("")){
            model.getModel().put("qualifError", "Заполните данные");
            return model;
        }else if (clientDto.getDoctorid().equals("")){
            model.getModel().put("docError", "Выберите специалиста");
            return model;
        }else if (clientDto.getTimeappoitm().equals("")){
        model.getModel().put("timeError", "Выберите время");
            return model;
        }else if (clientDto.getDateappoitm().equals("")){
            model.getModel().put("dateError", "Выберите дату");
            return model;
        }else {
            clientService.createRecord(clientDto);
            model.clear();
            model.setView(new RedirectView("/registration/"+ clientDto.getUserid()));
            return model;
        }

    }


}



