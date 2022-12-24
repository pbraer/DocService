package com.example.docservice.service;

import com.example.docservice.dto.ClientDto;
import com.example.docservice.dto.DoctorsDto;
import com.example.docservice.persistence.entity.Doctor;
import com.example.docservice.persistence.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ServicePage {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    public List<DoctorsDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAllDoctors();
        List<DoctorsDto> resultList = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorsDto doctorsDto = new DoctorsDto();
            doctorsDto.setId(doctor.getId().toString());
            doctorsDto.setUserid(doctor.getUserid());
            doctorsDto.setEmail(doctor.getEmail());
            doctorsDto.setPass(doctor.getPass());
            doctorsDto.setFirstname(doctor.getFirstname());
            doctorsDto.setLastname(doctor.getLastname());
            doctorsDto.setMiddlename(doctor.getMiddlename());
            doctorsDto.setQualif(doctor.getQualif());
            doctorsDto.setImage(doctor.getImage());
            doctorsDto.setMonday(doctor.getMonday());
            doctorsDto.setTuesday(doctor.getTuesday());
            doctorsDto.setWednesday(doctor.getWednesday());
            doctorsDto.setThursday(doctor.getThursday());
            doctorsDto.setFriday(doctor.getFriday());
            doctorsDto.setSaturday(doctor.getSaturday());
            doctorsDto.setSunday(doctor.getSunday());
            doctorsDto.setTimefrom(doctor.getTimefrom());
            doctorsDto.setTimeto(doctor.getTimeto());
            resultList.add(doctorsDto);
        }

        return resultList;
    }

    public Doctor findDoctorByUserId(String userid) {
        Doctor doctor = new Doctor();
        List<Doctor> doctors = doctorRepository.findAllDoctors();
        for (Doctor doc : doctors) {
            if (doc.getUserid().equals(userid)) {
                doctor = doc;
            }

        }

        return doctor;
    }

    public List<DoctorsDto> findOnequalifDoc(String qualif) {
        List<Doctor> doctors = doctorRepository.findAllDoctors();
        List<DoctorsDto> resultList = new ArrayList<>();
        for (Doctor doc : doctors) {
            if (doc.getQualif().equals(qualif)){
                DoctorsDto reg = new DoctorsDto();
                reg.setId(doc.getId());
                reg.setUserid(doc.getUserid());
                reg.setEmail(userService.getEmailById(doc.getUserid()));
                reg.setPass(userService.getPassById(doc.getUserid()));
                reg.setLastname(doc.getLastname());
                reg.setFirstname(doc.getFirstname());
                reg.setMiddlename(doc.getMiddlename());
                reg.setQualif(doc.getQualif());
                resultList.add(reg);
            }
        }

        return resultList;
    }


    public String findDoctorIdByUserId(String userid) {
        String id = null;
        List<Doctor> doctors = doctorRepository.findAllDoctors();
        for (Doctor doc : doctors) {
            if (doc.getUserid().equals(userid)) {
                id = doc.getId();
            }

        }

        return id;
    }

    public void createDoctor(DoctorsDto doctorsDto) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorsDto.getId());
        doctor.setUserid(doctorsDto.getUserid());
        doctor.setPass(userService.getPassById(doctor.getId()));
        doctor.setEmail(userService.getEmailById(doctor.getId()));
        doctor.setFirstname(doctorsDto.getFirstname());
        doctor.setLastname(doctorsDto.getLastname());
        doctor.setMiddlename(doctorsDto.getMiddlename());
        doctor.setQualif(doctorsDto.getQualif());
        if (doctorsDto.getImage() != null && doctorsDto.getImage() != "") {
            doctor.setImage(doctorsDto.getImage());
        }
        doctor.setMonday(doctorsDto.getMonday());
        doctor.setTuesday(doctorsDto.getTuesday());
        doctor.setWednesday(doctorsDto.getMonday());
        doctor.setThursday(doctorsDto.getThursday());
        doctor.setFriday(doctorsDto.getFriday());
        doctor.setSaturday(doctorsDto.getSaturday());
        doctor.setSunday(doctorsDto.getSunday());
        doctor.setTimefrom(doctorsDto.getTimefrom());
        doctor.setTimeto(doctorsDto.getTimeto());
        doctorRepository.save(doctor);

    }

    public void updateDoctorInfo(DoctorsDto doctorsDto){
        doctorsDto.setId(findDoctorIdByUserId(doctorsDto.getUserid()));
        List<DoctorsDto> docList = getAllDoctors();
        docList.removeIf(doc -> (doc.getId() == doctorsDto.getId()));
        doctorRepository.deleteAll();
        for (DoctorsDto doc : docList) {
            createDoctor(doc);

        }

        createDoctor(doctorsDto);

    }

    public void updateDoctorImg(String id, String img){
        if (img != null && img != null) {
            Doctor doctor = findDoctorByUserId(id);
            doctor.setImage(img);
            DoctorsDto doctorsDto = new DoctorsDto();
            doctorsDto.setId(doctor.getId().toString());
            doctorsDto.setUserid(doctor.getUserid());
            doctorsDto.setEmail(doctor.getEmail());
            doctorsDto.setPass(doctor.getPass());
            doctorsDto.setFirstname(doctor.getFirstname());
            doctorsDto.setLastname(doctor.getLastname());
            doctorsDto.setMiddlename(doctor.getMiddlename());
            doctorsDto.setQualif(doctor.getQualif());
            doctorsDto.setImage(doctor.getImage());
            doctorsDto.setMonday(doctor.getMonday());
            doctorsDto.setTuesday(doctor.getTuesday());
            doctorsDto.setWednesday(doctor.getWednesday());
            doctorsDto.setThursday(doctor.getThursday());
            doctorsDto.setFriday(doctor.getFriday());
            doctorsDto.setSaturday(doctor.getSaturday());
            doctorsDto.setSunday(doctor.getSunday());
            doctorsDto.setTimefrom(doctor.getTimefrom());
            doctorsDto.setTimeto(doctor.getTimeto());
            updateDoctorInfo(doctorsDto);
        }


    }

    public List<String> getDocFreetime(String id, String date) throws ParseException, NonWorkdayEx {

        List<String> freetimes = new ArrayList<String>();

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd-MM-yyyy");
        Date docDate= format.parse(date);

        Calendar cal = Calendar.getInstance();
        cal.setTime(docDate);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        int time_from = Integer.parseInt(findDoctorByUserId(id).getTimefrom().substring(0, findDoctorByUserId(id).getTimefrom().indexOf(':')));
        int time_to = Integer.parseInt(findDoctorByUserId(id).getTimeto().substring(0, findDoctorByUserId(id).getTimeto().indexOf(':')));

        if (week == 1 && findDoctorByUserId(id).getSunday() != null ||
                week == 2 && findDoctorByUserId(id).getMonday() != null ||
                week == 3 && findDoctorByUserId(id).getTuesday() != null ||
                week == 4 && findDoctorByUserId(id).getWednesday() != null ||
                week == 5 && findDoctorByUserId(id).getThursday() != null ||
                week == 6 && findDoctorByUserId(id).getFriday() != null ||
                week == 7 && findDoctorByUserId(id).getSaturday() != null) {

            List<ClientDto> clients = clientService.getAllRecords();

            for (int i = time_from; i < time_to; i++){

                String time = i + ":" + "00";

                int count = 0;

                for (ClientDto reg : clients) {
                    if (Objects.equals(reg.getDoctorid(), id) &&
                            Objects.equals(reg.getDateappoitm(), date) &&
                            Objects.equals(reg.getTimeappoitm(), time)){
                        count = 1;
                    }
                }

                if (count == 0) {
                    freetimes.add(time);
                }

            }

        }else{
            throw new NonWorkdayEx("Врач не работает в этот день!");
        }

        return freetimes;

    }



    public String getFioById(String id) {
        String fio = null;
        List<Doctor> doctors = doctorRepository.findAllDoctors();
        for (Doctor doc : doctors) {
            if (doc.getId().equals(id)){
                fio = doc.getLastname() + " " + doc.getFirstname().charAt(0)+ "." + doc.getMiddlename().charAt(0) + ".";
                return fio;
            }
        }
        return fio;
    }





}